package dto.response;

import dto.staticdata.RuneImageInfo;
import dto.staticdata.RuneStats;

/**
 * Created by User on 9/11/2016.
 */
public class RuneInfo {

    private String name;
    private int count;
    private RuneImageInfo image;
    private String description;
    private RuneStats stats;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public RuneImageInfo getImage() {
        return image;
    }

    public void setImage(RuneImageInfo image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RuneStats getStats() {
        return stats;
    }

    public void setStats(RuneStats stats) {
        this.stats = stats;
    }

    @Override
    public String toString() {
        return "RuneInfo{" +
                "name='" + name + '\'' +
                ", count=" + count +
                ", image=" + image +
                ", description='" + description + '\'' +
                ", runeStats=" + stats +
                '}';
    }
}
