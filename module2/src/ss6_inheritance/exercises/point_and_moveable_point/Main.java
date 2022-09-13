package ss6_inheritance.exercises.point_and_moveable_point;

public class Main {
    public static void main(String[] args) {
        Point point = new Point(1, 2);
        System.out.println(point);

        MoveablePoint moveablePoint = new MoveablePoint(1, 2, 3, 4);
        System.out.println(moveablePoint);
        moveablePoint.move();
        System.out.println(moveablePoint);
    }
}
