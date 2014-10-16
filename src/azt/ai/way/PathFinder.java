package azt.ai.way;

import azt.Cell;
import azt.Coord;
import azt.CoordService;
import azt.Field;
import azt.person.Person;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author Alexander Vlasov
 */
public class PathFinder {
    private Field field;
    private Person person;
    private Coord target;
    private List<Coord> result;
    private List<WayCoord> startList, finishList;

    public PathFinder(Field field) {
        this.field = field;

    }

    public List<Coord> findPath(Person person, Coord target) {
        this.person = person;
        this.target = target;
        startList = new ArrayList<>();
        finishList = new ArrayList<>();
        result = new ArrayList<>();
        if (person.getCoord().equals(target)) return null;
        WayCoord finishWayCoord = new WayCoord(target, null);
        WayCoord startWayCoord = new WayCoord(person.getCoord(), null);
        startList.add(startWayCoord);
        finishList.add(finishWayCoord);
        int startListIndex = 0;
        int finishListIndex = 0;
        boolean found = false;
        WayCoord center;
        do {
            WayCoord stWay = startList.get(startListIndex++);

            if ((center = next(finishList, startList, stWay)) != null) {
                found = true;
                break;
            }

            WayCoord finWay = finishList.get(finishListIndex++);
            if ((center = next(startList, finishList, finWay)) != null) {
                found = true;
                break;
            }
        } while (finishList.size() > finishListIndex && startList.size() > startListIndex);
        if (found == false) return null;
        WayCoord centerStart = WayCoordService.find(startList, center);
        fillResult(centerStart);
        Collections.reverse(result);
        WayCoord centerFinish = WayCoordService.find(finishList, center);
        fillResult(centerFinish);
        return result;
    }

    private void fillResult(WayCoord centerStart) {
        do {
            if (!result.contains(centerStart.getCoord())) result.add(centerStart.getCoord());
            centerStart = centerStart.getPrev();
        } while (centerStart != null);
    }

    private WayCoord next(List<WayCoord> finishList, Collection<WayCoord> startList, WayCoord stWay) {
        Coord coord = stWay.getCoord();
        CoordService coordService = new CoordService(coord);
        coordService.setNearest(finishList.get(0).getCoord());
        while (coordService.hasNext()) {
            Coord next = coordService.next();
            if (field.isValid(next)) {
                Cell cell = field.getCell(next);
                if (cell.getTerrain().isWalkable() && cell.getPerson() == null) {
                    WayCoord wayCoord = new WayCoord(next, stWay);
                    if (!startList.contains(wayCoord)) startList.add(wayCoord);
                    if (finishList.contains(wayCoord)) {

                        return wayCoord;
                    } else {

                    }
                }
            }
        }
        return null;
    }
}
