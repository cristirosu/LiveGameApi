package cache;

import dto.Mastery;
import dto.response.RuneInfo;
import dto.staticdata.Champion;
import dto.staticdata.MasteryInfo;
import dto.staticdata.SummonerSpell;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 9/10/2016.
 */
public class GlobalCache {

    private Map<Long, Champion> championInfo = new HashMap<Long, Champion>();
    private Map<Long, SummonerSpell> summonerSpellInfo = new HashMap<Long, SummonerSpell>();
    private Map<Long, MasteryInfo> masteryInfo = new HashMap<Long, MasteryInfo>();
    private Map<String, RuneInfo> runeInfo = new HashMap<String, RuneInfo>();
    public static GlobalCache instance;

    public Map<Long, Champion> getChampionInfo() {
        return championInfo;
    }

    public void setChampionInfo(Map<Long, Champion> championInfo) {
        this.championInfo = championInfo;
    }

    public Map<Long, SummonerSpell> getSummonerSpellInfo() {
        return summonerSpellInfo;
    }

    public void setSummonerSpellInfo(Map<Long, SummonerSpell> summonerSpellInfo) {
        this.summonerSpellInfo = summonerSpellInfo;
    }

    public Map<Long, MasteryInfo> getMasteryInfo() {
        return masteryInfo;
    }

    public Map<String, RuneInfo> getRuneInfo() {
        return runeInfo;
    }

    public void setRuneInfo(Map<String, RuneInfo> runeInfo) {
        this.runeInfo = runeInfo;
    }

    public void setMasteryInfo(Map<Long, MasteryInfo> masteryInfo) {
        this.masteryInfo = masteryInfo;
    }

    public static GlobalCache getInstance(){
        if(instance != null){
            return instance;
        }
        else{
            instance = new GlobalCache();
            return instance;
        }
    }

    @Override
    public String toString() {
        return "GlobalCache{" +
                "championInfo=" + championInfo +
                ", summonerSpellInfo=" + summonerSpellInfo +
                ", masteryInfo=" + masteryInfo +
                '}';
    }
}
