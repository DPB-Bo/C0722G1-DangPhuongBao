package test_sth.test_java_work.test_regex;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
//        String mydata = "some string with \"the\" data i 'want' inside";
//        Pattern pattern = Pattern.compile("^\\d{1,2}[-|/]\\d{1,2}[-|/]\\d{4}$");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên: ");
        String name = scanner.nextLine();
        Pattern pattern = Pattern.compile("([A-Z][a-z][ ]+)+([A-Z][a-z]+)$");

        Matcher matcher = pattern.matcher(name);
//        System.out.println(matcher.group(0));
        System.out.println(matcher.matches());

//        System.out.println(matcher.groupCount());
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//        }
//        System.out.println(mydata);
//        System.out.println(mydata.replaceAll("\"", ""));


    }
}
