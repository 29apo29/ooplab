public class Circle {
    int radius;
    Point center;

    public Circle(Point p, int r) {
        this.radius = r;
        this.center = p;
    }

    public double area() {
        return Math.PI * Math.pow(this.radius, 2);
    }

    public double perimeter(){
        return Math.PI * 2 * this.radius;
    }

    public boolean intersect(Circle c){
        return (this.radius + c.radius >= center.distance(c.center));
    }
}
