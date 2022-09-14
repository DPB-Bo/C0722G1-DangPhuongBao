package ss7_interface_abstract_class.execrsises.color_able;

public abstract class Geometric {
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

    public abstract double getArea();
}
