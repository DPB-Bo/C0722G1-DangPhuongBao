package ss2_loop_in_java.pratice;

import java.util.Scanner;

public class CheckIsElementNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int randomNumber = Integer.parseInt(scanner.nextLine());
        boolean isElementNumber = true;
        if (randomNumber < 2) {
            isElementNumber = false;
        } else {
            for (int i = 2; i <= Math.sqrt(randomNumber); i++) {
                if (randomNumber % 2 == 0) isElementNumber = false;
            }
        }
        System.out.println(isElementNumber ? "Là số nguyên" : "Không là số nguyên");
    }
}
