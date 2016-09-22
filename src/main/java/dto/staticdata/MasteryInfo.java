package dto.staticdata;

/**
 * Created by User on 9/11/2016.
 */
public class MasteryInfo {

    private Long id;
    private String name;
    private MasteryImageInfo image;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MasteryImageInfo getImage() {
        return image;
    }

    public void setImage(MasteryImageInfo image) {
        this.image = image;
    }



    @Override
    public String toString() {
        return "MasteryInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", image=" + image +
                '}';
    }
}
