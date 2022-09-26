package ss10_arraylist_linkedlist.exercise.mvc_exercise_2.service.impl;

import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.car_exception.ChoiceProducerException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.car_exception.CodeException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.car_exception.OwnerException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.exception.car_exception.YearException;
import ss10_arraylist_linkedlist.exercise.mvc_exercise_2.model.Car;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarList<E extends Car> {
    private final Scanner scanner = new Scanner(System.in);
    private List<E> items;

    public CarList() {
        items = new ArrayList<>();
    }

    public void inputInformation(E e) {
        e.setCode(checkCodeOfCar());

        displayMenuProducer();
        e.setProducer(ProducerService.getProducers().get(checkChoiceOfProducer()));

        e.setYear(checkYearOfCar());

        e.setOwner(checkOwnerOfCar());
    }

    private String checkCodeOfCar() {
        String code;

        while (true) {
            try {
                System.out.print("\nNhập vào biển kiểm soát: ");
                code = scanner.nextLine();
                boolean isNotValidCode = code.length() != 6;
                if (isNotValidCode) {
                    throw new CodeException("Biển số xe không hợp lệ (6 số). Vui lòng nhập lại");
                }
                break;
            } catch (CodeException e) {
                System.out.println(e.getMessage());
            }
        }

        return code;
    }

    private Integer checkYearOfCar() {
        int year;

        while (true) {
            try {
                int yearNow = LocalDate.now().getYear();
                System.out.print("\nNhập vào năm sản xuất: ");
                year = Integer.parseInt(scanner.nextLine());
                boolean isNotValidYear = year > yearNow || year < 2000;
                if (isNotValidYear) {
                    throw new YearException("Năm nhập vào không hợp lệ (>2000).Vui lòng nhập lại!");
                }
                break;
            } catch (YearException e) {
                System.out.println(e.getMessage());
            }
        }
        return year;
    }

    private String checkOwnerOfCar() {
        String owner;

        while (true) {
            try {
                System.out.print("\nNhập vào họ và tên chủ sở hữu: ");
                owner = scanner.nextLine();
                boolean isNotVallidOwner = owner.length() < 2 || owner.length() > 30 || checkContainsNumbers(owner);
                if (isNotVallidOwner) {
                    throw new OwnerException("Tên chủ sở hữu không hợp lệ");
                }
                break;
            } catch (OwnerException e) {
                System.out.println(e.getMessage());
            }
        }

        return owner;
    }

    private int checkChoiceOfProducer() {
        int choiceProducer;

        while (true) {
            try {
                System.out.print("\nChọn hãng sản xuất: ");
                choiceProducer = Integer.parseInt(scanner.nextLine());
                boolean isNotValidChoice = choiceProducer < 0 || choiceProducer > (ProducerService.getProducers().size()) - 1;
                if (isNotValidChoice) {
                    throw new ChoiceProducerException("Không có lựa chọn này. Vui lòng nhập lại!");
                }
                break;
            } catch (ChoiceProducerException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }

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

    private boolean checkContainsNumbers(String s) {
        char[] chars = s.toCharArray();
        for (char c : chars) {
            if (Character.isDigit(c)) {
                return true;
            }
        }
        return false;
    }
}
