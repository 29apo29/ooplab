public class GCDLoop {
    public static void main(String args[]) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);

        int greater = number1 > number2 ? number1 : number2;
        int smaller = number1 < number2 ? number1 : number2;

        int r;
        do {
            System.out.println("Greater is equal to " + greater);
            System.out.println("Smaller is equal to " + smaller);

            r = greater % smaller;
            System.out.println("Remainder is equal to " + r);
            greater = smaller;
            smaller = r;
        } while (r != 0);
        System.out.println("GCD is equal " + greater);
    }
}
