package ss11_stack_queue.exercise.check_valid_expression;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào biểu thức cần kiểm tra: ");
        String str = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        Character bracketLeft = ')';
        Character bracketRight = '(';
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index) == bracketLeft || str.charAt(index) == bracketRight) {
                stack.push(str.charAt(index));
            }
        }

        boolean flag = true;

        while (stack.size() > 1) {
            if (stack.pop() == stack.get(stack.size() - 1)) {
                flag = false;
                break;
            }
        }

        System.out.print(flag ? "Biểu thức hợp lệ" : "Biểu thức không hợp lệ");
    }
}
