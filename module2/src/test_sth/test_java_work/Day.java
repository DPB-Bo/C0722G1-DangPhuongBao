package test_sth.test_java_work;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Day {
    public static void main(String[] args) {
        Date date = new Date(2223 - 1900, 2, 3);
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(dateFormat.format(date));
    }
}
