package ss1_introduction_to_java.practice;

import java.util.Scanner;

public class SolvingFirstDegreeEquations {
    public static void main(String[] args) {
        System.out.println("Linear Equation Resolver");
        System.out.println("Given a equation as 'a * x + b = c', please enter constants:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("a: ");
        double a = scanner.nextDouble();

        System.out.print("b: ");
        double b = scanner.nextDouble();

        System.out.print("c: ");
        double c = scanner.nextDouble();
        if (a != 0) {
            System.out.println("X là: " + ((c - b) / a));
        } else if (b == c) {
            System.out.println("Với mọi X");
        } else {
            System.out.println("Không có kết quả!");
        }
        ;

    }
}
