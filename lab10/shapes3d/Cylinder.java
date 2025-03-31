package shapes3d;

import shapes2d.Circle;

public class Cylinder extends Circle {
    private double height;

    public Cylinder(double height) {
        super(1);
        this.height = height;
    }

    public Cylinder(double height, double radius) {
        super(radius);
        this.height = height;
    }

    public double volume() {
        return super.area() * this.height;
    }

    public double area() {
        return super.perimeter() * this.height + 2 * super.area();
    }

    @Override
    public String toString(){
        String attr = " height= "+ this.height+" }";
        return super.toString().replaceAll("Circle","Cylinder").replaceAll("}", attr);
    }

}
