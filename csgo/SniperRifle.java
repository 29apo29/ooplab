package csgo;

public class SniperRifle extends RangedWeapon {
    private static final double MISFIRE_RATE_WITH_SCOPE = 0.1;
    private static final double MISFIRE_RATE_WITHOUT_SCOPE = 0.3;
    private static final int BULLET_IN_MAGAZINE = 5;
    private int fieldViewDistance;

    public SniperRifle(String name, double damage, double cost, double effectiveRange,
            int fieldViewDistance) {
        super(name, damage, cost, effectiveRange, BULLET_IN_MAGAZINE);
        this.fieldViewDistance = fieldViewDistance;
    }

    public int getFieldViewDistance() {
        return this.fieldViewDistance;
    }

    public void setFieldViewDistance(int fieldViewDistance) {
        this.fieldViewDistance = fieldViewDistance;
    }

    public double getMISFIRE_RATE_WITH_SCOPE() {
        return MISFIRE_RATE_WITH_SCOPE;
    }

    public double getMISFIRE_RATE_WITHOUT_SCOPE() {
        return MISFIRE_RATE_WITHOUT_SCOPE;
    }

    public double getBULLET_IN_MAGAZINE() {
        return BULLET_IN_MAGAZINE;
    }

}
