package azt;

import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;

public class CoordServiceTest extends TestCase {
    private CoordService coordService;
    private int width, height;
    private Coord coord;

    @Before
    public void setUp() throws Exception {
        width = 100;
        height = 100;
        coord = new Coord(width / 2, height / 2);
        coordService = new CoordService(coord);
    }

    @Test
    public void testGetRandomCoord() throws Exception {

    }

    @Test
    public void testReset() throws Exception {

    }

    @Test
    public void testHasNext() throws Exception {

    }

    @Test
    public void testNext() throws Exception {

    }

    @Test
    public void testGetNearest() throws Exception {
        assertEquals(coordService.getLeftUp(), coordService.getNearest(coord, new Coord(0, 0)));
        assertEquals(coordService.getUp(), coordService.getNearest(coord, new Coord(width / 2, 0)));
        assertEquals(coordService.getUp(), coordService.getNearest(coord, new Coord(width / 3, 0)));
        assertEquals(coordService.getLeftUp(), coordService.getNearest(coord, new Coord(width / 5, 0)));
        assertEquals(coordService.getLeft(), coordService.getNearest(coord, new Coord(0, height / 3)));
        assertEquals(coordService.getLeft(), coordService.getNearest(coord, new Coord(0, height / 3)));
        assertEquals(coordService.getLeft(), coordService.getNearest(coord, new Coord(0, height / 2)));
        assertEquals(coordService.getLeft(), coordService.getNearest(coord, new Coord(0, (int) (height / 1.5))));
        assertEquals(coordService.getLeftDown(), coordService.getNearest(coord, new Coord(0, height)));
        assertNull(coordService.getNearest(coord, coord));
    }

    @Test
    public void testSetNearest() throws Exception {
    }

    @Test
    public void testGetLeftUp() throws Exception {

    }

    @Test
    public void testGetRightUp() throws Exception {

    }

    @Test
    public void testGetLeftDown() throws Exception {

    }

    @Test
    public void testGetRightDown() throws Exception {

    }

    @Test
    public void testGetLeft() throws Exception {

    }

    @Test
    public void testGetUp() throws Exception {

    }

    @Test
    public void testGetRight() throws Exception {

    }

    @Test
    public void testGetDown() throws Exception {

    }

    @Test
    public void testGetCenter() throws Exception {

    }
}