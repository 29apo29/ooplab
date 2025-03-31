package drawing.version2;

import java.util.ArrayList;

import shapes.Circle;
import shapes.Rectangle;
import shapes.Square;

public class Drawing {
    private ArrayList<Object> shapes = new ArrayList<>();

    public double calculateArea() {
        double totalArea = 0;

        for (Object obj : shapes) {
            if (obj instanceof Circle) {
                Circle c = (Circle) obj;
                totalArea += c.area();
            } else if (obj instanceof Square) {
                Square s = (Square) obj;
                totalArea += s.area();
            } else if (obj instanceof Square) {
                Rectangle r = (Rectangle) obj;
                totalArea += r.area();
            }
        }

        return totalArea;
    }

    public void addShape(Object obj) {
        this.shapes.add(obj);
    }
}
