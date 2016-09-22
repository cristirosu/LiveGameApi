package dto.response;

import dto.BannedChampion;

import java.util.List;

/**
 * Created by User on 9/4/2016.
 */
public class LiveGameInfoResponse {

    private Long gameId;
    private Long gameLength;
    private Long gameStarTime;
    private List<BannedChampionInfo> bannedChampions;
    private List<SummonerInfo> summoners;

    public LiveGameInfoResponse() {
    }


    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Long getGameLength() {
        return gameLength;
    }

    public void setGameLength(Long gameLength) {
        this.gameLength = gameLength;
    }

    public Long getGameStarTime() {
        return gameStarTime;
    }

    public void setGameStarTime(Long gameStarTime) {
        this.gameStarTime = gameStarTime;
    }

    public List<BannedChampionInfo> getBannedChampions() {
        return bannedChampions;
    }

    public void setBannedChampions(List<BannedChampionInfo> bannedChampions) {
        this.bannedChampions = bannedChampions;
    }

    public List<SummonerInfo> getSummoners() {
        return summoners;
    }

    public void setSummoners(List<SummonerInfo> summoners) {
        this.summoners = summoners;
    }

    @Override
    public String toString() {
        return "LiveGameInfoResponse{" +
                "gameId=" + gameId +
                ", gameLength=" + gameLength +
                ", gameStarTime=" + gameStarTime +
                ", bannedChampions=" + bannedChampions +
                ", summoners=" + summoners +
                '}';
    }
}
