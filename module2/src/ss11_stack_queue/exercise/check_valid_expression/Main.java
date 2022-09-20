package ss11_stack_queue.exercise.check_valid_expression;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập vào biểu thức cần kiểm tra: ");
        String str = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        Character bracketLeft = '(';
        int countBracketLeft = 0;
        Character bracketRight = ')';
        int countBracketRight = ')';
        for (int index = 0; index < str.length(); index++) {
            if (str.charAt(index) == bracketLeft) {
                stack.push(str.charAt(index));
                countBracketLeft++;
            }
            if (str.charAt(index) == bracketRight) {
                stack.push(str.charAt(index));
                countBracketRight++;
            }
        }

        boolean flag = true;

        if (stack.get(0) != bracketLeft) {
            flag = false;
        } else if (countBracketLeft != countBracketRight) {
            flag = false;
        }
        
        System.out.print(flag ? "Biểu thức hợp lệ" : "Biểu thức không hợp lệ");
    }
}
