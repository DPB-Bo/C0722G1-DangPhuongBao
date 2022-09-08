package ss3_array_method_in_java.exercises;

import java.util.Scanner;

public class FindCharInString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();
        System.out.printf("Chuỗi vừa nhập là: %s", str);
        System.out.print("\nNhập vào kí tự muốn tìm kiếm: ");
        Character findChar = scanner.nextLine().charAt(0);
        Integer count = 0;
        Integer[] indexFound = new Integer[str.length()];
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == findChar) {
                count++;
                indexFound[i] = i;
            }
        }
        if (count != 0) {
            System.out.printf("Kí tự vừa nhập xuất hiện %d trong chuỗi", count);
            System.out.print("\nKí tự xuất hiện ở vị trí: ");
            for (int i = 0; i < indexFound.length; i++) {
                if (indexFound[i] != null) {
                    System.out.print((indexFound[i] + 1));
                    if (count > 1) {
                        System.out.print(",");
                        count--;
                    }
                }
            }
        } else {
            System.out.print("Không phát hiện kí tự!");
        }
    }
}
