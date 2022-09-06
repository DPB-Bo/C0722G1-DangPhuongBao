package ss2_loop_in_java.exercises;

import java.util.Scanner;

public class DisplayElementNumbersLessThan100 {
    public static boolean checkElementNumbers(Integer number) {
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int targetNumber = 0;
        int number = 2;
        do {
            System.out.println("Hiển thị các số nguyên tố bé hơn: ");
            targetNumber = Integer.parseInt(scanner.nextLine());
        } while (targetNumber < 2);
        while (number <= targetNumber) {
            if (checkElementNumbers(number)) {
                System.out.println(number);
            }
            number++;
        }
    }
}
