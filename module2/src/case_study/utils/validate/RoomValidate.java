package case_study.utils.validate;

import case_study.utils.exception.facility_exception.room_exception.RoomFreeServiceException;

import java.util.Scanner;

public class RoomValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    public String validateFreeService() {
        while (true) {
            try {
                System.out.print("Nhập vào dịch vụ miễn phí của room: ");
                String freeServiceIncluded = SCANNER.nextLine();
                if (freeServiceIncluded.length() < 1) {
                    throw new RoomFreeServiceException("Dịch vụ miễn phí không hợp lệ");
                }
                return freeServiceIncluded;
            } catch (RoomFreeServiceException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
