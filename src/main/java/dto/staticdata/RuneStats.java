package dto.staticdata;

/**
 * Created by User on 9/11/2016.
 */
public class RuneStats {

    private double FlatPhysicalDamageMod;

    public double getFlatPhysicalDamageMod() {
        return FlatPhysicalDamageMod;
    }

    public void setFlatPhysicalDamageMod(double flatPhysicalDamageMod) {
        FlatPhysicalDamageMod = flatPhysicalDamageMod;
    }

    @Override
    public String toString() {
        return "RuneStats{" +
                "FlatPhysicalDamageMod=" + FlatPhysicalDamageMod +
                '}';
    }
}
