package azt.armour;

/**
 * @author Alexander Vlasov
 */
public class ArmourSample {
    private String name;
    private int head, torse, leftArm, rightArm, leftLeg, rightLeg;

    public ArmourSample(String name, int head, int torse, int leftArm, int rightArm, int leftLeg, int rightLeg) {
        this.name = name;
        this.head = head;
        this.torse = torse;
        this.leftArm = leftArm;
        this.rightArm = rightArm;
        this.leftLeg = leftLeg;
        this.rightLeg = rightLeg;
    }

    public String getName() {
        return name;
    }

    public int getHead() {
        return head;
    }

    public void setHead(int value) {
        if (value >= 0) head = value;
    }

    public int getTorse() {
        return torse;
    }

    public void setTorse(int value) {
        if (value >= 0) torse = value;
    }

    public int getLeftArm() {
        return leftArm;
    }

    public void setLeftArm(int value) {
        if (value >= 0) leftArm = value;
    }

    public int getRightArm() {
        return rightArm;
    }

    public void setRightArm(int value) {
        if (value >= 0) rightArm = value;
    }

    public int getLeftLeg() {
        return leftLeg;
    }

    public void setLeftLeg(int value) {
        if (value >= 0) leftLeg = value;
    }

    public int getRightLeg() {
        return rightLeg;
    }

    public void setRightLeg(int value) {
        if (value >= 0) rightLeg = value;
    }
}
