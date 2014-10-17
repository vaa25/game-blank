package azt.ai.sight;

import azt.Coord;
import azt.Field;
import azt.person.Person;
import azt.terrain.Glass;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author Alexander Vlasov
 */
public class Main {
    private Field field;

    public Main() {
        field = new Field(10, 10);
        field.setRandomWalls(80);
        Person person = new Person(20);
        Coord coord = field.getWalkableCoord();
        person.setCoord(coord);
        field.setPerson(person);
        field.print();
        Coord target;
        do {
            target = field.getWalkableCoord();
        } while (field.getCell(target).getPerson() != null);
        AreaOfSightFinder sightFinder = new AreaOfSightFinder(field);
        Collection<Coord> way = sightFinder.findArea(person);
        for (Iterator<Coord> iterator = way.iterator(); iterator.hasNext(); ) {
            Coord next = iterator.next();
            field.getCell(next).setTerrain(new Glass());
        }
        field.print();
    }


    public static void main(String[] args) {
        Main main = new Main();

    }
}
