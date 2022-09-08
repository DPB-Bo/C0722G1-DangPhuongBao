package ss3_array_method_in_java.exercises;

import java.util.Arrays;
import java.util.Scanner;

public class SumDiagonalArray2D {
    static Scanner scanner = new Scanner(System.in);

    public static Integer[] createArray(Integer sizeArray) {
        Integer[] arr = new Integer[sizeArray];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (i + 1));
            arr[i] = Integer.parseInt(scanner.nextLine());
        }
        return arr;
    }

    public static Integer sizeArray(int amountDArrays) {
        int sizeArray;
        do {
            System.out.printf("Nhập vào độ dài của mảng %d chiều: ", amountDArrays);
            sizeArray = Integer.parseInt(scanner.nextLine());
            if (sizeArray < 1) System.out.println("Vui lòng nhập độ dài hợp lệ!");
        } while (sizeArray < 1);
        return sizeArray;
    }

    public static void displayTwoDimensionalArray(Integer[][] arr) {
        System.out.print("Mảng 2 chiều vừa nhập là: ");
        for (Integer[] item : arr) {
            System.out.print(Arrays.toString(item));
        }
        System.out.print("\n");
    }

    public static Integer[][] createTwoDimensionalArray() {
        Integer amountChildArrays = sizeArray(2);
        Integer[][] arrTwoDimensional = new Integer[amountChildArrays][];
        for (int i = 0; i < arrTwoDimensional.length; i++) {
            System.out.println("Nhập vào mảng thứ " + (i + 1));
            arrTwoDimensional[i] = createArray(sizeArray(1));
        }
        return arrTwoDimensional;
    }

    public static void main(String[] args) {
        Integer[][] arr2D = createTwoDimensionalArray();
        displayTwoDimensionalArray(arr2D);
        Integer sumDiagonalLeft = 0;

        for (int i = 0; i < arr2D.length; i++) {
            if (i < arr2D[i].length) sumDiagonalLeft += arr2D[i][i];
        }

        System.out.printf("Tổng đường chéo trái là %d: ", sumDiagonalLeft);
    }
}
