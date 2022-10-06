package case_study.utils.validate;

import case_study.utils.exception.booking_exception.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class BookingValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    private String regex;

    public String validateBookingCode() {
        regex = "BK(VL|RO|HO)-[0-9]{3}";

        while (true) {
            try {
                System.out.println("Nhập vào mã booking: ");
                String code = SCANNER.nextLine();

                if (!(code.matches(regex))) {
                    throw new BookingCodeException("Mã không hợp lệ! ");
                }
                return code;
            } catch (BookingCodeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Date validateStartDate() {
        regex = "^(\\d{2}|\\d)/(\\d{2}|\\d)/\\d{4}$";
        while (true) {
            try {
                System.out.print("Nhập vào ngày bắt đầu thuê dịch vụ(ngày/tháng/năm): ");
                String startDate = SCANNER.nextLine();
                if (!(startDate.matches(regex))) {
                    throw new StartDateException("Không đúng định dạng");
                }
                String[] dateParts = startDate.split("/");
                boolean isDateException = (Integer.parseInt(dateParts[1]) > LocalDate.now().getMonthValue() && Integer.parseInt(dateParts[0]) > LocalDate.now().getDayOfMonth()) || Integer.parseInt(dateParts[2]) > LocalDate.now().getYear() + 100;
                if (isDateException) {
                    throw new StartDateException("Ngày không hợp lệ!");
                }
                return new Date(Integer.parseInt(dateParts[2]) - 1900, Integer.parseInt(dateParts[1]) - 1, Integer.parseInt(dateParts[0]));
            } catch (StartDateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Date validateEndDate() {
        regex = "^(\\d{2}|\\d)/(\\d{2}|\\d)/\\d{4}$";
        while (true) {
            try {
                System.out.print("Nhập vào ngày dừng thuê dịch vụ(ngày/tháng/năm): ");
                String startDate = SCANNER.nextLine();
                if (!(startDate.matches(regex))) {
                    throw new EndDateException("Không đúng định dạng");
                }
                String[] dateParts = startDate.split("/");
                boolean isDateException = (Integer.parseInt(dateParts[1]) > LocalDate.now().getMonthValue() && Integer.parseInt(dateParts[0]) > LocalDate.now().getDayOfMonth()) || Integer.parseInt(dateParts[2]) > LocalDate.now().getYear() + 100;
                if (isDateException) {
                    throw new EndDateException("Ngày không hợp lệ!");
                }
                return new Date(Integer.parseInt(dateParts[2]) - 1900, Integer.parseInt(dateParts[1]) - 1, Integer.parseInt(dateParts[0]));
            } catch (EndDateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateCustomerCode(ArrayList<String> customerCodeList) {
        while (true) {
            try {
                System.out.println("DANH SÁCH MÃ KHÁCH HÀNG HIỆN CÓ: ");
                for (String customerCode : customerCodeList) {
                    System.out.printf("%s. %s", customerCodeList.indexOf(customerCode), customerCode);
                }
                System.out.println("Nhập mã khách hàng hàng: ");
                String bookingCustomerCode = SCANNER.nextLine();
                if (!(customerCodeList.contains(bookingCustomerCode))) {
                    throw new BookingCustomerCodeException("Không tồn tại mã khách hàng này");
                }
                return bookingCustomerCode;
            } catch (BookingCustomerCodeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateServiceCode(ArrayList<String> serviceCodeList) {
        while (true) {
            try {
                System.out.println("DANH SÁCH MÃ DỊCH VỤ HIỆN CÓ: ");
                for (String serviceCode : serviceCodeList) {
                    System.out.printf("%s. %s", serviceCodeList.indexOf(serviceCode), serviceCode);
                }
                System.out.print("Nhập mã dịch vụ: ");
                String bookingServiceCode = SCANNER.nextLine();
                if (!(serviceCodeList.contains(bookingServiceCode))) {
                    throw new BookingServiceCodeException("Không tồn tại mã dịch vụ này");
                }
                return bookingServiceCode;
            } catch (BookingServiceCodeException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public String validateServiceType(String serviceCode) {
        regex = "\\s+";

        while (true) {
            try {
                String serviceType = "";
                if (serviceCode.contains("VL")) {
                    serviceType = "Villa";
                }
                if (serviceCode.contains("RO")) {
                    serviceType = "Room";
                }
                if (serviceCode.contains("HO")) {
                    serviceType = "House";
                }
                if (serviceType.isEmpty()) {
                    throw new BookingServiceTypeException("Kiểu dịch vụ không hợp lệ");
                }
                return serviceType;
            } catch (BookingServiceTypeException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
