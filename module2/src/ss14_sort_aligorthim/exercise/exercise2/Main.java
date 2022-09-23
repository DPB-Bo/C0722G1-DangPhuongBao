package ss14_sort_aligorthim.exercise.exercise2;

import java.util.Arrays;

public class Main {
    public static void insertionSort(int[] array) {
        int pos, x;
        for (int i = 1; i < array.length; i++) {
            x = array[i];
            pos = i;
            while (pos > 0 && x < array[pos - 1]) {
                array[pos] = array[pos - 1];
                pos--;
            }
            array[pos] = x;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 5, 6, 1, 23, 4, 4, 5, 7, 9};
        insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
