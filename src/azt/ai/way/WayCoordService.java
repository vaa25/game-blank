package azt.ai.way;

import azt.Coord;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Alexander Vlasov
 */
public class WayCoordService {
    public static WayCoord getFirst(WayCoord wayCoord) {
        while (wayCoord.getPrev() != null) {
            wayCoord = wayCoord.getPrev();
        }
        return wayCoord;
    }

    public static WayCoord find(Collection<WayCoord> set, WayCoord wayCoord) {
        Coord coord = wayCoord.getCoord();
        Iterator<WayCoord> iterator = set.iterator();
        while (iterator.hasNext()) {
            WayCoord next = iterator.next();
            if (next.getCoord().equals(coord)) return next;
        }
        return null;
    }
}
