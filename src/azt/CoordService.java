package azt;

import java.util.Random;

/**
 * @author Alexander Vlasov
 */
public class CoordService {
    private int x, y;
    private int counter;
    private Coord nearest;

    public CoordService(Coord coord) {
        x = coord.getX();
        y = coord.getY();
        reset();
        nearest = coord;
    }

    public static Coord getRandomCoord(int w, int h) {
        Random random = new Random();
        return new Coord(random.nextInt(w), random.nextInt(h));
    }

    public void reset() {
        counter = 0;

    }

    public boolean hasNext() {
        return counter != 9;
    }

    public Coord next() {
        if (hasNext()) {
            switch (counter++) {
                case 0:
                    return nearest;
                case 8:
                    return getLeftUp();
                case 1:
                    return getRightUp();
                case 2:
                    return getLeftDown();
                case 3:
                    return getRightDown();
                case 4:
                    return getLeft();
                case 5:
                    return getUp();
                case 6:
                    return getRight();
                case 7:
                    return getDown();
            }
        }
        return null;
    }

    public void setNearest(Coord to) {
        if (to.equals(nearest)) return;
        int x2 = to.getX();
        int y2 = to.getY();

        int dx = x2 - x;
        int dy = y2 - y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        dx = (int) Math.round(1.0 * dx / distance);
        dy = (int) Math.round(1.0 * dy / distance);
        nearest = new Coord(x + dx, y + dy);
        return;
    }

    public Coord getLeftUp() {
        return new Coord(x - 1, y - 1);
    }

    public Coord getRightUp() {
        return new Coord(x + 1, y - 1);
    }

    public Coord getLeftDown() {
        return new Coord(x - 1, y + 1);
    }

    public Coord getRightDown() {
        return new Coord(x + 1, y + 1);
    }

    public Coord getLeft() {
        return new Coord(x - 1, y);
    }

    public Coord getUp() {
        return new Coord(x, y - 1);
    }

    public Coord getRight() {
        return new Coord(x + 1, y);
    }

    public Coord getDown() {
        return new Coord(x, y + 1);
    }

    public Coord getCenter() {
        return new Coord(x, y);
    }

}
