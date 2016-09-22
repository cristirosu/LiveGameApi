package dto;

import java.util.List;

/**
 * Created by User on 9/4/2016.
 */
public class CurrentGameParticipant {

    private boolean bot;
    private Long championId;
    private List<Mastery> masteries;
    private Long profileIconId;
    private List<Rune> runes;
    private Long spell1Id;
    private Long spell2Id;
    private Long summonerId;
    private String summonerName;
    private Long teamId;

    public CurrentGameParticipant() {
    }

    public CurrentGameParticipant(boolean bot, Long championId, List<Mastery> masteries, Long profileIconId, List<Rune> runes, Long spell1Id, Long spell2Id, Long summonerId, String summonerName, Long teamId) {
        this.bot = bot;
        this.championId = championId;
        this.masteries = masteries;
        this.profileIconId = profileIconId;
        this.runes = runes;
        this.spell1Id = spell1Id;
        this.spell2Id = spell2Id;
        this.summonerId = summonerId;
        this.summonerName = summonerName;
        this.teamId = teamId;
    }

    public boolean isBot() {
        return bot;
    }

    public void setBot(boolean bot) {
        this.bot = bot;
    }

    public Long getChampionId() {
        return championId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    public List<Mastery> getMasteries() {
        return masteries;
    }

    public void setMasteries(List<Mastery> masteries) {
        this.masteries = masteries;
    }

    public Long getProfileIconId() {
        return profileIconId;
    }

    public void setProfileIconId(Long profileIconId) {
        this.profileIconId = profileIconId;
    }

    public List<Rune> getRunes() {
        return runes;
    }

    public void setRunes(List<Rune> runes) {
        this.runes = runes;
    }

    public Long getSpell1Id() {
        return spell1Id;
    }

    public void setSpell1Id(Long spell1Id) {
        this.spell1Id = spell1Id;
    }

    public Long getSpell2Id() {
        return spell2Id;
    }

    public void setSpell2Id(Long spell2Id) {
        this.spell2Id = spell2Id;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }

    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "CurrentGameParticipant{" +
                "bot=" + bot +
                ", championId=" + championId +
                ", masteries=" + masteries +
                ", profileIconId=" + profileIconId +
                ", runes=" + runes +
                ", spell1Id=" + spell1Id +
                ", spell2Id=" + spell2Id +
                ", summonerId=" + summonerId +
                ", summonerName=" + summonerName +
                ", teamId=" + teamId +
                '}';
    }
}
