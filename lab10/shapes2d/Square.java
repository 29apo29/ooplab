package shapes2d;

public class Square {
    protected double side;

    public Square() {

    }

    public Square(double side) {
        this.setSide(side);
    }

    public double getSide() {
        return this.side;
    }

    public void setSide(double side) {
        side = side > 0 ? side : 0;
        this.side = side;
    }

    public double area() {
        return this.side * this.side;
    }

    public String toString() {
        return "Square{" + " side= " + this.side + " }";
    }

    public double perimeter(){
        return this.side*4;
    }

}
