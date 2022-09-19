package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Car;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Producer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarList<E extends Car> {
    private static Scanner scanner = new Scanner(System.in);
    private List<E> items;

    public CarList() {
        items = new ArrayList<>();
    }

    public E inputInformation(E e) {
        System.out.print("\nNhập vào biển kiểm soát: ");
        String code = scanner.nextLine();
        e.setCode(code);

        displayMenuProducer();
        Producer producer = ProducerService.getProducers().get(getChoiceProducer());
        e.setProducer(producer);

        System.out.print("\nNhập vào năm sản xuất: ");
        Integer year = Integer.parseInt(scanner.nextLine());
        e.setYear(year);

        System.out.print("\nNhập vào chủ sở hữu: ");
        String owner = scanner.nextLine();
        e.setOwner(owner);

        return e;
    }

    private static int getChoiceProducer() {
        int choiceProducer = -1;
        boolean isNotValidChoice = choiceProducer < 0 || choiceProducer > (ProducerService.getProducers().size()) - 1;
        do {
            System.out.print("\nChọn hãng sản xuất: ");
            choiceProducer = Integer.parseInt(scanner.nextLine());
            if (isNotValidChoice) {
                System.out.println("\nKhông có hãng sản xuất với số thứ tự này! Vui lòng nhập lại!");
            }
        } while (isNotValidChoice);
        return choiceProducer;
    }

    public void add(E e) {
        items.add(e);
        System.out.println("Thêm mới thành công!");
    }

    public void display() {
        if (items.size() == 0) {
            System.out.println("Danh sách rỗng, vui lòng thêm mới");
        } else {
            for (E item : items) {
                System.out.println(item);
            }
        }
    }

    public boolean remove(String code) {
        boolean flagDelete = false;

        for (E item : items) {
            if (item.getCode().equals(code)) {
                System.out.printf("\nBạn có chắc muốn xóa xe có mã %d này không? Nhập Y: yes, N: no\n", code);
                String choice = scanner.nextLine();
                if (choice.equals("Y")) {
                    items.remove(item);
                    System.out.println("\nXóa thành công");
                } else {
                    System.out.println("\nXoá không thành công");
                }
                flagDelete = true;
                break;
            }
        }

        return flagDelete;
    }

    private void displayMenuProducer() {
        for (int i = 0; i < ProducerService.getProducers().size(); i++) {
            System.out.println("\n" + i + ". " + ProducerService.getProducers().get(i).getName());
        }
    }

    public boolean search(String code) {
        boolean flagFound = false;

        for (E item : items) {
            if (item.getCode().contains(code)) {
                System.out.println("\n" + item);
                flagFound = true;
            }
        }

        return flagFound;
    }
}
