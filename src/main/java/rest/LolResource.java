package rest;

import cache.GlobalCache;
import dto.*;
import dto.response.SummonerInfo;
import dto.response.LiveGameInfoResponse;
import error.ErrorResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

        Boolean isValidName = helper.validateSummonerName(summonerName);

        if (!isValidName) {
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        }

        summonerName = helper.sanitize(summonerName);

        if (globalCache.getChampionInfo().isEmpty()) {
            riotStaticDataClient.populateCache();
        }

        if (globalCache.getSummoners().get(summonerName) == null) {
            Map<String, Summoner> summoners = riotApiClient.getBasicSummonerInfo(summonerName);
            if (summoners == null) {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity(new ErrorResponse("Summoner " + summonerName + " does not exists"))
                        .header("Access-Control-Allow-Origin", "*")
                        .build();
            }
            globalCache.getSummoners().put(summonerName, summoners.get(summonerName));
        }

        Summoner summoner = globalCache.getSummoners().get(summonerName);
        CurrentGameInfo currentGameInfo = riotApiClient.getCurrentGameInfoById(summoner.getId());

        if (currentGameInfo == null) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ErrorResponse("Summoner " + summonerName + " is not in an active game"))
                    .header("Access-Control-Allow-Origin", "*")
                    .build();
        }

        System.out.println(currentGameInfo);

        Map<String, List<LeagueDto>> leaguesInfo = helper.getLeagueInfoFromCurrentGame(currentGameInfo);

        System.out.println(leaguesInfo);

        LiveGameInfoResponse liveGameResponse = new LiveGameInfoResponse();
        System.out.println(liveGameResponse);

        liveGameResponse.setGameId(currentGameInfo.getGameId());
        liveGameResponse.setBannedChampions(helper.getBannedChampionInfoByCurrentGame(currentGameInfo));

        List<SummonerInfo> summonersWithLeagueInfo = helper.getSummonersWithDivisionInfo(leaguesInfo, currentGameInfo);
        liveGameResponse.setSummoners(summonersWithLeagueInfo);

        System.out.println(globalCache.getSummoners());

        return Response.status(200).header("Access-Control-Allow-Origin", "*").entity(liveGameResponse).build();
    }

    @GET
    @Path("/closePc")
    public void closePc() throws IOException {
        Runtime runtime = Runtime.getRuntime();
        Process proc = runtime.exec("shutdown -s -t 0");
        System.exit(0);
    }


}
