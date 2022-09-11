package ss4_class_object_in_java.exercises;

import ss4_class_object_in_java.pratice.Main;

import java.util.Scanner;

public class QuadraticEquation {
    static Scanner scanner = new Scanner(System.in);

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    private double a;
    private double b;
    private double c;

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public QuadraticEquation() {
    }

    private double getDiscriminant() {
        return Math.pow(b, 2) - (4 * a * c);
    }

    public String getResult() {
        if (a == 0) {
            return "Giải: a bằng 0 nên phương trình bậc 2 trở thành phương trình bậc 1 " +
                    "\nvới nghiệm là: " + getRootWhenAIsZero();
        }
        if (getDiscriminant() < 0) {
            return "Giải: phương trình vô nghiệm vì delta < 0";
        }
        if (getDiscriminant() == 0) {
            return "Giải: phương trình có nghiệm kép là: " + getDoubleRoot();
        }
        return "Giải: phương trình có 2 nghiệm :" +
                "\nNghiệm thứ nhất: " + getRoot1() +
                "\nNghiệm thứ hai: " + getRoot2();

    }

    private double getRootWhenAIsZero() {
        return -c / b;
    }

    private double getRoot1() {
        return (-b + Math.sqrt(getDiscriminant())) / (2 * a);
    }

    private double getRoot2() {
        return (-b - Math.sqrt(getDiscriminant())) / (2 * a);
    }

    private double getDoubleRoot() {
        return -b / (2 * a);
    }

    public double inputElement(String nameElement) {
        double n;
        System.out.printf("Nhập vào %s : ", nameElement);
        n = Double.parseDouble(scanner.nextLine());
        return n;
    }

    @Override
    public String toString() {
        return "\nPhương trình bậc 2 với:" +
                "\na=" + a + "\nb=" + b + "\nc=" + c + "\n";
    }

    public static void main(String[] args) {
        QuadraticEquation quadraticEquation = new QuadraticEquation();
        quadraticEquation.setA(quadraticEquation.inputElement("a"));
        quadraticEquation.setB(quadraticEquation.inputElement("b"));
        quadraticEquation.setC(quadraticEquation.inputElement("c"));
        System.out.println(quadraticEquation);
        System.out.println(quadraticEquation.getResult());
    }
}
