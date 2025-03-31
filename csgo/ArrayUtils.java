package csgo;

public class ArrayUtils {
    public static Player[] add(Player[] objs, Player obj) {
        Player[] newObjs = new Player[objs.length + 1];
        for (int i = 0; objs.length > i; i++) {
            newObjs[i] = objs[i];
        }
        newObjs[objs.length] = obj;
        return newObjs;
    }

    public static Weapon[] add(Weapon[] objs, Weapon obj) {
        Weapon[] newObjs = new Weapon[objs.length + 1];
        for (int i = 0; objs.length > i; i++) {
            newObjs[i] = objs[i];
        }
        newObjs[objs.length] = obj;
        return newObjs;
    }

    public static boolean contains(Weapon[] objs, Weapon obj) {
        if (objs.length == 0) {
            return false;
        }
        for (Weapon e : objs) {
            if (e.getName() == obj.getName()) {
                return true;
            }
        }
        return false;
    }

    public static int counter(boolean[] arr, boolean val) {
        int count = 0;
        for (boolean e : arr) {
            count = e == val ? count + 1 : count;
        }
        return count;
    }
}
