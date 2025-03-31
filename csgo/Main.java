package csgo;

import java.util.Scanner;

/**
 * The program is a CsGo game program.
 * This game running like a story you can just read.
 *
 * @author 220717057
 * @version 1.0
 * @since 02.05.2024
 */

public class Main {
    public static void main(String[] args) {
        Weapon[] weapons = getAllWeapons(); // Creating weapons
        Player[] players = createPlayers(4); // creating players
        startGame(players, weapons); // start ...
    }

    public static void startGame(Player[] players, Weapon[] weapons) {
        /*
         * Starting the game and finishing.
         * First, there is a message for user.
         * Then, players (bots) are buy weapon.
         * Then, until game finishing.
         * Players are moving, then fire.
         * Then, messages for user.
         * 
         * 
         * @param players
         * All players in the game
         * 
         * @param weapons
         * All weapons in the game
         */

        System.out.println("/// Game is started //");
        buyWeapons(players, weapons); // buying weapons
        boolean isFinished = !isGameFinished(players);
        do { // if game not finished
            move(players); // moving the players
            fire(players); // fire the players
            isFinished = !isGameFinished(players);
        } while (isFinished);
        // if game finished
        System.out.println("// Game is Finished!!! //");
        System.out.println("CONGRATULATIONS!!! " + whoWon(players) + " are won the game!");
    }

    public static String whoWon(Player[] players) {
        /*
         * Find that who is won the game.
         * 
         * @param players
         * All players.
         * 
         * @return String
         * T or CT is won
         */
        int t = 0;
        for (Player player : players) {
            if (player.getHealth() > 0) {
                if (player.isTerrorist()) {
                    t += 1;
                }
            }
        }
        return t > 0 ? "Terrorists" : "Counters";
    }

    public static boolean isGameFinished(Player[] players) {
        /*
         * Find that is game finished.
         * 
         * @param players
         * All players.
         * 
         * @return boolean
         */
        int t = 0;
        int ct = 0;
        for (Player player : players) {
            if (player.getHealth() > 0) {
                if (player.isTerrorist()) {
                    t += 1;
                } else {
                    ct += 1;
                }
            }
            if (t > 0 && ct > 0) {
                return false;
            }
        }
        return true;
    }

    public static void move(Player[] players) {
        /*
         * Moving all player (without die).
         * With random number.
         * 
         * @param players
         * All players
         * 
         * 
         * 
         */
        for (Player player : players) {
            if (player.getHealth() <= 0) {
                continue;
            }
            player.setXPos(player.getXPos() + (getRand() > 0.5 ? 1 : -1) * getRandInt(50));
            player.setYPos(player.getYPos() + (getRand() > 0.5 ? 1 : -1) * getRandInt(50));
            System.out.println(player.getNick() + " is moved to x: " + player.getXPos() + "y: " + player.getYPos());
        }
        // Scanner  sc = new Scanner(System.in);
        // sc.nextLine();
    }

    public static void fire(Player[] players) {
        /*
         * Fire all players (without die).
         * 
         * @param players
         * All players
         *
         * 
         * 
         * 
         * For each player:
         * Controling is player death?
         * Getting the player's weapons
         * Selecting another player for shoot
         * calculating the distance between two player.
         * message for user
         * controlling these are in the same team
         * controlling the other player is death
         * if there is no problem:
         * controlling player's weapon is melee or ranged weapon
         * if it is ranged:
         * control distance between the players is bigger than the range of the weapon
         * (if bigger cannot shoot)
         * controling the weapon has bullet (if there is no reload and not shoot)
         * if there is no problem:
         * controling for the weapon is sniper( because sniper has scope and this is
         * changing the misrate )
         * another weapon control for posion or smth. else and shoot.
         * (missrate control is like that (misFireRate * 10 < getRandInt(10)) if this is
         * true shoot is missing )
         * if it is melee:
         * cannot shoot without distance less than 5.
         * and another firerate bla bla
         */
        int i = 0;
        for (Player player : players) {
            if (player.getHealth() <= 0) {
                continue;
            }
            Weapon[] playerWeapons = player.getWeapons();
            Player selectedPlayer = players[getRandIntWithout(0, players.length, i)];
            Weapon selectedWeapon = playerWeapons[getRandInt(playerWeapons.length)];
            double distance = getDistance(player, selectedPlayer);
            System.out.println(
                    player.getNick() + " shoots at " + selectedPlayer.getNick() + " with " + selectedWeapon.getName());
            if (player.isTerrorist() == selectedPlayer.isTerrorist()) {
                System.out.println(
                        "!!! Failed " + player.getNick() + " and " + selectedPlayer.getNick() + " are at same side.");
            } else if (selectedPlayer.getHealth() == 0) {
                System.out.println(
                        "!!! Failed " + selectedPlayer.getNick() + " is already death. ");
            } else {
                if (selectedWeapon instanceof RangedWeapon) {
                    RangedWeapon sWeapon = (RangedWeapon) selectedWeapon;
                    if (distance > sWeapon.getEffectiveRange()) {
                        System.out.println(
                                "!!! Failed " + sWeapon.getName() + " cannot shoot at " + distance + " distance.");
                    } else if (sWeapon.getBulletInMagazine() == 0) {
                        System.out.println(player.getNick() + " cannot shoot becasue there is no bullet in magazine");
                        reloadMagazine(player, sWeapon);
                    } else {
                        if (sWeapon instanceof SniperRifle) {
                            SniperRifle snip = (SniperRifle) sWeapon;
                            boolean isScope = getRandInt(2) == 1;
                            double misFireRate = isScope ? snip.getMISFIRE_RATE_WITH_SCOPE()
                                    : snip.getMISFIRE_RATE_WITHOUT_SCOPE();
                            snip.setBulletInMagazine(snip.getBulletInMagazine() - 1);
                            if (misFireRate * 10 < getRandInt(10)) {
                                System.out.println("Failed! Pistol misfired!");
                            } else {
                                selectedPlayer.setHealth(selectedPlayer.getHealth() - snip.getDamage());
                                System.out.println("Success! Pinpoint accuracy!");
                                System.out.println("Info: There are " + snip.getBulletInMagazine()
                                        + " bullet(s) left in " + selectedPlayer.getNick() + "'s magazine.");
                                System.out.println("Info: " + selectedPlayer.getNick()
                                        + " health level is decreased to " + selectedPlayer.getHealth() + ".");
                            }
                        } else {
                            double misFireRate = 0.2;
                            double damage = sWeapon.getDamage();
                            if (sWeapon instanceof FireArm) {
                                misFireRate = ((FireArm) sWeapon).getMisfireRate();
                            } else if (sWeapon instanceof MachineGun) {
                                misFireRate = ((MachineGun) sWeapon).getMisfireRate();
                            } else if (sWeapon instanceof BowArrow) {
                                damage += ((BowArrow) sWeapon).getPOSION_EFFECT_ON_DAMAGE();
                            }
                            if (misFireRate * 10 < getRandInt(10)) {
                                System.out.println("Failed! Pistol misfired!");
                            } else {
                                selectedPlayer.setHealth(selectedPlayer.getHealth() - damage);
                                System.out.println("Success! Pinpoint accuracy!");
                                System.out.println("Info: There are " + sWeapon.getBulletInMagazine()
                                        + " bullet(s) left in " + selectedPlayer.getNick() + "'s magazine.");
                                System.out.println("Info: " + selectedPlayer.getNick()
                                        + " health level is decreased to " + selectedPlayer.getHealth() + ".");
                            }
                        }
                    }
                } else {
                    if (distance > 5) {
                        System.out.println(
                                "!!! Failed " + selectedWeapon.getName() + " cannot shoot at " + distance
                                        + " distance.");
                    } else {
                        double damage = selectedWeapon.getDamage();
                        if (((MeleeWeapon) selectedWeapon).isFireAble()) {
                            damage = damage * ((MeleeWeapon) selectedWeapon).getFIRE_EFFECT_ON_DAMAGE();
                            ((MeleeWeapon) selectedWeapon).setIsFireActive(false);
                            ((MeleeWeapon) selectedWeapon).turnFireOff();
                        } else if (((MeleeWeapon) selectedWeapon).isFireActive()) {
                            ((MeleeWeapon) selectedWeapon).turnFireOn();
                        } else {
                            ((MeleeWeapon) selectedWeapon).setIsFireActive(true);
                        }
                        selectedPlayer.setHealth(selectedPlayer.getHealth() - damage);
                        System.out.println("Success! Pinpoint accuracy!");
                        System.out.println("Info: " + selectedPlayer.getNick()
                                + " health level is decreased to " + selectedPlayer.getHealth() + ".");
                    }
                }
            }
            i++;
        }
    }

    public static void reloadMagazine(Player player, Weapon weapon) {
        /*
         * Reloading the weapon.
         * message for user
         * controling player's money
         * .....
         * 
         * @param player
         * who's weapon
         * 
         * @param weapon
         * 
         */
        System.out.println(player.getNick() + " making reload for " + weapon.getName());
        if (player.getMoney() < 50) {
            System.out.println("!!!Failed " + player.getNick() + "has not enough money.");
        } else {
            if (weapon instanceof SniperRifle) {
                ((SniperRifle) weapon).setBulletInMagazine(5);
                player.setMoney(player.getMoney() - 50);
            } else if (weapon instanceof FireArm) {
                ((FireArm) weapon).setBulletInMagazine(5);
                player.setMoney(player.getMoney() - 50);
            } else if (weapon instanceof MachineGun) {
                ((MachineGun) weapon).setBulletInMagazine(5);
                player.setMoney(player.getMoney() - 50);
            }
        }
    }

    public static void buyWeapons(Player[] players, Weapon[] weapons) {
        /*
         * Buying weapon for all players
         *  message for user
         *  for each player:
         *      add to inventory knife
         *      add weapons according to money
         *      Listed the player's weapons
         * 
         * 
         * 
         * @param players
         * All players
         * 
         * @param weapons
         * All weapons
         * 
         */
        System.out.println("// Weapons are buying by players. //");
        for (Player player : players) {
            Weapon[] playerWeapons = new Weapon[0];
            playerWeapons = ArrayUtils.add(playerWeapons, copyWeapon(weapons[weapons.length - 1])); // knife adding because in my design each player has knife
            int i = 0;
            while (player.getMoney() > 200 && i < 10) {
                double playerMoney = player.getMoney();
                int whichWeapon = getRandInt(4);
                if (ArrayUtils.contains(player.getWeapons(), weapons[whichWeapon])
                        || weapons[whichWeapon].getCost() > playerMoney) { // if player has the weapon
                    i++;
                    continue;
                }
                player.setMoney(playerMoney - weapons[whichWeapon].getCost());
                Weapon copiedWeapon = copyWeapon(weapons[whichWeapon]);
                playerWeapons = ArrayUtils.add(playerWeapons, copiedWeapon);
                player.setWeapons(playerWeapons);
                i++;
            }
            System.out.println(player.getNick() + " Has the weapons which are listed at the bottom.  --- \\/");
            int j = 1;
            for (Weapon wp : player.getWeapons()) {
                System.out.println(j + " - " + wp.getName());
                j++;
            }
        }
    }

    public static Weapon[] getAllWeapons() {
        /*
         * Initial weapons (last item should be knife)
         * 
         * @return Weapon[]
         *    
         */
        Weapon[] weapons = {
                new SniperRifle("AWP", 100, 800, 1000, 1000),
                new MachineGun("Negev", 20, 300, 500),
                new FireArm("Ak-47", 30, 400, 500),
                new BowArrow("Bow", 10, 200, 700),
                new MeleeWeapon("Knife", 50, 0, false, false)
        };
        return weapons;
    }

    public static Player[] createPlayers(int count) {
        /*
         * Creating the players
         *  count times:
         *  create a new player
         *  terrorist control
         *  .....
         * 
         * 
         * @param count
         *      number of players
         * 
         */
        count = count % 2 == 0 ? count : count + 1;
        Player[] players = new Player[0];
        boolean[] terrFind = new boolean[10];
        for (int i = 0; i < count; i++) {
            terrFind[i] = getRand() > 0.5;
            if (i >= count / 2) {
                int terrCount = ArrayUtils.counter(terrFind, true);
                int ctCount = ArrayUtils.counter(terrFind, false);
                terrFind[i] = terrCount >= count / 2 || ctCount >= count / 2 ? (terrCount >= count / 2 ? false : true)
                        : getRand() > 0.5; // if terrorist count or ct count equal or bigger (impossible) dont push any terrorist or ct else select with random ....
            }
            Player player = new Player("Player" + i, terrFind[i]);
            players = ArrayUtils.add(players, player);
        }
        return players;
    }

    public static double getRand() {
        return Math.random();
    }

    public static int getRandInt(int min, int max) {
        return (int) (getRand() * (max - min) + min);
    }

    public static int getRandInt(int max) {
        return (int) (getRand() * (max));
    }

    public static int getRandIntWithout(int min, int max, int without) {
        /*
         * Getting random int without a number
         * 
         * @param min
         * @param max
         * @param without
         * 
         * @return int
         */
        int i = 0;
        do {
            i = getRandInt(min, max);

        } while (i == without);
        return i;
    }

    public static double getDistance(Player p1, Player p2) {
        return Math.sqrt(Math.pow(p1.getXPos() - p2.getXPos(), 2) + Math.pow(p1.getYPos() - p2.getYPos(), 2));
    }

    public static Weapon copyWeapon(Weapon weapon) {
        /*
         * Copying weapon
         *  This is not the best solution.
         *  Best solution is method in the classes but the classes do ot have copy method in uml diagram
         * 
         * @param weapon
         * 
         * @return Weapon
         * 
         */
        Weapon newWeapon;
        if (weapon instanceof BowArrow) {
            newWeapon = new BowArrow(weapon.getName(), weapon.getDamage(), weapon.getCost(),
                    ((BowArrow) weapon).getEffectiveRange());
        } else if (weapon instanceof FireArm) {
            newWeapon = new FireArm(weapon.getName(), weapon.getDamage(), weapon.getCost(),
                    ((FireArm) weapon).getEffectiveRange());
        } else if (weapon instanceof MachineGun) {
            newWeapon = new MachineGun(weapon.getName(), weapon.getDamage(), weapon.getCost(),
                    ((MachineGun) weapon).getEffectiveRange());
        } else if (weapon instanceof MeleeWeapon) {
            newWeapon = new MeleeWeapon(weapon.getName(), weapon.getDamage(), weapon.getCost(),
                    ((MeleeWeapon) weapon).isFireAble(), ((MeleeWeapon) weapon).isFireActive());
        }  else {
            newWeapon = new SniperRifle(weapon.getName(), weapon.getDamage(), weapon.getCost(),
                    ((SniperRifle) weapon).getEffectiveRange(), ((SniperRifle) weapon).getFieldViewDistance());
        }
        return newWeapon;
    }

}
