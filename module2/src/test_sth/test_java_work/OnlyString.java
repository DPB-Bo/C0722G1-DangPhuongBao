package test_sth.test_java_work;

public class OnlyString {
    public static void main(String[] args) {
        boolean flag = false;
        String s = "D1";
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) flag = true;
        }
        System.out.println(flag);
    }
}
