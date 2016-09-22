package dto.response;

/**
 * Created by User on 9/11/2016.
 */
public class BannedChampionInfo {

    private String championName;
    private String bannedChampionImage;
    private Long teamId;
    private Long championId;

    public String getChampionName() {
        return championName;
    }

    public void setChampionName(String championName) {
        this.championName = championName;
    }

    public String getBannedChampionImage() {
        return bannedChampionImage;
    }

    public void setBannedChampionImage(String bannedChampionImage) {
        this.bannedChampionImage = ImgInfo.CHAMPION_IMG_BASE_PATH + bannedChampionImage;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public Long getChampionId() {
        return championId;
    }

    public void setChampionId(Long championId) {
        this.championId = championId;
    }

    @Override
    public String toString() {
        return "BannedChampionInfo{" +
                "championName='" + championName + '\'' +
                ", bannedChampionImage='" + bannedChampionImage + '\'' +
                ", teamId=" + teamId +
                ", championId=" + championId +
                '}';
    }
}
