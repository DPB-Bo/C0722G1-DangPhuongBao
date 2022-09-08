package ss3_array_method_in_java.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class FindMaxItemInArray {
    static Scanner scanner = new Scanner(System.in);

    public static Integer[] createArray(Integer sizeArray) {
        Integer[] arr = new Integer[sizeArray];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        return arr;
    }

    public static Integer sizeArray() {
        Integer sizeArray = -1;
        do {
            System.out.print("Nhập vào độ dài của mảng: ");
            sizeArray = Integer.parseInt(scanner.nextLine());
            if (sizeArray < 1) System.out.println("Vui lòng nhập độ dài hợp lệ!");
        } while (sizeArray < 1);
        return sizeArray;
    }

    public static Integer[][] createTwoDimensionalArray() {
        Integer amountChildArrays;
        do {
            System.out.print("Nhập vào số lượng mảng con: ");
            amountChildArrays = Integer.parseInt(scanner.nextLine());
            if (amountChildArrays < 1) System.out.println("Vui lòng nhập đàng hoàng =))");
        } while (amountChildArrays < 1);
        Integer[][] arrTwoDimensional = new Integer[amountChildArrays][];
        for (int i = 0; i < arrTwoDimensional.length; i++) {
            System.out.println("Nhập vào mảng thứ " + (i + 1));
            arrTwoDimensional[i] = createArray(sizeArray());
        }
        return arrTwoDimensional;
    }

    public static void displayTwoDimensionalArray(Integer[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(Arrays.toString(arr[i]));
        }
    }

    public static void main(String[] args) {
        Integer[][] matrix = createTwoDimensionalArray();
        displayTwoDimensionalArray(matrix);
        Integer maxNumber = matrix[0][0];
        Integer rowMax = 0;
        Integer colMax = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (maxNumber < matrix[i][j]) {
                    maxNumber = matrix[i][j];
                    rowMax = i;
                    colMax = j;
                }
            }
        }
        System.out.printf("Số lớn nhất trong mảng : %d ", maxNumber);
        System.out.printf("Toạ độ số lớn nhất trong mảng : %d,%d ", rowMax, colMax);
    }

}
