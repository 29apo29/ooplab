public class PointTest {
    public static void main(String[] args) {
        Point p1 = new Point();
        System.out.println("x:" + p1.xCoord + " y:" + p1.yCoord);
        
        Point p2 = new Point(3,4);
        System.out.println("x:" + p2.xCoord + " y:" + p2.yCoord);
        System.out.println("The distance of between two point is "+p2.distance(p1));

        Point p3 = new Point(6);
        System.out.println("The distance of between two point is "+p3.distance(p2));

        
    }
}
