package azt.ai.sight;

import azt.Coord;
import azt.CoordService;
import azt.Field;
import azt.person.Person;

import java.util.Collection;
import java.util.HashSet;

/**
 * Выявляет видимую бойцу вокруг него площадь. Обзор 360 градусов.
 *
 * @author Alexander Vlasov
 */
public class AreaOfSightFinder {
    private Field field;

    public AreaOfSightFinder(Field field) {
        this.field = field;
    }

    /**
     * Выявляет видимую бойцу вокруг него площадь. Обзор 360 градусов.
     *
     * @param person боец
     *
     * @return набор видимых координат
     */
    public Collection<Coord> findArea(Person person) {
        Coord eyeCoord = person.getCoord();
        Collection<Coord> result = new HashSet<>();
        int width = field.getWidth();
        int height = field.getHeight();
        Coord pointOfView = eyeCoord;
        for (int i = 0; i < width; i++) {
            findLine(result, pointOfView, new Coord(i, 0));
        }
        pointOfView = eyeCoord;
        for (int i = 0; i < width; i++) {
            findLine(result, pointOfView, new Coord(i, height - 1));
        }
        pointOfView = eyeCoord;
        for (int i = 0; i < height; i++) {
            findLine(result, pointOfView, new Coord(0, i));
        }
        pointOfView = eyeCoord;
        for (int i = 0; i < height; i++) {
            findLine(result, pointOfView, new Coord(width - 1, i));
        }
        return result;
    }

    private void findLine(Collection<Coord> result, Coord pointOfView, Coord coord) {
        do {
            pointOfView = findNextCoord(result, pointOfView, coord);
        } while (pointOfView != null && !pointOfView.equals(coord));
    }

    /**
     * Ищет следующую ближайшую координату от первой координаты по направлению ко второй координате
     *
     * @param result      место куда ложить результат
     * @param pointOfView первая координата
     * @param to          вторая координата
     *
     * @return ближайшая координата, либо null, если она не прозрачная
     */
    private Coord findNextCoord(Collection<Coord> result, Coord pointOfView, Coord to) {
        pointOfView = CoordService.getNearest(pointOfView, to);
        if (pointOfView != null) {
            result.add(pointOfView);
            if (!field.getCell(pointOfView).getTerrain().isTransparent()) pointOfView = null;
        }
        return pointOfView;
    }

}
