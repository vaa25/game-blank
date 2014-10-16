package azt.weapon;

/**
 * Выстрел пулей
 *
 * @author Alexander Vlasov
 */
public class BulletShoot {
    private Shooter shooter;
    private Target target;

    public BulletShoot(Shooter shooter, Target target) {
        this.shooter = shooter;
        this.target = target;
    }

    public double getAccuracy() {
        int x1 = shooter.getCoord().getX();
        int y1 = shooter.getCoord().getY();
        int x2 = target.getCoord().getX();
        int y2 = target.getCoord().getY();
        int range = (int) Math.round(Math.sqrt(((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1))));
        return shooter.getAccuracy(range) * target.getSquare();
    }


}
