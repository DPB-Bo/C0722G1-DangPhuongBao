package ss7_interface_abstract_class.execrsises.color_able;

public class Main {
    public static void main(String[] args) {
        Geometric circle = new Circle(3.5);
        Geometric rect = new Rectangle(2.5, 3.5);
        Geometric square = new Square(2.5);

        Geometric[] geometricsList = new Geometric[]{circle, rect, square};
        for (Geometric geometrics : geometricsList) {
            System.out.printf("Diện tích hình %s là: %.2f\n", geometrics.getName(), geometrics.getArea());
            if (geometrics instanceof Colorable) {
                ((Colorable) geometrics).howToColor();
            }
        }
    }
}
