package dto.response;

/**
 * Created by User on 9/4/2016.
 */
public class ImgInfo {

    public static final String CHAMPION_IMG_BASE_PATH = "http://ddragon.leagueoflegends.com/cdn/6.18.1/img/champion/";
    public static final String RUNE_IMG_BASE_PATH = "http://ddragon.leagueoflegends.com/cdn/6.18.1/img/rune/";
    private static final String PROFILE_IMG_BASE_PATH = "http://ddragon.leagueoflegends.com/cdn/6.18.1/img/profileicon/";
    private static final String SUMMONER_SPELL_IMG_BASE_PATH = "http://ddragon.leagueoflegends.com/cdn/6.18.1/img/spell/";
    private static final String MASTERY_IMG_BASE_PATH = "http://ddragon.leagueoflegends.com/cdn/6.18.1/img/mastery/";
    private static final String DIVISION_IMG_BASE_PATH = "http://localhost:8080/RESTfulExample/base_icons/";
    private static final String IMG_EXTENSION = ".png";
    private String championImg;
    private String summonerSpell1Img;
    private String summonerSpell2Img;
    private String divisionImg;
    private String masteryImg;
    private String profileImg;

    public ImgInfo() {
    }


    public String getProfileImg() {
        return profileImg;
    }

    public void setProfileImg(String profileImg) {
        this.profileImg = PROFILE_IMG_BASE_PATH + profileImg;
    }

    public String getMasteryImg() {
        return masteryImg;
    }

    public void setMasteryImg(String masteryImg) {
        this.masteryImg = MASTERY_IMG_BASE_PATH + masteryImg;
    }


    public String getChampionImg() {
        return championImg;
    }

    public void setChampionImg(String championImg) {
        this.championImg = CHAMPION_IMG_BASE_PATH + championImg;
    }

    public String getSummonerSpell1Img() {
        return summonerSpell1Img;
    }

    public void setSummonerSpell1Img(String summonerSpell1Img) {
        this.summonerSpell1Img = SUMMONER_SPELL_IMG_BASE_PATH + summonerSpell1Img + IMG_EXTENSION;
    }

    public String getSummonerSpell2Img() {
        return summonerSpell2Img;
    }

    public void setSummonerSpell2Img(String summonerSpell2Img) {
        this.summonerSpell2Img = SUMMONER_SPELL_IMG_BASE_PATH + summonerSpell2Img + IMG_EXTENSION;
    }

    public String getDivisionImg() {
        return divisionImg;
    }

    public void setDivisionImg(String divisionImg) {
        this.divisionImg = DIVISION_IMG_BASE_PATH + divisionImg + IMG_EXTENSION;
    }

    @Override
    public String toString() {
        return "ImgInfo{" +
                "championImg='" + championImg + '\'' +
                ", summonerSpell1Img='" + summonerSpell1Img + '\'' +
                ", summonerSpell2Img='" + summonerSpell2Img + '\'' +
                ", divisionImg='" + divisionImg + '\'' +
                '}';
    }
}
