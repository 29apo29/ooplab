public class Rectangle {
    Point topLeft;
    int sideA,sideB;

    public Rectangle(int a, int b, Point p){
        this.sideA = a;
        this.sideB = b;
        this.topLeft = p;
    }
    public Rectangle(int a, Point p){
        this.sideA = a;
        this.sideB = a;
        this.topLeft = p;
    }

    public int area(){
        return (int) this.sideA*this.sideB;
    }

    public int perimeter(){
        return (int) 2*(this.sideA+this.sideB);
    }

    public Point[] corners(){
        Point[] corners = new Point[4];
        corners[0] = new Point(this.topLeft.xCoord,this.topLeft.yCoord); //avoid the sign the object;
        corners[1] = new Point(this.topLeft.xCoord+sideA,this.topLeft.yCoord);
        corners[2] = new Point(this.topLeft.xCoord+sideA,this.topLeft.yCoord+sideB);
        corners[3] = new Point(this.topLeft.xCoord,this.topLeft.yCoord + sideB);
        return corners;
    }

    public double diagonal(){
        Point[] corners = this.corners();
        return corners[0].distance(corners[2]);
    }

}
