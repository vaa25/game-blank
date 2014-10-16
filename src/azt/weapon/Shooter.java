package azt.weapon;

import azt.Coord;

/**
 * Стрелок
 *
 * @author Alexander Vlasov
 */
public class Shooter {
    private double accuracy;
    private double quickness;
    private double adrenaline;
    private WeaponSample weaponSample;
    private Coord coord;

    public double getAccuracy() {
        return accuracy;
    }

    public double getQuickness() {
        return quickness;
    }

    public double getAdrenaline() {
        return adrenaline;
    }

    public WeaponSample getWeaponSample() {
        return weaponSample;
    }

    public Coord getCoord() {
        return coord;
    }

    public double getAccuracy(int range) {
        return weaponSample.getAccuracy(range) * accuracy / adrenaline;
    }
}
