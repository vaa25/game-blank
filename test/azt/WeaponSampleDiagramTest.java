package azt;

import azt.weapon.WeaponDiagram;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

import java.util.TreeMap;

public class WeaponSampleDiagramTest extends TestCase {
    private WeaponDiagram diagram;

    @Before
    public void setUp() throws Exception {
        TreeMap<Integer, Double> map = new TreeMap();

        map.put(30, 100.0);
        map.put(35, 90.0);
        map.put(40, 85.0);
        map.put(50, 80.0);
        map.put(60, 75.0);
        map.put(80, 70.0);
        map.put(110, 60.0);
        map.put(150, 50.0);
        map.put(200, 40.0);
        map.put(300, 31.0);
        map.put(400, 22.0);
        map.put(500, 15.0);
        map.put(600, 10.0);
        map.put(700, 6.0);
        map.put(800, 3.0);
        map.put(900, 1.0);
        map.put(1000, 0.0);

        diagram = new WeaponDiagram(map);

//        for (int i = -100; i < 2000; i++) {
//            System.out.println(i+" "+diagram.get(i));
//        }
    }

    @Test
    public void testPut() throws Exception {

    }

    @Test
    public void testGet() throws Exception {
        assertEquals(222.0, diagram.get(-31));
        assertEquals(-5.71, diagram.get(1571));
        assertEquals(160.0, diagram.get(0));
        assertEquals(87.0, diagram.get(38));
        assertEquals(70.0, diagram.get(80));
    }
}