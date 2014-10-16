package azt.body;

/**
 * @author Alexander Vlasov
 */
public class BodyPart implements iBodyPart {
    protected double square;
    protected String name;
    protected int health, armour;

    @Override
    public double getSquare() {
        return square;
    }

    @Override
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    @Override
    public int getArmour() {
        return armour;
    }
}
