package rest;

import cache.GlobalCache;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.response.RuneInfo;
import dto.staticdata.*;
import org.springframework.stereotype.Component;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.Set;

/**
 * Created by User on 9/10/2016.
 */
public class RiotStaticDataClient {

    private Retrofit retrofit;
    private RiotStaticDataService riotStaticService;
    private GlobalCache globalCache = GlobalCache.getInstance();

    private static final String BASE_URL = "http://ddragon.leagueoflegends.com/";


    public RiotStaticDataClient(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        riotStaticService = retrofit.create(RiotStaticDataService.class);
    }

    public void populateCache(){
        try {
            StaticChampionData staticChampionData = riotStaticService.getChampionData().execute().body();
            StaticSummonerSpellData staticSummonerSpellData = riotStaticService.getSummonerSpellData().execute().body();
            StaticMasteriesData staticMasteriesData = riotStaticService.getMasteriesData().execute().body();
            StaticRuneData staticRuneData = riotStaticService.getRuneData().execute().body();

            for(Champion champion : staticChampionData.getData().values()){
                globalCache.getChampionInfo().put(champion.getKey(), champion);
            }

            for(SummonerSpell summonerSpell : staticSummonerSpellData.getData().values()){
                globalCache.getSummonerSpellInfo().put(summonerSpell.getKey(), summonerSpell);
            }

            for(MasteryInfo masteryInfo : staticMasteriesData.getData().values()){
                globalCache.getMasteryInfo().put(masteryInfo.getId(), masteryInfo);
            }

            for(String runeId : staticRuneData.getData().keySet()){
                globalCache.getRuneInfo().put(runeId, staticRuneData.getData().get(runeId));
            }

            System.out.println(globalCache.getRuneInfo());



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args){
        new RiotStaticDataClient().populateCache();
    }

}
