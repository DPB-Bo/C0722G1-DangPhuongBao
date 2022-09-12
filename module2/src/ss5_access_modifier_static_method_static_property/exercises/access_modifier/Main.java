package ss5_access_modifier_static_method_static_property.exercises.access_modifier;

public class Main {
    public static void main(String[] args) {
        Circle circle1 = new Circle();
        Circle circle2 = new Circle(1);
        System.out.println("Bán kính đường tròn là: " + circle1.getRadius() + ". Diện tích hình tròn là: " + circle1.getArea());
        System.out.println("Bán kính đường tròn là: " + circle2.getRadius() + ". Diện tích hình tròn là: " + circle2.getArea());
    }
}
