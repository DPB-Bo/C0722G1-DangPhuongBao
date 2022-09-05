package ss1_introduction_to_java.practice;


import java.util.Date;

public class DisplayDate {
    Date bao = new Date();

    public static void main(String[] args) {
        System.out.println("Hôm nay là: " + new DisplayDate().bao);
    }
}
