package dto;

import java.util.List;

/**
 * Created by User on 9/4/2016.
 */
public class CurrentGameInfo {

    private List<BannedChampion> bannedChampions;
    private Long gameId;
    private Long gameLength;
    private String gameMode;
    private List<CurrentGameParticipant> participants;

    public CurrentGameInfo() {
    }

    public CurrentGameInfo(List<BannedChampion> bannedChampions, Long gameId, Long gameLength, String gameMode, List<CurrentGameParticipant> participants) {
        this.bannedChampions = bannedChampions;
        this.gameId = gameId;
        this.gameLength = gameLength;
        this.gameMode = gameMode;
        this.participants = participants;
    }

    public List<BannedChampion> getBannedChampions() {
        return bannedChampions;
    }

    public void setBannedChampions(List<BannedChampion> bannedChampions) {
        this.bannedChampions = bannedChampions;
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

    public String getGameMode() {
        return gameMode;
    }

    public void setGameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public List<CurrentGameParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(List<CurrentGameParticipant> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        return "CurrentGameInfo{" +
                "bannedChampions=" + bannedChampions +
                ", gameId=" + gameId +
                ", gameLength=" + gameLength +
                ", gameMode='" + gameMode + '\'' +
                ", participants=" + participants +
                '}';
    }
}
