package ss6_inheritance.exercises.circle_cylinder;

public class Main {
    public static void main(String[] args) {
        Circle circle = new Circle();
        System.out.println(circle);

        circle = new Circle(3.5, "indigo");
        System.out.println(circle);
        System.out.println(circle.getArea());

        Cylinder cylinder = new Cylinder();
        System.out.println(cylinder);

        cylinder = new Cylinder(3.5, "red", 4.0);
        System.out.println(cylinder);
        System.out.println(cylinder.getArea());
        System.out.println(cylinder.getAreaFull());
    }
}
