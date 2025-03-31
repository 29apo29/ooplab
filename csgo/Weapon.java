package csgo;

public class Weapon {
    private String name;
    private double damage;
    private double cost;

    public Weapon(String name, double damage, double cost) {
        this.name = name;
        this.damage = damage;
        this.cost = cost;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getDamage() {
        return this.damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public double getCost() {
        return this.cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}
