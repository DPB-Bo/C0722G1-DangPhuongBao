package ss13_binary_search.exercise.exercise_3;

import java.util.*;

public class Main {
    private static String binarySearch(String str) {
        ArrayList<String> list = new ArrayList<String>(Arrays.asList(str.split("")));
        StringBuilder result = new StringBuilder(list.get(0));
        List<String> listString = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            if (i == str.length() - 1) {
                listString.add(result.toString());
                break;
            } else {
                int compareStr = list.get(i).compareTo(list.get(i + 1));
                if (compareStr < 0) {
                    result.append(list.get(i + 1));
                } else {
                    listString.add(result.toString());
                    result = new StringBuilder(list.get(i + 1));
                }
            }
        }
        int maxLength = 0;
        int indexMax = 0;
        for (int index = 0; index < listString.size(); index++) {
            if (listString.get(index).length() > maxLength) {
                maxLength = listString.get(index).length();
                indexMax = index;
            }
        }
        return listString.get(indexMax);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào 1 chuỗi: ");
        String str = scanner.nextLine();

        System.out.println("\nChuỗi tăng dần có độ dài lớn nhất là: " + binarySearch(str));
    }
}
