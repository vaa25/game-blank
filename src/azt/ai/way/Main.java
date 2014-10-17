package azt.ai.way;

import azt.Coord;
import azt.Field;
import azt.person.Person;

import java.util.List;

/**
 * @author Alexander Vlasov
 */
public class Main {
    private Field field;

    public Main() {
        field = new Field(100, 100);
        field.setRandomWalls(800);
        Person person = new Person(20);
        Coord coord = field.getWalkableCoord();
        person.setCoord(coord);
        field.setPerson(person);
        Coord from = person.getCoord();
        Coord target;
        do {
            target = field.getWalkableCoord();
        } while (field.getCell(target).getPerson() != null);
        PathFinder pathFinder = new PathFinder(field);
        List<Coord> way = pathFinder.findPath(person, target);
        if (way != null) {
            for (int i = 0; i < way.size(); i++) {
//                field.getCell(person.getCoord()).setPerson(null);
                field.getCell(way.get(i)).setPerson(person);
                person.setCoord(way.get(i));
            }
            field.print();
            System.out.println("От " + from + " до " + target + " за " + way.size() + " шагов ");

        } else {
            System.out.println("Путь не найден");
        }
    }


    public static void main(String[] args) {
        Main main = new Main();

    }
}
