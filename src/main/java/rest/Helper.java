package rest;

import cache.GlobalCache;
import dto.*;
import dto.response.*;
import dto.staticdata.RuneImageInfo;
import dto.staticdata.RuneStats;
import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by User on 9/9/2016.
 */
public class Helper {

    private static final String KEY_STONES = "6161,6162,6164,6361,6362,6363,6261,6262,6263";
    private static final String basePath = "";

    @Autowired
    RiotApiClient riotApiClient;
    private GlobalCache globalCache = GlobalCache.getInstance();

    public Map<String, List<LeagueDto>> getLeagueInfoFromCurrentGame(CurrentGameInfo liveGameInfo) {
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

    public List<SummonerInfo> getSummonersWithDivisionInfo(Map<String, List<LeagueDto>> data, CurrentGameInfo currentGameInfo) {
        List<SummonerInfo> summoners = new ArrayList<SummonerInfo>();


        for (CurrentGameParticipant participant : currentGameInfo.getParticipants()) {
            boolean isUnranked = true;

            SummonerInfo summonerInfo = new SummonerInfo();
            summonerInfo.setTeamId(participant.getTeamId());
            summonerInfo.setRuneInfo(buildRuneInfoFromGameParticipant(participant));
            summonerInfo.setSummonerName(participant.getSummonerName());
            summonerInfo.setSummonerId(participant.getSummonerId());
            summonerInfo.setChampionName(globalCache.getChampionInfo().get(participant.getChampionId()).getName());
            summonerInfo.setImgInfo(buildImgInfoFromGameParticipant(participant));
            summonerInfo.setRuneInfo(buildRuneInfoFromGameParticipant(participant));

            for (List<LeagueDto> listOfLeagueDto : data.values()) {
                for (LeagueDto leagueDto : listOfLeagueDto) {
                    if (leagueDto.getQueue().equals("RANKED_SOLO_5x5")) {
                        for (LeagueEntryDto leagueEntryDto : leagueDto.getEntries()) {
                            if (summonerInfo.getSummonerName().equals(leagueEntryDto.getPlayerOrTeamName())) {
                                summonerInfo.getImgInfo().setDivisionImg(basePath + leagueDto.getTier().toLowerCase());
                                summonerInfo.setSoloqDivison(buildDivisionFromLeagueEntry(leagueEntryDto, leagueDto));
                                isUnranked = false;
                            }
                        }
                    }
                }
            }

            if(isUnranked){
                summonerInfo.setSoloqDivison(getSoloqForUnranked());
                summonerInfo.getImgInfo().setDivisionImg(basePath + "provisional");
            }

            summoners.add(summonerInfo);
        }
        return summoners;
    }

    private List<RuneInfo> buildRuneInfoFromGameParticipant(CurrentGameParticipant participant) {
        List<RuneInfo> runeInfos = new ArrayList<RuneInfo>();
        for (Rune rune : participant.getRunes()) {
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

    private SoloqDivision getSoloqForUnranked(){
        SoloqDivision soloqDivision = new SoloqDivision();
        soloqDivision.setDivisionName("Unranked");
        soloqDivision.setTier("Unranked");
        soloqDivision.setLosses(0);
        soloqDivision.setWins(0);
        return soloqDivision;
    }

    public List<BannedChampionInfo> getBannedChampionInfoByCurrentGame(CurrentGameInfo currentGame) {
        List<BannedChampionInfo> bannedChampions = new ArrayList<BannedChampionInfo>();
        for (BannedChampion bannedChampion : currentGame.getBannedChampions()) {
            BannedChampionInfo bannedChampionInfo = new BannedChampionInfo();
            bannedChampionInfo.setChampionId(bannedChampion.getChampionId());
            bannedChampionInfo.setTeamId(bannedChampion.getTeamId());
            bannedChampionInfo.setChampionName(globalCache.getChampionInfo().get(bannedChampion.getChampionId()).getName());
            bannedChampionInfo.setBannedChampionImage(globalCache.getChampionInfo().get(bannedChampion.getChampionId()).getImage().getFull());
            bannedChampions.add(bannedChampionInfo);
        }
        return bannedChampions;
    }

    private SoloqDivision buildDivisionFromLeagueEntry(LeagueEntryDto leagueEntry, LeagueDto leagueDto) {
        SoloqDivision soloqDivision = new SoloqDivision();
        soloqDivision.setDivsionRank(leagueEntry.getDivision());
        soloqDivision.setWins(leagueEntry.getWins());
        soloqDivision.setLosses(leagueEntry.getLosses());
        soloqDivision.setDivisionName(leagueDto.getName());
        soloqDivision.setTier(leagueDto.getTier());
        soloqDivision.setQueue(leagueDto.getQueue());

        return soloqDivision;
    }

    public ImgInfo buildImgInfoFromGameParticipant(CurrentGameParticipant participant/*, LeagueDto leagueDto*/) {
        String suffix = ".png";
        ImgInfo imgInfo = new ImgInfo();
        imgInfo.setSummonerSpell1Img(globalCache.getSummonerSpellInfo().get(participant.getSpell1Id()).getId());
        imgInfo.setSummonerSpell2Img(globalCache.getSummonerSpellInfo().get(participant.getSpell2Id()).getId());
        imgInfo.setChampionImg(globalCache.getChampionInfo().get(participant.getChampionId()).getImage().getFull());
        imgInfo.setProfileImg(basePath + participant.getProfileIconId() + suffix);
        imgInfo.setMasteryImg(getKeyStoneForParticipant(participant));

        return imgInfo;
    }

    private String getKeyStoneForParticipant(CurrentGameParticipant participant) {
        for (Mastery mastery : participant.getMasteries()) {
            if (KEY_STONES.contains(String.valueOf(mastery.getMasteryId())))
                return globalCache.getMasteryInfo().get(mastery.getMasteryId()).getImage().getFull();
        }
        return null;
    }

    public String sanitize(String text){
        return text.replaceAll(" ","").toLowerCase();
    }

    public boolean validateSummonerName(String summonerName){
        Pattern p = Pattern.compile("^[Ç ü é â ä à å ç ê ë è ï î ì Ä Å É æ Æ ô ö ò û ù ÿ Ö Ü \u0083 á í ó ú ñ Ñ ª º ß µ \u0088 \u008A \u008C \u008E \u009A \u009C \u009E \u009F À Á Â Ã Ä Å È É Ê Ë Ì Í Î Ï Ð Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü Ý Þ ã ð ý þ a-zA-Z0-9\\\\p{L} _\\\\.]+$");
        Matcher m = p.matcher(summonerName);
        return m.matches();
    }



    public RiotApiClient getRiotApiClient() {
        return riotApiClient;
    }

    public void setRiotApiClient(RiotApiClient riotApiClient) {
        this.riotApiClient = riotApiClient;
    }
}
