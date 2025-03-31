package shapes;

public class TestShapes {
    public static void main(String[] args) {
        Square sq = new Square(4);
        Rectangle rc = new Rectangle(3, 4);
        Circle c = new Circle(4);

        System.out.println(sq.area());
        System.out.println(rc.area());
        System.out.println(c.area());

        Shape[] shapes = { new Square(3), new Rectangle(5, 8), new Circle(9) };
        for (Shape sp : shapes) {
            System.out.println(sp.area());
        }
        
    }
}
