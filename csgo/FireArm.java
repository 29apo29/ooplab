package csgo;

public class FireArm extends RangedWeapon {
    private static final double MISFIRE_RATE = 0.2;
    private static final int BULLET_IN_MAGAZINE = 30;
    private double misfireRate = MISFIRE_RATE;

    public FireArm(String name, double damage, double cost, double effectiveRange) {
        super(name, damage, cost, effectiveRange,BULLET_IN_MAGAZINE);
    }

    public double getMisfireRate() {
        return this.misfireRate;
    }

    public void setMisfireRate(double misfireRate) {
        this.misfireRate = misfireRate;
    }

}
