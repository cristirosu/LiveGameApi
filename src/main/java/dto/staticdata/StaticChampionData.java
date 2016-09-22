package dto.staticdata;

import java.util.Map;

/**
 * Created by User on 9/10/2016.
 */
public class StaticChampionData {

    private String type;
    private Map<String, Champion> data;


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, Champion> getData() {
        return data;
    }

    public void setData(Map<String, Champion> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StaticChampionData{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
