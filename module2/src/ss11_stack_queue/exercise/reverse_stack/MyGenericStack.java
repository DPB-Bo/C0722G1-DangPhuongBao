package ss11_stack_queue.exercise.reverse_stack;

import java.util.ArrayList;
import java.util.Scanner;

public class MyGenericStack<T> {
    private static final Scanner SCANNER = new Scanner(System.in);
    private ArrayList<T> stack;

    public MyGenericStack() {
        stack = new ArrayList<>();
    }

    private int inputAmountAdd() {
        int length;
        boolean validLength = false;
        do {
            System.out.print("Nhập vào độ dài của mảng: ");
            length = Integer.parseInt(SCANNER.nextLine());
            if (length <= 0) {
                System.out.println("vui lòng nhập lại! ");
            }
        } while (validLength);
        return length;
    }

    public void inputElement() {
        int length = inputAmountAdd();
        for (int index = 0; index < length; index++) {
            System.out.println("\nNhập vào phần tử thứ " + (index + 1));
            stack.add((T) SCANNER.nextLine());
        }
    }

    public void display() {
        System.out.println("\n" + stack);
    }

    public void reverseArray() {
        ArrayList<T> tempStack = new ArrayList<>();
        for (int index = stack.size() - 1; index >= 0; index--) {
            tempStack.add(stack.get(index));
        }
        stack = tempStack;
    }

    public boolean isEmpty() {
        return stack.size() == 0;
    }

    public static void main(String[] args) {
        MyGenericStack<Integer> integerArray = new MyGenericStack<>();
        integerArray.inputElement();
        System.out.println("\n Mảng số ban đầu là: ");
        integerArray.reverseArray();
        System.out.println("\n Mảng lúc sau là: ");

    }
}
