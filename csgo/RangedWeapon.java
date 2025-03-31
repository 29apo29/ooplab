package csgo;

public class RangedWeapon extends Weapon {
    private double effectiveRange;
    private int bulletInMagazine; // bullet count

    public RangedWeapon(String name, double damage, double cost, double effectiveRange, int bulletInMagazine) {
        super(name, damage, cost);
        this.effectiveRange = effectiveRange;
        this.bulletInMagazine = bulletInMagazine;
    }

    public double getEffectiveRange() {
        return this.effectiveRange;
    }

    public void setEffectiveRange(double effectiveRange) {
        this.effectiveRange = effectiveRange;
    }

    public int getBulletInMagazine() {
        return this.bulletInMagazine;
    }

    public void setBulletInMagazine(int bulletInMagazine) {
        this.bulletInMagazine = bulletInMagazine;
    }

}
