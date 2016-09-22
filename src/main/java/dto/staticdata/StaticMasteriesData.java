package dto.staticdata;

import java.util.Map;

/**
 * Created by User on 9/11/2016.
 */
public class StaticMasteriesData {

    private String type;
    private Map<String, MasteryInfo> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, MasteryInfo> getData() {
        return data;
    }

    public void setData(Map<String, MasteryInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StaticMasteriesData{" +
                "type='" + type + '\'' +
                ", masteryInfo=" + data +
                '}';
    }
}
