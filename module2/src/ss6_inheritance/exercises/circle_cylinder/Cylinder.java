package ss6_inheritance.exercises.circle_cylinder;

public class Cylinder extends Circle {
    private double height;

    public Cylinder() {
    }

    public Cylinder(double radius, String color) {
        super(radius, color);
    }

    public Cylinder(double height) {
        this.height = height;
    }

    public Cylinder(double radius, String color, double height) {
        super(radius, color);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    @Override
    public double getArea() {
        return 2 * Math.PI * height * super.getRadius();
    }

    public double getAreaFull() {
        return 2 * Math.PI * super.getRadius() * (getRadius() + height);
    }

    @Override
    public String toString() {
        return "Hình trụ{" +
                "Bán kính= " + super.getRadius() +
                ", Chiều cao= " + height +
                ", Màu= " + super.getColor() +
                '}';
    }
}
