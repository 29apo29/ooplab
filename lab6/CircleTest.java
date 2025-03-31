public class
CircleTest {
    public static void main(String[] args) {
        Circle c1 = new Circle(new Point(6,7),5);
        Circle c2 = new Circle(new Point(5),5);

        System.out.println("The area of circle is " + c1.area());
        System.out.println("The perimeter of circle is " + c1.perimeter());
        System.out.println("asdsadas is " + c1.intersect(c2));
    }
}
