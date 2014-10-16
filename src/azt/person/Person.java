package azt.person;

import azt.Coord;

/**
 * @author Alexander Vlasov
 */
public class Person {
    private int actionPoints;
    private Coord coord;

    public Person(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void setActionPoints(int actionPoints) {
        this.actionPoints = actionPoints;
    }

    public Coord getCoord() {
        return coord;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    @Override
    public String toString() {
        return coord.toString();
    }
}
