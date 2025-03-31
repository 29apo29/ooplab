package csgo;


public class Player {
    private static final double MAX_LIMIT_ON_X_AXIS = 1000;
    private static final double MAX_LIMIT_ON_Y_AXIS = 1000;
    private static final double MIN_LIMIT_ON_X_AXIS = 0;
    private static final double MIN_LIMIT_ON_Y_AXIS = 0;
    private static final double INITIAL_HEALTH = 100;
    private String nick;
    private double health;
    private double money;
    private boolean isTerrorist;
    private Weapon[] weapons;
    private double xPos;
    private double yPos;

    public Player(String nick, boolean isTerrorist) {
        this.weapons = new Weapon[0];
        this.nick = nick;
        this.isTerrorist = isTerrorist;
        this.money = 1000;
        this.health = Player.INITIAL_HEALTH;
        this.xPos = isTerrorist ? 1000 : 0;
        this.yPos = isTerrorist ? 1000 : 0;
    }

    public String getNick() {
        return this.nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public double getHealth() {
        return this.health;
    }

    public void setHealth(double health) {
        this.health = health >= 0 ? health : 0;
    }

    public double getMoney() {
        return this.money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isTerrorist() {
        return this.isTerrorist;
    }

    public void setIsTerrorist(boolean isTerrorist) {
        this.isTerrorist = isTerrorist;
    }

    public Weapon[] getWeapons() {
        return this.weapons;
    }

    public void setWeapons(Weapon[] weapons) {
        this.weapons = weapons;
    }

    public double getXPos() {
        return this.xPos;
    }

    public void setXPos(double xPos) {
        this.xPos = xPos >= Player.MIN_LIMIT_ON_X_AXIS && xPos <= Player.MAX_LIMIT_ON_X_AXIS ? xPos : this.xPos;
    }

    public double getYPos() {
        return this.yPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos >= Player.MIN_LIMIT_ON_Y_AXIS && xPos <= Player.MAX_LIMIT_ON_Y_AXIS ? xPos : this.yPos;
    }
}
