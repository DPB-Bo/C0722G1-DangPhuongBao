package ss2_loop_in_java.exercises;

import java.util.Scanner;

public class Display20ElementNumbers {
    public static boolean checkElementNumbers(Integer number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        int number = 2;
        do {
            System.out.println("Muốn hiển thị bao nhiêu số nguyên tố ?");
            count = Integer.parseInt(scanner.nextLine());
        } while (count < 1);
        while (count > 0) {
            if (checkElementNumbers(number)) {
                System.out.println(number);
                count--;
            }
            number++;
        }
    }
}
