public class Point {
    int xCoord,yCoord;
    public Point(){

    }
    public Point(int x, int y){
        this.xCoord = x;
        this.yCoord = y;
    }
    public Point(int xy){
        this.xCoord = xy;
        this.yCoord = xy;
    }
    public double distance(Point p){
        System.out.println((Math.pow((this.yCoord-p.yCoord), 2) + Math.pow((this.xCoord-p.xCoord), 2)));
        return Math.pow((Math.pow((this.yCoord-p.yCoord), 2) + Math.pow((this.xCoord-p.xCoord), 2)),(0.5));
    }
}
