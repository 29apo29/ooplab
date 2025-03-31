public class Grade {
    public static void main(String[] args) {
        byte grade = (byte) Integer.parseInt(args[0]);
        if (grade >= 90 && grade <= 100) {
            System.out.println("AA");
        } 
        else if (grade >= 80 && grade < 90) {
            System.out.println("BB");
        } 
        else if (grade >= 70 && grade < 80) {
            System.out.println("CC");
        } 
        else if (grade >= 60 && grade < 70) {
            System.out.println("DD");
        } 
        else if (grade >= 0 && grade < 60) {
            System.out.println("FF");
        } 
        else {
            System.out.println("This Is not a grade");
        }

    }
}
