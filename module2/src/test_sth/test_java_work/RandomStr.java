package test_sth.test_java_work;

import java.security.SecureRandom;

public class RandomStr {

    public static String generateRandomString() {
        String rangeID = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder str = new StringBuilder(3);

        for (int i = 0; i < 3; i++) {
            str.append(rangeID.charAt(random.nextInt(rangeID.length())));
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println(generateRandomString());
    }
}
