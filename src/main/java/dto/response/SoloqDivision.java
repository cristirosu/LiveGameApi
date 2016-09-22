package dto.response;

/**
 * Created by User on 9/4/2016.
 */
public class SoloqDivision {

    private String divisionName;
    private String divsionRank;
    private String tier;
    private String queue;
    private int wins;
    private int losses;

    public SoloqDivision() {
    }

    public SoloqDivision(String divisionName, String divsionRank, String tier, String queue, int wins, int losses) {
        this.divisionName = divisionName;
        this.divsionRank = divsionRank;
        this.tier = tier;
        this.queue = queue;
        this.wins = wins;
        this.losses = losses;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public String getDivsionRank() {
        return divsionRank;
    }

    public void setDivsionRank(String divsionRank) {
        this.divsionRank = divsionRank;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getLosses() {
        return losses;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    @Override
    public String toString() {
        return "SoloqDivision{" +
                "divisionName='" + divisionName + '\'' +
                ", divsionRank='" + divsionRank + '\'' +
                ", tier='" + tier + '\'' +
                ", queue='" + queue + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                '}';
    }
}
