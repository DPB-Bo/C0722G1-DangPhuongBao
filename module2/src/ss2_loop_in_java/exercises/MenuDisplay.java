package ss2_loop_in_java.exercises;

import java.util.Scanner;

public class MenuDisplay {
    Scanner scanner = new Scanner(System.in);

    public String drawRectangle() {
        String result = "";
        String lineRectangle = "";
        System.out.println("Nhập vào chiều cao:");
        int x = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập và chiều dài:");
        int y = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < y; i++) {
            lineRectangle += "*";
        }
        for (int i = 0; i < x; i++) {
            result += lineRectangle + "\n";
        }
        return result;
    }

    public String drawSquareTriangle() {
        String result = "";
        String result1 = "";
        String result2 = "";
        String result3 = "";
        String result4 = "";
        System.out.println("Nhập vào chiều cao:");
        int x = Integer.parseInt(scanner.nextLine());
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= i; j++) {
                result1 += "*";
            }
            result1 += "\n";
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x - i; j++) {
                result2 += " ";
            }
            for (int t = 1; t <= i; t++) {
                result2 += "*";
            }
            result2 += "\n";
        }

        for (int i = 1; i <= x; i++) {
            for (int j = i; j <= x; j++) {
                result3 += "*";
            }
            result3 += "\n";
        }

        for (int i = 1; i <= x; i++) {
            for (int j = 1; j < i; j++) {
                result4 += " ";
            }
            for (int t = i; t <= x; t++) {
                result4 += "*";
            }
            result4 += "\n";
        }

        result = result1 + "\n" + result2 + "\n" + result3 + "\n" + result4;
        return result;
    }

    public String drawIsosceleTriangle() {
        String result = "";
        System.out.println("Nhập vào chiều cao:");
        int x = Integer.parseInt(scanner.nextLine());
        int left = x - 1;
        int right = x + 1;
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= left; j++) {
                result += " ";
            }
            for (int m = 1; m <= (2 * i) - 1; m++) {
                result += "*";
            }
            for (int n = right; n <= (2 * x) - 1; n++) {
                result += " ";
            }
            result += "\n";
            left--;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner mainScanner = new Scanner(System.in);
        int choice = -1;
        MenuDisplay menuDisplay = new MenuDisplay();
        while (choice != 0) {
            System.out.print("------Menu-----\n" +
                    "1. Draw the rectangle\n" +
                    "2. Draw the square triangle\n" +
                    "3. Draw the isoscele triangle\n" +
                    "0. Exit\n" +
                    "Enter your choice here: ");
            choice = Integer.parseInt(mainScanner.nextLine());
            switch (choice) { //print trực tiếp - dùng method void -> nhanh hơn
                case 1:
                    System.out.println(menuDisplay.drawRectangle());
                    break;
                case 2:
                    System.out.println(menuDisplay.drawSquareTriangle());
                    break;
                case 3:
                    System.out.println(menuDisplay.drawIsosceleTriangle());
                    break;
            }
        }
    }
}
