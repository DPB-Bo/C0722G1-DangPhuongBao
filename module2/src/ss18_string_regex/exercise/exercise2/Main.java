package ss18_string_regex.exercise.exercise2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào số điện thoại: ");
        String phoneNumber = scanner.nextLine();
        Pattern pattern = Pattern.compile("[0-9]{2}-0[0-9]{9}");
        Matcher matcher = pattern.matcher(phoneNumber);
        System.out.println(matcher.matches());
    }
}
