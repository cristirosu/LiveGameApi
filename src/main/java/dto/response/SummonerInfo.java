package dto.response;

import dto.Mastery;
import dto.Rune;

import java.util.List;

/**
 * Created by User on 9/4/2016.
 */
public class SummonerInfo {

    private String summonerName;
    private Long summonerId;
    private String championName;
    private Long teamId;
    private ImgInfo imgInfo;
    private SoloqDivision soloqDivison;
    private List<RuneInfo> runeInfo;

    public SummonerInfo() {
    }


    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public Long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(Long summonerId) {
        this.summonerId = summonerId;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public ImgInfo getImgInfo() {
        return imgInfo;
    }

    public void setImgInfo(ImgInfo imgInfo) {
        this.imgInfo = imgInfo;
    }

    public SoloqDivision getSoloqDivison() {
        return soloqDivison;
    }

    public void setSoloqDivison(SoloqDivision soloqDivison) {
        this.soloqDivison = soloqDivison;
    }

    public List<RuneInfo> getRuneInfo() {
        return runeInfo;
    }

    public void setRuneInfo(List<RuneInfo> runeInfo) {
        this.runeInfo = runeInfo;
    }

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    @Override
    public String toString() {
        return "SummonerInfo{" +
                "summonerName='" + summonerName + '\'' +
                ", summonerId=" + summonerId +
                ", championName='" + championName + '\'' +
                ", teamId=" + teamId +
                ", imgInfo=" + imgInfo +
                ", soloqDivison=" + soloqDivison +
                ", runes=" + runeInfo +
                '}';
    }
}
