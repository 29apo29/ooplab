public class RecursiveGCD {
    public static void main(String args[]){
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);

        int greater = number1 > number2 ? number1 : number2;
        int smaller = number1 < number2 ? number1 : number2;
        System.out.println(gcd(greater,smaller));
    }
    public static int gcd(int number1, int number2){
        if(number2 == 0){
            return number1;
        }
        return gcd(number2,number1%number2);
    }
}
