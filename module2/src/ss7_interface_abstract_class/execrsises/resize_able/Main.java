package ss7_interface_abstract_class.execrsises.resize_able;

public class Main {
    public static void main(String[] args) {
        Geometric circle = new Circle(3.5);
        Geometric rect = new Rectangle(2.5, 3.5);
        Geometric square = new Square(2.5);

        Geometric[] geometricsList = new Geometric[]{circle, rect, square};

        for (Geometric geometrics : geometricsList) {
            System.out.printf("Diện tích hình %s ban đầu là: %.2f\n", geometrics.getName(), geometrics.getArea());
        }

        for (Geometric geometrics : geometricsList) {
            double randomPercent = Math.round(Math.random() * 100);
            System.out.println("Tỉ lệ giảm: " + randomPercent + "%");
            geometrics.resize(randomPercent);
            System.out.printf("Diện tích hình %s sau khi giảm %.2f%s là: %.2f\n", geometrics.getName(), randomPercent, "%", geometrics.getArea());
        }
    }
}
