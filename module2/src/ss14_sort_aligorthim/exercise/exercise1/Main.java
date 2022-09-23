package ss14_sort_aligorthim.exercise.exercise1;

import java.util.Arrays;

public class Main {
    public static void insertionSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            System.out.printf("\nGắn X cho phần tử tại vị trí %d của mảng bằng %d", i, array[i]);
            pos = i;
            System.out.printf("\nGắn pos cho vị trí %d của mảng\n", i);
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
            System.out.printf("\nGán lại phần tử tại trí %d cho bằng %d", pos, x);
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 1, 23, 4, 4, 5, 7, 9};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
