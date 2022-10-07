package test_sth.test_java_work;

import sun.util.resources.LocaleData;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

public class TestLocalDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập vào ngày tháng năm");
            String[] dayParts = scanner.nextLine().split("/");
            try {
                LocalDate date = LocalDate.of(Integer.parseInt(dayParts[2]), Integer.parseInt(dayParts[1]) - 1, Integer.parseInt(dayParts[0]));
            } catch (DateTimeException e) {
                System.out.println(e.getMessage());
            }
            break;
        }
    }
}
