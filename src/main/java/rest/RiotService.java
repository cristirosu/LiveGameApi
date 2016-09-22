package rest;

import dto.CurrentGameInfo;
import dto.LeagueDto;
import dto.Summoner;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;
import java.util.Map;

/**
 * Created by User on 9/4/2016.
 */
public interface RiotService {

    String API_KEY = "c32d8269-1ca5-4f11-afbd-ee245e592d8d";

    @GET("api/lol/eune/v1.4/summoner/by-name/{summonerName}?api_key=" + API_KEY)
    Call<Map<String, Summoner>> getBasicSummonerInfo(@Path("summonerName") String summonerName);

    @GET("observer-mode/rest/consumer/getSpectatorGameInfo/EUN1/{summonerId}?api_key=" + API_KEY)
    Call<CurrentGameInfo> getCurrentGameInfoForSummonerId(@Path("summonerId") Long summonerName);

    @GET("api/lol/eune/v2.5/league/by-summoner/{summonerIds}/entry?api_key=" + API_KEY)
    Call<Map<String, List<LeagueDto>>> getLeagueDtoBySummonersIds(@Path("summonerIds") String summonerName);



}