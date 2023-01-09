package test_sth.test_java_work;

//import sun.util.resources.LocaleData;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class TestLocalDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Nhập vào ngày tháng năm");
            String dateStr = scanner.nextLine();
            try {
                DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                sdf.setLenient(false);
                Date date = sdf.parse(dateStr);
                LocalDate localDate = LocalDate.of(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
                System.out.println(localDate);
                break;
            } catch (ParseException e) {
                System.out.println("Error parsing date string");
            }
        }
    }
}
