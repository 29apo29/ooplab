public class FindMin {
    public static void main(String[] args) {
        int number1 = Integer.parseInt(args[0]);
        int number2 = Integer.parseInt(args[1]);
        int number3 = Integer.parseInt(args[2]);

        if (number1 < number2 && number1 < number3) {
            System.out.println("The lowest number is " + number1);
        } 
        else if (number2 < number1 && number2 < number3) {
            System.out.println("The lowest number is " + number2);
        } 
        else {
            System.out.println("The lowest number is " + number3);
        }
    }
}
