package ss7_interface_abstract_class.execrsises.resize_able;

public abstract class Geometric implements Resizeable {
    private String name = "Geometric";

    public Geometric(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public double resize(double percentage) {
        return getArea() * (1 - (percentage / 100));
    }

    public abstract double getArea();
}
