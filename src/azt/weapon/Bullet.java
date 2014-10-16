package azt.weapon;

/**
 * @author Alexander Vlasov
 */
public class Bullet {
    private int velocity;
    private Calibre calibre;
    private int knockdown;
    private int penetration;
    private int weight;

    public Calibre getCalibre() {
        return calibre;
    }

    public int getVelocity() {
        return velocity;
    }

    public int getKnockdown() {
        return knockdown;
    }

    public int getPenetration() {
        return penetration;
    }

    public int getWeight() {
        return weight;
    }
}
