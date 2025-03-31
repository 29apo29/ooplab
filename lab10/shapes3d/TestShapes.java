package shapes3d;

public class TestShapes {
    public static void main(String[] args) {
        Cube cube = new Cube(5);
        System.out.println(cube);
        System.out.println(cube.area());
        System.out.println(cube.volume());

        Cylinder cylinder = new Cylinder(8,4);
        System.out.println(cylinder);
        System.out.println(cylinder.area());
        System.out.println(cylinder.volume());
    }
}
