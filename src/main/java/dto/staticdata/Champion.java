package dto.staticdata;

/**
 * Created by User on 9/10/2016.
 */
public class Champion {

    private String id;
    private Long key;
    private String name;
    private ChampionImageInfo image;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getKey() {
        return key;
    }

    public void setKey(Long key) {
        this.key = key;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ChampionImageInfo getImage() {
        return image;
    }

    public void setImage(ChampionImageInfo image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Champion{" +
                "id='" + id + '\'' +
                ", key=" + key +
                ", name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
