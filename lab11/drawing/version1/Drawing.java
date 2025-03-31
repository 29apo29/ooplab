package drawing.version1;

import java.util.ArrayList;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Square;

public class Drawing {
    private ArrayList<Circle> circles = new ArrayList<>();
    private ArrayList<Rectangle> rectangles = new ArrayList<>();
    private ArrayList<Square> squares = new ArrayList<>();

    public double calculateArea() {
        double totalArea = 0;
        for (Circle circle : circles) {
            totalArea += circle.area();
        }
        for (Rectangle rectangle : rectangles) {
            totalArea += rectangle.area();
        }
        for (Square square : squares) {
            totalArea += square.area();
        }
        return totalArea;
    }

    public void addSquare(Square s){
        this.squares.add(s);
    }
    public void addRectangle(Rectangle r){
        this.rectangles.add(r);
    }
    public void addCircle(Circle c){
        this.circles.add(c);
    }

}
