package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.CurrentGameInfo;
import dto.LeagueDto;
import dto.Summoner;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 9/4/2016.
 */
public class RiotApiClient {

    private Retrofit retrofit;
    private RiotService riotService;

    private static final String BASE_URL = "https://eune.api.pvp.net/";

    public RiotApiClient(){
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ssZ")
                .create();

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        riotService = retrofit.create(RiotService.class);
    }

    public Map<String, Summoner> getBasicSummonerInfo(String summonerName) throws IOException {
        Map<String, Summoner> summoners = riotService.getBasicSummonerInfo(summonerName).execute().body();

        return summoners;
    }

    public CurrentGameInfo getCurrentGameInfoById(Long summonerId) throws IOException {
        CurrentGameInfo currentGameInfo = riotService.getCurrentGameInfoForSummonerId(summonerId).execute().body();

        return currentGameInfo;
    }

    public Map<String, List<LeagueDto>> getLeagueDtoBySummonersIds(String summonerIds) throws IOException {
        Map<String, List<LeagueDto>> leagueDto = riotService.getLeagueDtoBySummonersIds(summonerIds).execute().body();

        System.out.println(leagueDto);

        return leagueDto;
    }

}
