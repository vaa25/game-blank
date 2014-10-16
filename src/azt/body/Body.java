package azt.body;

import java.util.ArrayList;
import java.util.List;

/**
 * Тело бойца
 *
 * @author Alexander Vlasov
 */
public class Body {
    private List<BodyPart> bodyParts;
    private double square;
    private int health;

    public Body() {
        bodyParts = new ArrayList<>();
        bodyParts.add(new Head());
        bodyParts.add(new Arm());
        bodyParts.add(new Arm());
        bodyParts.add(new Leg());
        bodyParts.add(new Leg());
        bodyParts.add(new Torso());
        for (BodyPart part : bodyParts) {
            square += part.getSquare();
        }
    }

}
