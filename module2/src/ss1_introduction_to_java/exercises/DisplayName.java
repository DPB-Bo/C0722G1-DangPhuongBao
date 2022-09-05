package ss1_introduction_to_java.exercises;

import java.util.Scanner;

public class DisplayName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập họ và tên: ");
        String name = scanner.nextLine();
        System.out.println("Hello " + name + " !");
    }
}
