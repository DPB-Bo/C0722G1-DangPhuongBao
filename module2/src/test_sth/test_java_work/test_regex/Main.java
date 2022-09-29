package test_sth.test_java_work.test_regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        String mydata = "some string with \"the\" data i 'want' inside";
//        Pattern pattern = Pattern.compile("\"(.*?)\"");
//        Matcher matcher = pattern.matcher(mydata);

//        System.out.println(matcher.groupCount());
//        while (matcher.find()) {
//            System.out.println(matcher.group(1));
//        }
        System.out.println(mydata);
//        System.out.println(mydata.replaceAll("\"", ""));
    }
}
