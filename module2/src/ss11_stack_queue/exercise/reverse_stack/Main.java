package ss11_stack_queue.exercise.reverse_stack;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void inputNumberStack() {
        Stack<Integer> stack = new Stack<>();
        int length;
        while (true) {
            System.out.println("Nhập vào số lượng phần tử ");
            length = Integer.parseInt(scanner.nextLine());
            if (length < 0) {
                System.out.println("Vui lòng nhập lại! ");
            } else {
                break;
            }
        }
        for (int index = 0; index < length; index++) {
            System.out.printf("Nhập vào phần tử thứ %d: ", (index + 1));
            stack.push(Integer.parseInt(scanner.nextLine()));
        }
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }

    public static void inputStringStack() {
        Stack<String> stack = new Stack<>();

        System.out.print("Nhập vào một chuỗi: ");
        String str = scanner.nextLine();

        String[] arrStr = str.split(" ");

        for (int index = 0; index < arrStr.length; index++) {
            stack.push(arrStr[index]);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public static void main(String[] args) {
        System.out.println("Stack nhập vào số");
        inputNumberStack();
        System.out.println("Stack nhập vào 1 chuỗi");
        inputStringStack();
    }
}
