package dto.staticdata;

        import dto.response.ImgInfo;

/**
 * Created by User on 9/11/2016.
 */
public class RuneImageInfo {

    private String full;

    public String getFull() {
        return full;
    }

    public void setFull(String full) {
        this.full = ImgInfo.RUNE_IMG_BASE_PATH + full;
    }

    @Override
    public String toString() {
        return "RuneImageInfo{" +
                "full='" + full + '\'' +
                '}';
    }
}
