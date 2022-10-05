package case_study.utils.validate;

import case_study.enum_package.FacilityEnum;
import case_study.utils.exception.facility_exception.*;

import java.util.Scanner;

public class FacilityValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    private String regex;

    private final String[] RENTALLIST = {"Năm", "Tháng", "Ngày", "Giờ"};
    private String callName;

    private String getCallName(FacilityEnum facilityEnum) {
        switch (facilityEnum) {
            case HOUSE:
                return "house";
            case VILLA:
                return "villa";
            case ROOM:
                return "room";
        }
        return "unknown";
    }

    public String validateCode(FacilityEnum facilityEnum) {
        callName = getCallName(facilityEnum);
        switch (facilityEnum) {
            case ROOM:
                regex = "^SVRO-[0-9]{4}$";
                break;
            case HOUSE:
                regex = "^SVHO-[0-9]{4}";
                break;
            case VILLA:
                regex = "^SVVL-[0-9]{4}";
                break;
        }

        while (true) {
            try {
                System.out.printf("Nhập vào mã dịch vụ của %s: ", callName);
                String code = SCANNER.nextLine();
                if (!(code.matches(regex))) {
                    throw new FacilityCodeException("Mã code không đúng định dạng");
                }
                return code;
            } catch (FacilityCodeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateName(FacilityEnum facilityEnum) {
        callName = getCallName(facilityEnum);
        regex = "^[A-Z][a-z]+";

        while (true) {
            try {
                System.out.printf("Nhập vào tên dịch vụ của %s: ", callName);
                String name = SCANNER.nextLine();
                if (!(name.equals(regex))) {
                    throw new FacilityNameException("Tên không đúng định dạng");
                }
                return name;
            } catch (FacilityNameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Double validateArea(FacilityEnum facilityEnum) {
        callName = getCallName(facilityEnum);

        while (true) {
            try {
                System.out.printf("Nhập vào diện tích của %s: ", callName);
                Double area = Double.parseDouble(SCANNER.nextLine());

                if (area < 30) {
                    throw new FacilityAreaException("Diện tích không hợp lệ");
                }
                return area;
            } catch (FacilityAreaException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Double validatePrice(FacilityEnum facilityEnum) {
        callName = getCallName(facilityEnum);

        while (true) {
            try {
                System.out.printf("Nhập vào chi phí dịch vụ của %s: ", callName);
                Double price = Double.parseDouble(SCANNER.nextLine());

                if (price < 0) {
                    throw new FacilityPriceException("Chi phí thuê không hợp lệ");
                }
                return price;
            } catch (FacilityPriceException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer validateMaxPeople(FacilityEnum facilityEnum) {
        callName = getCallName(facilityEnum);

        while (true) {
            try {
                System.out.printf("Nhập vào số người tối đa có thể sử dụng %s: ", callName);
                Integer maxPeople = Integer.parseInt(SCANNER.nextLine());

                if (maxPeople < 0 || maxPeople > 20) {
                    throw new FacilityMaxPeopleException("Số người tối đa không hợp lệ");
                }
                return maxPeople;
            } catch (FacilityMaxPeopleException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateRental(FacilityEnum facilityEnum) {
        callName = getCallName(facilityEnum);

        while (true) {
            try {
                System.out.println("Danh sách kiểu thuê: ");
                for (int i = 0; i < RENTALLIST.length; i++) {
                    System.out.printf("%s.Theo %s\n", i, RENTALLIST[i]);
                }
                System.out.print("Nhập vào lựa chọn của bạn: ");

                int choice = Integer.parseInt(SCANNER.nextLine());
                if (choice < 0 || choice >= RENTALLIST.length) {
                    throw new FacilityRentalTypeException("Nhập lựa chọn sai!");
                }
                return RENTALLIST[choice];
            } catch (FacilityRentalTypeException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    
}
