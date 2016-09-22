package dto;

import java.util.List;

/**
 * Created by User on 9/4/2016.
 */
public class LeagueDto {

    private List<LeagueEntryDto> entries;
    private String name;
    private String queue;
    private String tier;

    public LeagueDto() {
    }

    public LeagueDto(List<LeagueEntryDto> entries, String name, String queue, String tier) {
        this.entries = entries;
        this.name = name;
        this.queue = queue;
        this.tier = tier;
    }

    public List<LeagueEntryDto> getEntries() {
        return entries;
    }

    public void setEntries(List<LeagueEntryDto> entries) {
        this.entries = entries;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQueue() {
        return queue;
    }

    public void setQueue(String queue) {
        this.queue = queue;
    }

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    @Override
    public String toString() {
        return "LeagueDto{" +
                "entries=" + entries +
                ", name='" + name + '\'' +
                ", queue='" + queue + '\'' +
                ", tier='" + tier + '\'' +
                '}';
    }
}
