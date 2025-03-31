package shapes2d;

public class TestShapes {
    public static void main(String[] args) {
        Circle circle = new Circle(3.5);
        System.out.println(circle);
        System.out.println(circle.area());

        Square square =  new Square();
        square.setSide(5);
        System.out.println(square);
        System.out.println(square.area());
    }
}
