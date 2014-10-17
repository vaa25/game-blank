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
 * Нахождение кротчайшего пути от точки до точки с помощью волнового алгоритма
 *
 * @author Alexander Vlasov
 */
public class PathFinder {
    private final int WALKABLE = Integer.MAX_VALUE;
    private final int UNWALKABLE = Integer.MAX_VALUE - 1;
    private final int FINISH = 0;
    private final int START = Integer.MAX_VALUE - 2;
    private Field field;
    private List<Coord> result;
    private List<WayCoord> startList, finishList;
    private int[][] r;
    private int width, height;

    /**
     * Создание класса для конкретного поля
     *
     * @param field поле
     */
    public PathFinder(Field field) {
        this.field = field;
        width = field.getWidth();
        height = field.getHeight();
        r = new int[width + 2][height + 2];
        for (int i = 0; i < width + 2; i++) {
            for (int j = 0; j < height + 2; j++) {
                if (i == 0 || j == 0 || i == width + 1 || j == height + 1) r[i][j] = UNWALKABLE;
                else if (field.getCell(new Coord(i - 1, j - 1)).getTerrain().isWalkable()) r[i][j] = WALKABLE;
                else r[i][j] = UNWALKABLE;
            }
        }

    }

    private Coord getMinR(int[][] r, Coord was) {
        int x = was.getX();
        int y = was.getY();
        int min = r[x - 1][y - 1];
        int xmin = x - 1;
        int ymin = y - 1;

        if (r[x + 1][y - 1] < min) {
            min = r[x + 1][y - 1];
            xmin = x + 1;
            ymin = y + 1;
        }
        if (r[x - 1][y + 1] < min) {
            min = r[x - 1][y + 1];
            xmin = x - 1;
            ymin = y + 1;
        }
        if (r[x + 1][y + 1] < min) {
            min = r[x + 1][y + 1];
            xmin = x + 1;
            ymin = y + 1;
        }
        if (r[x + 1][y] < min) {
            min = r[x + 1][y];
            xmin = x + 1;
            ymin = y;
        }
        if (r[x][y - 1] < min) {
            min = r[x][y - 1];
            xmin = x;
            ymin = y + 1;
        }
        if (r[x - 1][y] < min) {
            min = r[x - 1][y];
            xmin = x - 1;
            ymin = y;
        }
        if (r[x][y + 1] < min) {
            min = r[x][y + 1];
            xmin = x;
            ymin = y + 1;
        }
        return new Coord(xmin, ymin);
    }

    /**
     * Волновой алгоритм
     *
     * @param person человек, начальная точка
     * @param target конечная точка
     *
     * @return список координат пути по которым нужно идти (упорядочен от начальной до конечной точки)
     */
    public List<Coord> findPath(Person person, Coord target) {
        result = new ArrayList<>();
//        r[target.getX()+1][target.getY()+1]=FINISH;
//        int x1=person.getCoord().getX()+1;
//        int y1=person.getCoord().getY()+1;
//        r[x1][y1]=START;
//        int ni=FINISH;
//        int nk=width;
//        int maxi=target.getX()+1+1;
//        int mini=target.getX()-1+1;
//        int maxj=target.getY()+1+1;
//        int minj=target.getY()-1+1;
//        doWhile:
//        do{
//            for (int i = 1; i < width+1; i++) {
//                for (int j = 1; j < height+1; j++) {
//                    if (r[i][j]==ni){
//                        if (r[i+1][j]==START)break doWhile;//goto 10
//                        if (r[i+1][j]==WALKABLE)r[i+1][j]=ni+1;
//                        if (r[i-1][j]==START)break doWhile;//goto 10
//                        if (r[i-1][j]==WALKABLE)r[i-1][j]=ni+1;
//                        if (r[i+1][j+1]==START)break doWhile;//goto 10
//                        if (r[i+1][j+1]==WALKABLE)r[i+1][j+1]=ni+1;
//                        if (r[i+1][j-1]==START)break doWhile;//goto 10
//                        if (r[i+1][j-1]==WALKABLE)r[i+1][j-1]=ni+1;
//                        if (r[i-1][j+1]==START)break doWhile;//goto 10
//                        if (r[i-1][j+1]==WALKABLE)r[i-1][j+1]=ni+1;
//                        if (r[i-1][j-1]==START)break doWhile;//goto 10
//                        if (r[i-1][j-1]==WALKABLE)r[i-1][j-1]=ni+1;
//                        if (r[i][j+1]==START)break doWhile;//goto 10
//                        if (r[i][j+1]==WALKABLE)r[i][j+1]=ni+1;
//                        if (r[i][j-1]==START)break doWhile;//goto 10
//                        if (r[i][j-1]==WALKABLE)r[i][j-1]=ni+1;
//                    }
//                }
//            }
//            ni++;
//        }
//        while(ni<=nk);
//        if (ni>nk)return null;
//        Coord was=new Coord(x1,y1);
//        do {
//            was=getMinR(r,was);
//            result.add(was);
//
//        }  while (r[was.getX()][was.getY()]!=FINISH);

        startList = new ArrayList<>();
        finishList = new ArrayList<>();
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
        System.out.println("Center = " + center.getCoord());
        return result;
    }

    /**
     * Заполняет List найденного пути координатами
     *
     * @param centerStart координата середины пути
     */
    private void fillResult(WayCoord centerStart) {
        do {
            if (!result.contains(centerStart.getCoord())) result.add(centerStart.getCoord());
            centerStart = centerStart.getPrev();
        } while (centerStart != null);
    }

    /**
     * Сканирует соседние координаты точки на предмет стыковки со второй волной
     *
     * @param secondWave вторая волна
     * @param firstWave  первая волна
     * @param WayCoord1  точка первой волны
     *
     * @return
     */
    private WayCoord next(List<WayCoord> secondWave, Collection<WayCoord> firstWave, WayCoord WayCoord1) {
        Coord coord = WayCoord1.getCoord();
        CoordService coordService = new CoordService(coord);
        coordService.setNearest(secondWave.get(0).getCoord());
        while (coordService.hasNext()) {
            Coord next = coordService.next();
            if (field.isValid(next)) {
                Cell cell = field.getCell(next);
//                if (coordService.getCounter()<3&&!cell.getTerrain().isWalkable()){
//                    System.out.println();
//                }
                if (cell.getTerrain().isWalkable() && cell.getPerson() == null) {
                    WayCoord wayCoord = new WayCoord(next, WayCoord1);
                    if (!firstWave.contains(wayCoord)) firstWave.add(wayCoord);
                    if (secondWave.contains(wayCoord)) {
                        return wayCoord;
                    }
                }
            }
        }
        return null;
    }
}
