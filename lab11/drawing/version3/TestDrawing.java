package drawing.version3;

import java.util.ArrayList;
import shapes.Circle;
import shapes.Rectangle;
import shapes.Square;

public class TestDrawing {
    public static void main(String[] args) {
        Drawing drawing = new Drawing();
        drawing.addShape(new Square(5));
        drawing.addShape(new Circle(4));
        drawing.addShape(new Rectangle(3, 4));
        // drawing.addShape(new Shape());
        System.out.println("The total area is " + drawing.calculateArea());

    }
}
