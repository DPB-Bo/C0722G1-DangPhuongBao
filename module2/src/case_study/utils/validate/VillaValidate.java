package case_study.utils.validate;

import case_study.utils.exception.facility_exception.house_exception.HouseFloorException;
import case_study.utils.exception.facility_exception.house_exception.HouseRoomStandardException;
import case_study.utils.exception.facility_exception.villa_exception.VillaPoolAreaException;
import case_study.utils.exception.facility_exception.villa_exception.VillaRoomStandardException;

import java.util.Scanner;

public class VillaValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    private String regex;

    public String validateRoomStandards() {
        regex = "^[A-Z][a-z]+";

        while (true) {
            try {
                System.out.print("Nhập vào tiêu chuẩn phòng villa: ");
                String villaStandard = SCANNER.nextLine();
                if (!(villaStandard.matches(regex))) {
                    throw new VillaRoomStandardException("Tiêu chuẩn phòng không hợp lệ! ");
                }
                return villaStandard;
            } catch (VillaRoomStandardException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer validateFloor() {
        while (true) {
            try {
                System.out.print("Nhập vào số tầng của villa: ");
                Integer floor = Integer.parseInt(SCANNER.nextLine());
                if (!(floor < 0)) {
                    throw new HouseFloorException("Số tầng không hợp lệ");
                }
                return floor;
            } catch (HouseFloorException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Double validatePoorArea() {
        while (true) {
            try {
                System.out.print("Nhập vào diện tích hồ bơi: ");
                Double poorArea = Double.parseDouble(SCANNER.nextLine());
                if (!(poorArea < 30)) {
                    throw new VillaPoolAreaException("Diện tích hồ bơi không hợp lệ!");
                }
                return poorArea;
            } catch (VillaPoolAreaException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
