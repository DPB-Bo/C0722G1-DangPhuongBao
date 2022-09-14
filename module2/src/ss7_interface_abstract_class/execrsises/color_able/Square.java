package ss7_interface_abstract_class.execrsises.color_able;

public class Square extends Rectangle implements Colorable {
    public Square() {
        super.setName("Square");
    }

    public Square(double edge) {
        super.setName("Square");
        setEdge(edge);
    }

    public double getEdge() {
        return super.getWidth();
    }

    public String getName() {
        return super.getName();
    }

    public void setEdge(double edge) {
        super.setHeight(edge);
        super.setWidth(edge);
    }

    @Override
    public void howToColor() {
        System.out.println("Color all four sides!");
    }
}
