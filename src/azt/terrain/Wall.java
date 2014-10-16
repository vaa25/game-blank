package azt.terrain;

/**
 * @author Alexander Vlasov
 */
public class Wall extends Terrain {
    public Wall() {
        setWalkable(false);
        setTransparent(true);
        setPunched(true);
    }
}
