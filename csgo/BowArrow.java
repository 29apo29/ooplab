package csgo;

public class BowArrow extends RangedWeapon {
    private boolean isPosionAble;
    private boolean isPosionActive;
    private static final double POSION_EFFECT_ON_DAMAGE = 5;

    public BowArrow(String name, double damage, double cost, double effectiveRange) {
        super(name, damage, cost, effectiveRange,5);
    }

    public double getPOSION_EFFECT_ON_DAMAGE(){
        return POSION_EFFECT_ON_DAMAGE;
    }

    public void cleanArrow() {
        this.isPosionAble = false;
        this.isPosionActive = false;
    }

    public void posionArrow() {
        this.isPosionAble = true;
        this.isPosionActive = true;
    }

    public boolean isPosionAble() {
        return this.isPosionAble;
    }

    public boolean isPosionActive() {
        return this.isPosionActive;
    }

}
