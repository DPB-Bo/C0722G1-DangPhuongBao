package ss7_interface_abstract_class.execrsises.color_able;


public class Circle extends Geometric {
    private double radius;

    public Circle(double radius) {
        super("Circle");
        this.radius = radius;
    }

    public Circle() {
        super("Circle");
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return this.radius * this.radius * Math.PI;
    }
}
