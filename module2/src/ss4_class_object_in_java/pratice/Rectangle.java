package ss4_class_object_in_java.pratice;

public class Rectangle {
    private double width;
    private double height;

    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    protected double getArea() {
        return this.width * this.height;
    }

    protected double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    protected String display() {
        return "Rectangle{" + "width=" + width + ", height=" + height + "}";
    }
}
