package dto;

/**
 * Created by User on 9/4/2016.
 */
public class LeagueEntryDto {

    private String division;
    private boolean isFreshBlood;
    private boolean isHotStreak;
    private boolean isInactive;
    private boolean isVeteran;
    private int leaguePoints;
    private int losses;
    private MiniSeriesDto miniSeries;
    private String playerOrTeamId;
    private String playerOrTeamName;
    private String playstyle;
    private int wins;

    public LeagueEntryDto() {
    }

    public LeagueEntryDto(String division, boolean isFreshBlood, boolean isHotStreak, boolean isInactive, boolean isVeteran, int leaguePoints, int losses, MiniSeriesDto miniSeries, String playerOrTeamId, String playerOrTeamName, String playstyle, int wins) {
        this.division = division;
        this.isFreshBlood = isFreshBlood;
        this.isHotStreak = isHotStreak;
        this.isInactive = isInactive;
        this.isVeteran = isVeteran;
        this.leaguePoints = leaguePoints;
        this.losses = losses;
        this.miniSeries = miniSeries;
        this.playerOrTeamId = playerOrTeamId;
        this.playerOrTeamName = playerOrTeamName;
        this.playstyle = playstyle;
        this.wins = wins;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public boolean isFreshBlood() {
        return isFreshBlood;
    }

    public void setFreshBlood(boolean freshBlood) {
        isFreshBlood = freshBlood;
    }

    public boolean isHotStreak() {
        return isHotStreak;
    }

    public void setHotStreak(boolean hotStreak) {
        isHotStreak = hotStreak;
    }

    public boolean isInactive() {
        return isInactive;
    }

    public void setInactive(boolean inactive) {
        isInactive = inactive;
    }

    public boolean isVeteran() {
        return isVeteran;
    }

    public void setVeteran(boolean veteran) {
        isVeteran = veteran;
    }

    public int getLeaguePoints() {
        return leaguePoints;
    }

    public void setLeaguePoints(int leaguePoints) {
        this.leaguePoints = leaguePoints;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public MiniSeriesDto getMiniSeries() {
        return miniSeries;
    }

    public void setMiniSeries(MiniSeriesDto miniSeries) {
        this.miniSeries = miniSeries;
    }

    public String getPlayerOrTeamId() {
        return playerOrTeamId;
    }

    public void setPlayerOrTeamId(String playerOrTeamId) {
        this.playerOrTeamId = playerOrTeamId;
    }

    public String getPlayerOrTeamName() {
        return playerOrTeamName;
    }

    public void setPlayerOrTeamName(String playerOrTeamName) {
        this.playerOrTeamName = playerOrTeamName;
    }

    public String getPlaystyle() {
        return playstyle;
    }

    public void setPlaystyle(String playstyle) {
        this.playstyle = playstyle;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    @Override
    public String toString() {
        return "LeagueEntryDto{" +
                "division='" + division + '\'' +
                ", isFreshBlood=" + isFreshBlood +
                ", isHotStreak=" + isHotStreak +
                ", isInactive=" + isInactive +
                ", isVeteran=" + isVeteran +
                ", leaguePoints=" + leaguePoints +
                ", losses=" + losses +
                ", miniSeries=" + miniSeries +
                ", playerOrTeamId='" + playerOrTeamId + '\'' +
                ", playerOrTeamName='" + playerOrTeamName + '\'' +
                ", playstyle='" + playstyle + '\'' +
                ", wins=" + wins +
                '}';
    }
}
