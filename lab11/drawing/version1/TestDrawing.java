package drawing.version1;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Square;

public class TestDrawing {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        drawing.addSquare(new Square(4));
        drawing.addCircle(new Circle(4));
        drawing.addRectangle(new Rectangle(3, 4));
        System.out.println("The total area is " + drawing.calculateArea());
    }
}
