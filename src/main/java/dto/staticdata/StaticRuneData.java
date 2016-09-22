package dto.staticdata;

import dto.response.RuneInfo;

import java.util.Map;

/**
 * Created by User on 9/11/2016.
 */
public class StaticRuneData {

    private String type;
    private Map<String, RuneInfo> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, RuneInfo> getData() {
        return data;
    }

    public void setData(Map<String, RuneInfo> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StaticRuneData{" +
                "type='" + type + '\'' +
                ", data=" + data +
                '}';
    }
}
