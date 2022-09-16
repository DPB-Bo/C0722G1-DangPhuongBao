package test_sth.test_java_work.colorable_mvc.model;

public class Square extends Rectangle {
    public Square() {
        super.setName("Square");
    }

    public Square(int edge) {
        super.setName("Square");
        setEdge(edge);
    }

    public void setEdge(int edge) {
        super.setHeight(edge);
        super.setWidth(edge);
    }

    public int getEdge() {
        return super.getHeight();
    }

    @Override
    public String toString() {
        return "Square{" +
                "edge=" + this.getEdge() + "}";
    }
}
