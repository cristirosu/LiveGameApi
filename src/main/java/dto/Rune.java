package dto;

/**
 * Created by User on 9/4/2016.
 */
public class Rune {

    private int count;
    private Long runeId;

    public Rune() {
    }

    public Rune(int count, Long runeId) {
        this.count = count;
        this.runeId = runeId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Long getRuneId() {
        return runeId;
    }

    public void setRuneId(Long runeId) {
        this.runeId = runeId;
    }

    @Override
    public String toString() {
        return "Rune{" +
                "count=" + count +
                ", runeId=" + runeId +
                '}';
    }
}
