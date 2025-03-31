package shapes2d;

public class Circle /* extends Object */ {
    protected double radius;

    public Circle(){

    }
    public Circle(double radius) {
        //super();
        this.setRadius(radius);
    }

    public double area() {
        return this.radius * this.radius * Math.PI;
    }

    @Override
    public String toString() {
        return "Circle{" + " radius= " + this.radius + " }";
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        radius = radius > 0 ? radius : 0;
        this.radius = radius;
    }

    public double perimeter(){
        return Math.PI*2*this.radius;
    }


}
