package rest;

import cache.GlobalCache;
import dto.*;
import dto.response.SummonerInfo;
import dto.response.LiveGameInfoResponse;
import org.springframework.beans.factory.annotation.Autowired;

import javax.ws.rs.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 9/4/2016.
 */
@Path("/lolapi")
@Produces("application/json")
public class LolResource {

    @Autowired
    RiotApiClient riotApiClient;

    @Autowired
    Helper helper;

    GlobalCache globalCache = GlobalCache.getInstance();

    @Autowired
    RiotStaticDataClient riotStaticDataClient;

    @GET
    @Path("/currentGameInfo")
    public Response getCurrentGameInfo(@QueryParam("summonerName") String summonerName) throws IOException {

        System.out.println(globalCache);

        if (globalCache.getChampionInfo().isEmpty()){
            riotStaticDataClient.populateCache();
        }


        Map<String, Summoner> summoners = riotApiClient.getBasicSummonerInfo(summonerName);
        Summoner summoner = summoners.get(summonerName);

        CurrentGameInfo currentGameInfo = riotApiClient.getCurrentGameInfoById(summoner.getId());

        System.out.println(currentGameInfo);

        Map<String, List<LeagueDto>> leaguesInfo = helper.getLeagueInfoFromCurrentGame(currentGameInfo);

        System.out.println(leaguesInfo);

        LiveGameInfoResponse liveGameResponse = new LiveGameInfoResponse();
        System.out.println(liveGameResponse);

        liveGameResponse.setGameId(currentGameInfo.getGameId());
        liveGameResponse.setBannedChampions(helper.getBannedChampionInfoByCurrentGame(currentGameInfo));

        List<SummonerInfo> summonersWithLeagueInfo = helper.getSummonersWithDivisionInfo(leaguesInfo, currentGameInfo);
        liveGameResponse.setSummoners(summonersWithLeagueInfo);

        return Response.status(200).entity(liveGameResponse).build();
    }

    @GET
    @Path("/closePc")
    public void closePc() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec("shutdown -s -t 0");
        System.exit(0);
    }


}
