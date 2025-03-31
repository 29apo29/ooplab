// import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class GuessNumber {
    public static void main(String args[]){
        Random rand = new Random();
        Scanner sc = new Scanner(System.in);
        
        System.out.println("I hold a number between 1 and 99. Guess my number: ");
        int number = rand.nextInt(100);

        int guess = sc.nextInt();
        int count = 1;
        
        while(guess != -1 && guess != number){
            System.out.println("It is false.");
            if(guess<number){
                System.out.println("My number is grater than yours.");
            }
            else{
                System.out.println("My number is less than yours.");
            }
            System.out.println("number: ");
            guess = sc.nextInt();
            count ++;
        }
        System.out.println("You finished the game in "+count+" steps. number: "+number);


    }
}
