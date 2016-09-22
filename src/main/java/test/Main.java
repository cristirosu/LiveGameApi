package test;

import dto.*;
import rest.RiotApiClient;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 9/4/2016.
 */
public class Main {

    public static final String BASE_URL = "https://eune.api.pvp.net/";

    public static void main(String[] args) throws IOException {

        String summonerName = "alx94";

        RiotApiClient riotApiClient = new RiotApiClient();

        Map<String, Summoner> summoners;
        summoners = riotApiClient.getBasicSummonerInfo(summonerName);

        Summoner summoner = summoners.get(summonerName);
        System.out.println(summoner);

        CurrentGameInfo liveGameInfo = riotApiClient.getCurrentGameInfoById(summoner.getId());

        String playerIds = "";

        for (CurrentGameParticipant player : liveGameInfo.getParticipants()) {
            playerIds += player.getSummonerId() + ",";
        }

        System.out.println(playerIds);

        System.out.println(liveGameInfo);

        Map<String, List<LeagueDto>> data = riotApiClient.getLeagueDtoBySummonersIds(playerIds);

        /*for (List<LeagueDto> listOfLeagueDto : data.values()) {
            for (LeagueDto leagueDto : listOfLeagueDto) {
                if (leagueDto.getQueue().equals("RANKED_SOLO_5x5"))
                    for (LeagueEntryDto leagueEntryDto : leagueDto.getEntries()) {
                        System.out.println(leagueEntryDto.getPlayerOrTeamName() + " : " + leagueDto.getTier() + " " + leagueEntryDto.getDivision());
                    }
            }
        }*/

    }

}
