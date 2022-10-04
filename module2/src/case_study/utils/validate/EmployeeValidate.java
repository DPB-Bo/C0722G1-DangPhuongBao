package case_study.utils.validate;

import case_study.utils.exception.person_exception.employee_exception.LevelException;
import case_study.utils.exception.person_exception.employee_exception.PositionException;
import case_study.utils.exception.person_exception.employee_exception.WageException;

import java.util.Scanner;

public class EmployeeValidate {
    private final String[] levelList = {"Trung đẳng", "Cao đẳng", "Đại học", "Sau đại học"};
    private final String[] positionList = {"Lễ tân", "Phục vụ", "Chuyên viên", "Giám sát", "Quản lý", "Giám đốc"};

    private final Scanner SCANNER = new Scanner(System.in);

    public String validateLevel() {
        while (true) {
            try {
                System.out.println("Các trình độ hiện có : Trung đẳng,Cao đẳng,Đại học,Sau đại học");
                System.out.print("Mời nhập trình độ của nhân viên: ");
                String tempLevel = SCANNER.nextLine();
                for (String level : levelList) {
                    if (level.equals(tempLevel)) {
                        return tempLevel;
                    }
                }
                throw new LevelException("Trình độ không hợp lệ!");
            } catch (LevelException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validatePosition() {
        while (true) {
            try {
                System.out.println("Các vị trí hiện có: Lễ tân,Phục vụ,Chuyên viên,Giám sát,Quản lý,Giám đốc");
                System.out.print("Mời nhập vị trí của nhân viên: ");
                String tempPos = SCANNER.nextLine();
                for (String position : positionList) {
                    if (position.equals(tempPos)) {
                        return tempPos;
                    }
                }
                throw new PositionException("Vị trí không hợp lệ!");
            } catch (PositionException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Double validateWage() {
        while (true) {
            try {
                System.out.print("Nhập vào lương của nhân viên: ");
                Double tempWage = Double.parseDouble(SCANNER.nextLine());
                if (tempWage < 0 || tempWage > 1000000000) {
                    throw new WageException("Lương không hợp lệ!");
                }
                return tempWage;
            } catch (WageException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException nfe) {
                System.out.println("Sai định dạng");
            }
        }
    }

}
