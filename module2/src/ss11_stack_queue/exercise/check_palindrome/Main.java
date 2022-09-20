package ss11_stack_queue.exercise.check_palindrome;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào 1 chuỗi: ");
        String str = scanner.nextLine();
        str = str.toLowerCase();
        String[] arrStr = str.split("");

        Stack<String> stack = new Stack<>();

        boolean flag = true;

        for (String string : arrStr) {
            stack.push(string);
        }

        for (String string : arrStr) {
            if (!(string.equals(stack.pop()))) {
                flag = false;
                break;
            }
        }

        System.out.printf(flag ? "\n%s là chuỗi palindrome" : "\n%s không là chuỗi palindrome", str);
    }
}
