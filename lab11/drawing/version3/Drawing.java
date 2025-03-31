package drawing.version3;

import java.util.ArrayList;

import shapes.Shape;

public class Drawing {
    private ArrayList<Shape> shapes = new ArrayList<>();

    public double calculateArea() {
        double totalArea = 0;

        for (Shape sh : shapes) {
            totalArea += sh.area();
        }

        return totalArea;
    }

    public void addShape(Shape sh) {
        this.shapes.add(sh);
    }
}
