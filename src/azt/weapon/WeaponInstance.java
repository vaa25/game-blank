package azt.weapon;

import java.util.List;

/**
 * @author Alexander Vlasov
 */
public class WeaponInstance {
    private Magazine magazine;
    private List<WeaponDevicePlace> places;
    private WeaponSample sample;


    /**
     * Устанавливает в оружие магазин
     *
     * @param magazine
     *
     * @return замененный магазин, либо null если магазина вообще не было
     *
     * @throws WrongMagazineException если магазин не подходит
     */
    public Magazine install(Magazine magazine) throws WrongMagazineException {
        if (sample.check(magazine)) {
            Magazine was = this.magazine;
            this.magazine = magazine;
            return was;
        } else {
            throw new WrongMagazineException();
        }
    }

    public double getAccuracy(int range) {
        return sample.getAccuracy(range);
    }

    /**
     * Устанавливает прибор на оружие если возможно
     *
     * @param device
     *
     * @return прибор, который стоял до этого, или null, если ничего не стояло
     *
     * @throws WrongWeaponDeviceException если магазин не подходит
     */
    public WeaponDevice install(WeaponDevice device) throws WrongWeaponDeviceException {
        if (sample.check(device.getPlace())) {
            for (int i = 0; i < places.size(); i++) {
                WeaponDevicePlace place = places.get(i);
                if (place.equals(device.getPlace())) {
                    return place.install(device);
                }
            }
        } else {
            throw new WrongWeaponDeviceException();
        }
        return null;
    }
}
