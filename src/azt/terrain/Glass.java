package azt.terrain;

/**
 * @author Alexander Vlasov
 */
public class Glass extends Terrain {
    public Glass() {
        setWalkable(false);
        setTransparent(true);
        setPunched(true);
    }
}
