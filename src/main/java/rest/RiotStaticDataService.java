package rest;

import dto.staticdata.StaticChampionData;
import dto.staticdata.StaticMasteriesData;
import dto.staticdata.StaticRuneData;
import dto.staticdata.StaticSummonerSpellData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by User on 9/10/2016.
 */
public interface RiotStaticDataService {

    String API_KEY = "c32d8269-1ca5-4f11-afbd-ee245e592d8d";

    @GET("cdn/6.18.1/data/en_US/champion.json")
    Call<StaticChampionData> getChampionData();

    @GET("cdn/6.18.1/data/en_US/summoner.json")
    Call<StaticSummonerSpellData> getSummonerSpellData();

    @GET("cdn/6.18.1/data/en_US/mastery.json")
    Call<StaticMasteriesData> getMasteriesData();

    @GET("cdn/6.18.1/data/en_US/rune.json")
    Call<StaticRuneData> getRuneData();

}
