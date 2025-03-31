public class RectangleTest {
    public static void main(String[] args) {
        Rectangle r1 = new Rectangle(6,new Point(0));
        System.out.println("The area of the rectangle is: "+r1.area());
        System.out.println("The perimeter of the rectangle is: "+r1.perimeter());
        System.out.println("Diagonal's length is " + r1.diagonal());
    }
}
