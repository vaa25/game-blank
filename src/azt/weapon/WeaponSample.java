package azt.weapon;

/**
 * Оружие
 *
 * @author Alexander Vlasov
 */
public class WeaponSample {
    private int range;
    private double accuracy;
    private Magazine[] magazines;
    private WeaponDiagram weaponDiagram;
    private WeaponDevicePlace[] devicePlaces;
    private int weight;
    private String name;

    public boolean check(Magazine object) {
        for (Magazine object2 : magazines) {
            if (object2.equals(object)) return true;
        }
        return false;
    }

    public boolean check(WeaponDevicePlace object) {
        for (WeaponDevicePlace object2 : devicePlaces) {
            if (object2.equals(object)) return true;
        }
        return false;
    }

    public double getAccuracy(int range) {
        return weaponDiagram.get(range);
    }

}
