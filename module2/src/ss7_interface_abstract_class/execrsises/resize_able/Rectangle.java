package ss7_interface_abstract_class.execrsises.resize_able;

public class Rectangle extends Geometric {
    private double width;
    private double height;


    public Rectangle() {
        super("Rectangle");
    }

    public Rectangle(double width, double height) {
        super("Rectangle");
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void setName(String name) {
        super.setName(name);
    }

    public String getName() {
        return super.getName();
    }

    @Override
    public void resize(double percentage) {
        setWidth(getWidth() * (1 - (percentage / 100)));
        setHeight(getHeight() * (1 - (percentage / 100)));
    }

    @Override
    public double getArea() {
        return this.getWidth() * this.getHeight();
    }
}
