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

    public abstract void resize(double percentage);

    public abstract double getArea();
}
