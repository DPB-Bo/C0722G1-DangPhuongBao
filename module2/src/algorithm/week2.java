package algorithm;

public class week2 {
    static boolean solution1(int[] arr) {
        int sumArr = 0;
        for (int number : arr) {
            sumArr += number;
        }
        for (int number = 1; number < arr.length - 1; number++) {
            if ((sumArr - arr[number]) % 2 != 0) {
                continue;
            }
            int sumLeft = 0;
            int sumRight = 0;
            for (int i = 0; i < number; i++) {
                sumLeft += arr[i];
            }
            for (int i = number + 1; i < arr.length; i++) {
                sumRight += arr[i];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    static boolean solution2(int[] arr) {
        for (int number = 1; number < arr.length - 1; number++) {
            int sumLeft = 0;
            int sumRight = 0;
            for (int i = 0; i < number; i++) {
                sumLeft += arr[i];
            }
            for (int i = number + 1; i < arr.length; i++) {
                sumRight += arr[i];
            }
            if (sumLeft == sumRight) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = new int[1000];
        for (int i = 0; i < 1000; i++) {
            arr[i] = (int) Math.floor(Math.random() * 100);
        }
        long startTime = System.nanoTime();
        System.out.println(week2.solution2(arr));
        long endTime = System.nanoTime();
        long totalTime = endTime - startTime;
        System.out.println(totalTime);
    }
}
//100 phần tử
// 517200 485300 413900 460700 302500 302200 528000 312700 539600 682200
// 527000 451900 468400 654500 811900 569700 325100 534900 367300 326600
// so1/so2 6/4

//1000 phần tử
// 2603000 2528300 2496900 3072600 2566300
// 5544400 4569500 4480700 4518400 5084000
// sol1/sol2 5/0