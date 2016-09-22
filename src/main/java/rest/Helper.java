package rest;

import cache.GlobalCache;
import dto.*;
import dto.response.*;
import dto.staticdata.RuneImageInfo;
import dto.staticdata.RuneStats;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by User on 9/9/2016.
 */
public class Helper {

    private static final String KEY_STONES = "6161,6162,6164,6361,6362,6363,6261,6262,6263";

    @Autowired
    RiotApiClient riotApiClient;
    private GlobalCache globalCache = GlobalCache.getInstance();

    public Map<String, List<LeagueDto>> getLeagueInfoFromCurrentGame(CurrentGameInfo liveGameInfo){
        Map<String, List<LeagueDto>> data;
        String playerIds = "";
        for (CurrentGameParticipant player : liveGameInfo.getParticipants()) {
            playerIds += player.getSummonerId() + ",";
        }

        try {
            data = riotApiClient.getLeagueDtoBySummonersIds(playerIds);
            return data;
        } catch (IOException e) {
            e.printStackTrace();
            return new HashMap<String, List<LeagueDto>>();
        }

    }

    public List<SummonerInfo> getSummonersWithDivisionInfo(Map<String, List<LeagueDto>> data, CurrentGameInfo currentGameInfo){
        List<SummonerInfo> summoners = new ArrayList<SummonerInfo>();

        for (List<LeagueDto> listOfLeagueDto : data.values()) {
            for (LeagueDto leagueDto : listOfLeagueDto) {
                if (leagueDto.getQueue().equals("RANKED_SOLO_5x5")) {
                    for (LeagueEntryDto leagueEntryDto : leagueDto.getEntries()) {
                        SummonerInfo summonerInfo = new SummonerInfo();

                        SoloqDivision division = buildDivisionFromLeagueEntry(leagueEntryDto, leagueDto);
                        summonerInfo.setSoloqDivison(division);
                        summonerInfo.setSummonerName(leagueEntryDto.getPlayerOrTeamName());
                        summonerInfo.setSummonerId(Long.valueOf(leagueEntryDto.getPlayerOrTeamId()));

                        for(CurrentGameParticipant participant : currentGameInfo.getParticipants()){
                            if(participant.getSummonerName().equals(summonerInfo.getSummonerName())){
                                summonerInfo.setTeamId(participant.getTeamId());
                                summonerInfo.setRuneInfo(buildRuneInfoFromGameParticipant(participant));
                                summonerInfo.setImgInfo(buildImgInfoFromGameParticipant(participant, leagueDto));
                            }
                        }
                        summoners.add(summonerInfo);
                    }
                }
            }
        }

        return summoners;
    }

    private List<RuneInfo> buildRuneInfoFromGameParticipant(CurrentGameParticipant participant){
        List<RuneInfo> runeInfos = new ArrayList<RuneInfo>();
        for(Rune rune : participant.getRunes()){
            RuneInfo runeInfo = new RuneInfo();
            RuneImageInfo runeImageInfo = new RuneImageInfo();
            RuneStats runeStats = new RuneStats();

            runeImageInfo.setFull(globalCache.getRuneInfo().get(String.valueOf(rune.getRuneId())).getImage().getFull());
            runeStats.setFlatPhysicalDamageMod(globalCache.getRuneInfo().get(String.valueOf(rune.getRuneId())).getStats().getFlatPhysicalDamageMod());

            runeInfo.setCount(rune.getCount());
            runeInfo.setDescription(globalCache.getRuneInfo().get(String.valueOf(rune.getRuneId())).getDescription());
            runeInfo.setName(globalCache.getRuneInfo().get(String.valueOf(rune.getRuneId())).getName());
            runeInfo.setImage(runeImageInfo);
            runeInfo.setStats(runeStats);

            runeInfos.add(runeInfo);
        }

        return runeInfos;
    }

    public List<BannedChampionInfo> getBannedChampionInfoByCurrentGame(CurrentGameInfo currentGame){
        List<BannedChampionInfo> bannedChampions = new ArrayList<BannedChampionInfo>();
        for(BannedChampion bannedChampion : currentGame.getBannedChampions()){
            BannedChampionInfo bannedChampionInfo = new BannedChampionInfo();
            bannedChampionInfo.setChampionId(bannedChampion.getChampionId());
            bannedChampionInfo.setTeamId(bannedChampion.getTeamId());
            bannedChampionInfo.setChampionName(globalCache.getChampionInfo().get(bannedChampion.getChampionId()).getName());
            bannedChampionInfo.setBannedChampionImage(globalCache.getChampionInfo().get(bannedChampion.getChampionId()).getImage().getFull());
            bannedChampions.add(bannedChampionInfo);
        }
        return bannedChampions;
    }

    private SoloqDivision buildDivisionFromLeagueEntry(LeagueEntryDto leagueEntry, LeagueDto leagueDto){
        SoloqDivision soloqDivision = new SoloqDivision();
        soloqDivision.setDivsionRank(leagueEntry.getDivision());
        soloqDivision.setWins(leagueEntry.getWins());
        soloqDivision.setLosses(leagueEntry.getLosses());
        soloqDivision.setDivisionName(leagueDto.getName());
        soloqDivision.setTier(leagueDto.getTier());
        soloqDivision.setQueue(leagueDto.getQueue());

        return soloqDivision;
    }

    public ImgInfo buildImgInfoFromGameParticipant(CurrentGameParticipant participant, LeagueDto leagueDto){
        String basePath = "";
        String suffix = ".png";
        ImgInfo imgInfo = new ImgInfo();
        imgInfo.setSummonerSpell1Img(globalCache.getSummonerSpellInfo().get(participant.getSpell1Id()).getId());
        imgInfo.setSummonerSpell2Img(globalCache.getSummonerSpellInfo().get(participant.getSpell2Id()).getId());
        imgInfo.setChampionImg(globalCache.getChampionInfo().get(participant.getChampionId()).getImage().getFull());
        imgInfo.setProfileImg(basePath + participant.getProfileIconId() + suffix);
        imgInfo.setMasteryImg(getKeyStoneForParticipant(participant));
        imgInfo.setDivisionImg(basePath + leagueDto.getTier().toLowerCase());

        return imgInfo;
    }

    private String getKeyStoneForParticipant(CurrentGameParticipant participant){
        for(Mastery mastery: participant.getMasteries()){
            if(KEY_STONES.contains( String.valueOf(mastery.getMasteryId())))
                return globalCache.getMasteryInfo().get(mastery.getMasteryId()).getImage().getFull();
        }
        return null;
    }


    public RiotApiClient getRiotApiClient() {
        return riotApiClient;
    }

    public void setRiotApiClient(RiotApiClient riotApiClient) {
        this.riotApiClient = riotApiClient;
    }
}
