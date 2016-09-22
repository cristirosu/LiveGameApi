package dto.staticdata;

import java.util.Map;

/**
 * Created by User on 9/11/2016.
 */
public class StaticSummonerSpellData {

    private String type;
    private Map<String, SummonerSpell> data;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Map<String, SummonerSpell> getData() {
        return data;
    }

    public void setData(Map<String, SummonerSpell> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "StaticSummonerSpellData{" +
                "type='" + type + '\'' +
                ", summonerSpells=" + data +
                '}';
    }
}
