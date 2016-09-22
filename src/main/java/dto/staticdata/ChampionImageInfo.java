package dto.staticdata;

/**
 * Created by User on 9/10/2016.
 */
public class ChampionImageInfo {

    private String full;
    private String sprite;


    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = full;
    }

    public String getSprite() {
        return sprite;
    }

    public void setSprite(String sprite) {
        this.sprite = sprite;
    }

    @Override
    public String toString() {
        return "ChampionImageInfo{" +
                "full='" + full + '\'' +
                ", sprite='" + sprite + '\'' +
                '}';
    }
}
