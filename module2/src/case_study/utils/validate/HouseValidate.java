package case_study.utils.validate;

import case_study.utils.exception.facility_exception.house_exception.HouseFloorException;
import case_study.utils.exception.facility_exception.house_exception.HouseRoomStandardException;

import java.util.Scanner;

public class HouseValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    private String regex;

    public String validateRoomStandards() {
        regex = "^[A-Z][a-z]+";

        while (true) {
            try {
                System.out.print("Nhập vào tiêu chuẩn phòng house: ");
                String houseStandard = SCANNER.nextLine();
                if (!(houseStandard.matches(regex))) {
                    throw new HouseRoomStandardException("Tiêu chuẩn phòng không hợp lệ! ");
                }
                return houseStandard;
            } catch (HouseRoomStandardException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer validateFloor() {
        while (true) {
            try {
                System.out.print("Nhập vào số tầng của house: ");
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
}
