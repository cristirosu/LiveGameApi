package dto.staticdata;

import com.google.gson.annotations.SerializedName;

/**
 * Created by User on 9/11/2016.
 */
public class SummonerSpell {

    @SerializedName("id")
    private String id;
    @SerializedName("key")
    private Long key;

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

    @Override
    public String toString() {
        return "SummonerSpell{" +
                "id='" + id + '\'' +
                ", key=" + key +
                '}';
    }
}
