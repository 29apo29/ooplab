package csgo;

public class MachineGun extends RangedWeapon{
    private static final double MISFIRE_RATE = 0.3;
    private static final int BULLET_IN_MAGAZINE = 100;

    public MachineGun(String name, double damage, double cost, double effectiveRange) {
        super(name, damage, cost, effectiveRange,BULLET_IN_MAGAZINE);
    }
    public double getMisfireRate() {
        return MISFIRE_RATE;
    }

}
