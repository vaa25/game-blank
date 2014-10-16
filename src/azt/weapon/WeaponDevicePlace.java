package azt.weapon;

/**
 * Посадочное место для приборов
 *
 * @author Alexander Vlasov
 */
public class WeaponDevicePlace {
    private String name;
    private WeaponDevice device;


    public WeaponDevice install(WeaponDevice newDevice) {
        WeaponDevice was = device;
        device = newDevice;
        return was;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        WeaponDevicePlace that = (WeaponDevicePlace) o;

        if (!name.equals(that.name)) return false;

        return true;
    }

    public boolean isEmpty() {
        return device == null;
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
