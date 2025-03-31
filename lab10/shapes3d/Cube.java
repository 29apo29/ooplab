package shapes3d;

import shapes2d.Square;

public class Cube extends Square {
    public Cube(double side) {
        super(side);
    }

    public double area() {
        return super.area() * 6;
    }

    public double volume() {
        return super.area() * this.side;
    }

    public String toString() {
        //return "Cube{" + " side= " + this.side + "}";
        return super.toString().replaceAll("Square","Cube");
    }
}
