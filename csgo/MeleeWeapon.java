package csgo;

public class MeleeWeapon extends Weapon {

    private boolean isFireAble;
    private boolean isFireActive;
    private static final double FIRE_EFFECT_ON_DAMAGE = 1.5;

    public double getFIRE_EFFECT_ON_DAMAGE() {
		return FIRE_EFFECT_ON_DAMAGE;
	}


    public MeleeWeapon(String name, double damage, double cost, boolean isFireAble, boolean isFireActive) {
        super(name, damage, cost);
        this.isFireAble = isFireAble;
        this.isFireActive = isFireActive;
    }

    public boolean isFireAble() {
        return this.isFireAble;
    }

    public boolean isFireActive() {
        return this.isFireActive;
    }

    public void setIsFireActive(boolean isFireActive) {
        this.isFireActive = isFireActive;
    }

    public void turnFireOff() {
        this.isFireAble = false;
    }

    public void turnFireOn() {
        this.isFireAble= true;
    }

}
