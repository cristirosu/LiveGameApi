package dto;

/**
 * Created by User on 9/4/2016.
 */
public class Mastery {

    private Long masteryId;
    private int rank;

    public Mastery() {
    }

    public Mastery(Long masteryId, int rank) {
        this.masteryId = masteryId;
        this.rank = rank;
    }

    public Long getMasteryId() {
        return masteryId;
    }

    public void setMasteryId(Long masteryId) {
        this.masteryId = masteryId;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    @Override
    public String toString() {
        return "Mastery{" +
                "masteryId=" + masteryId +
                ", rank=" + rank +
                '}';
    }
}
