package dto;

/**
 * Created by User on 9/4/2016.
 */
public class BannedChampion {

    private Long championId;
    private int pickTurn;
    private Long teamId;

    public BannedChampion() {
    }

    public BannedChampion(Long championId, int pickTurn, Long teamId) {
        this.championId = championId;
        this.pickTurn = pickTurn;
        this.teamId = teamId;
    }

    public Long getChampionId() {
        return championId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    public int getPickTurn() {
        return pickTurn;
    }

    public void setPickTurn(int pickTurn) {
        this.pickTurn = pickTurn;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    @Override
    public String toString() {
        return "BannedChampion{" +
                "championId=" + championId +
                ", pickTurn=" + pickTurn +
                ", teamId=" + teamId +
                '}';
    }
}
