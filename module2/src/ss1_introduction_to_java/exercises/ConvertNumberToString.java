package ss1_introduction_to_java.exercises;


import java.util.Scanner;

public class ConvertNumberToString {
    String[][] numberToString = {
            {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"},
            {"KHÔNG ", "MỘT ", "HAI ", "BA ", "BỐN ", "NĂM ", "SÁU ", "BẢY ", "TÁM ", "CHÍN "}
    };

    String result;

    public String oneNumber(String randomNumber) {
        for (int i = 0; i < numberToString[0].length; i++) {
            if (randomNumber.equals(numberToString[0][i])) {
                result = numberToString[1][i];
                break;
            }
        }
        return result;
    }

    public String twoNumber(String randomNumber) {
        for (int j = 0; j < numberToString[0].length; j++) {
            if (Character.toString(randomNumber.charAt(0)).equals(numberToString[0][j])) {
                if (Character.toString(randomNumber.charAt(0)).equals("1")) {
                    result = "MƯỜI ";
                } else {
                    result = numberToString[1][j] + "MƯƠI ";
                }
            }
        }
        for (int j = 0; j < numberToString[0].length; j++) {
            if (Character.toString(randomNumber.charAt(1)).equals(numberToString[0][j])) {
                if (Character.toString(randomNumber.charAt(1)).equals("0")) {
                    return result;
                } else {
                    result += numberToString[1][j]; // sao ở đây dấu += lại gạch dưới
                }
            }
        }
        return result;
    }

    public String threeNumber(String randomNumber) {
        boolean secondIsZero = Character.toString(randomNumber.charAt(1)).equals("0");
        boolean thirdIsZero = Character.toString(randomNumber.charAt(2)).equals("0");
        for (int j = 0; j < numberToString[0].length; j++) {
            if (Character.toString(randomNumber.charAt(0)).equals(numberToString[0][j])) {
                result = numberToString[1][j] + "TRĂM ";
            }
        }
        if (secondIsZero && thirdIsZero) {
            return result;
        }
        for (int j = 0; j < numberToString[0].length; j++) {
            if (Character.toString(randomNumber.charAt(1)).equals(numberToString[0][j])) {
                if (secondIsZero) {
                    result += "LINH ";
                } else if (Character.toString(randomNumber.charAt(1)).equals("1")) {
                    result = "MƯỜI ";
                } else {
                    result += numberToString[1][j] + "MƯƠI ";
                }
            }
        }
        for (int j = 0; j < numberToString[0].length; j++) {
            if (Character.toString(randomNumber.charAt(2)).equals(numberToString[0][j])) {
                if (thirdIsZero) {
                    return result;
                } else {
                    result += numberToString[1][j];
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ConvertNumberToString result = new ConvertNumberToString();
        Scanner scanner = new Scanner(System.in);
        int randomNumber;
        do {
            System.out.println("Nhập và 1 số từ 1-999: ");
            randomNumber = scanner.nextInt(); // vi du ở đây muốn bắt lỗi người dùng nhập vào k phải int thì làm sao @@!
        } while (randomNumber < 0 || randomNumber > 999);
        String stringRandomNumber = Integer.toString(randomNumber);
        if (stringRandomNumber.length() == 1) System.out.println(result.oneNumber(stringRandomNumber));
        if (stringRandomNumber.length() == 2) System.out.println(result.twoNumber(stringRandomNumber));
        if (stringRandomNumber.length() == 3) System.out.println(result.threeNumber(stringRandomNumber));
    }
}
