package ss13_binary_search.exercise.exercise_2;

import java.util.Scanner;

public class Main {
    public static int binarySearch(int[] array, int left, int right, int value) {
        if (right >= left) {
            int mid = (right + left) / 2;
            if (array[mid] == value) {
                return mid;
            }
            if (array[mid] < value) {
                return binarySearch(array, mid + 1, right, value);
            }
            return binarySearch(array, left, mid - 1, value);
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào độ dài của mảng: ");
        int size = Integer.parseInt(scanner.nextLine());

        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            System.out.printf("\nNhập vào phần tử thứ %d: ", (i + 1));
            array[i] = Integer.parseInt(scanner.nextLine());
        }

        System.out.print("\nNhập vào số cần tìm: ");
        int n = Integer.parseInt(scanner.nextLine());

        int indexSearch = binarySearch(array, 0, array.length - 1, n);
        if (indexSearch == -1) {
            System.out.println("\nKhông tìm thấy số vừa nhập trong mảng!");
        } else {
            System.out.println("\nSố vừa nhập có trong mảng!");
        }
    }
}
