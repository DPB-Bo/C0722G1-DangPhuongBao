package com.codegym.utils;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;

@Component
public class RandomString {
    public static String generateRandomString() {
        String rangeID = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        SecureRandom random = new SecureRandom();
        StringBuilder str = new StringBuilder(5);

        for (int i = 0; i < 5; i++) {
            str.append(rangeID.charAt(random.nextInt(rangeID.length())));
        }
        return str.toString();
    }
}
