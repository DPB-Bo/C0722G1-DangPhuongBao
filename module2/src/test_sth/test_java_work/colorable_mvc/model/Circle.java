package test_sth.test_java_work.colorable_mvc.model;

public class Circle extends Geometry {
    private int radius;

    public Circle() {
        super.setName("Circle");
    }

    public Circle(int radius) {
        super.setName("Circle");
        this.radius = radius;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "Circle{" +
                "radius=" + radius +
                '}';
    }
}
