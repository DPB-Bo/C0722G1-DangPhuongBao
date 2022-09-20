package ss11_stack_queue.exercise.convert_10_to_2;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập vào 1 số: ");
        int n = Integer.parseInt(scanner.nextLine());
        Stack<Integer> stack = new Stack<>();

        int tempN = n;
        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }

        System.out.printf("Số nhị phân của %d là: ", tempN);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }
}
