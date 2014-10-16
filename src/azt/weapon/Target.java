package azt.weapon;

import azt.Coord;

/**
 * @author Alexander Vlasov
 */
public class Target {
    private final int square;
    private int armour;
    private int health;
    private Coord coord;

    public Target(int square, int armour, int health) {
        this.square = square;
        this.armour = armour;
        this.health = health;
    }

    public Coord getCoord() {
        return coord;
    }

    public int getSquare() {
        return square;
    }

    public int getArmour() {
        return armour;
    }

    public void setArmour(int armour) {
        this.armour = armour;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
