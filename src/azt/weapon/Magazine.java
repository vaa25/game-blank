package azt.weapon;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author Alexander Vlasov
 */
public class Magazine {
    private final int size;
    private final Calibre[] calibres;
    private final int emptyWeight;
    private Queue<Bullet> bullets;
    private int amount;
    private int weight;

    public Magazine(int size, int weight, Calibre[] calibres) {
        this.size = size;
        emptyWeight = weight;
        this.calibres = calibres;
    }

    public Queue<Bullet> addAll(Queue<Bullet> bullets) {
        Queue<Bullet> added = new ArrayDeque<>();
        for (Bullet bullet : bullets) {
            if (amount == size) break;
            if (checkCalibre(bullet.getCalibre())) {
                bullets.add(bullet);
                amount++;
            }
        }
        bullets.removeAll(added);
        return added;
    }

    private boolean checkCalibre(Calibre calibre) {
        for (Calibre calibre2 : calibres) {
            if (calibre2.equals(calibre)) return true;
        }
        return false;
    }

    public Bullet getBullet() {
        return bullets.poll();
    }

    public Queue<Bullet> unArmour() {
        Queue<Bullet> res = bullets;
        bullets = new ArrayDeque<>();
        return res;
    }
}
