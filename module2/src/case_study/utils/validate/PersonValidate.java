package case_study.utils.validate;

import case_study.utils.exception.person_exception.*;

import java.util.Date;
import java.util.Scanner;
import java.util.zip.DataFormatException;

public class PersonValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    private String regex;

    public String validateCode(String str) {
        String alert;
        if (str.equals("customer")) {
            regex = "(CUS)[0-9]{3}";
            alert = "Mã bắt đầu bằng CUS kèm 3 số ngẫu nhiên!";
        } else {
            regex = "(EMP)[0-9]{3}";
            alert = "Mã bắt đầu bằng EMP kèm 3 số ngẫu nhiên!";
        }
        while (true) {
            try {
                System.out.printf("Nhập vào mã %s: ", str);
                String code = SCANNER.nextLine();
                if (!(code.matches(regex))) {
                    throw new CodeException(alert);
                }
                return code;
            } catch (CodeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateName(String str) {
        regex = "([A-Z][a-z]+ )+([A-Z][a-z]+)$";
        while (true) {
            try {
                System.out.printf("Nhập vào tên %s: ", str);
                String name = SCANNER.nextLine();
                if (!(name.matches(regex))) {
                    throw new NameException("Tên không hợp lệ!");
                }
                return name;
            } catch (NameException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Date validateBirthDate(String str) {
        regex = "^(\\d{2}|\\d)/(\\d{2}|\\d)/\\d{4}$";
        while (true) {
            try {
                System.out.printf("Nhập vào ngày sinh %s(ngày/tháng/năm): ", str);
                String dateString = SCANNER.nextLine();
                if (!(dateString.matches(regex))) {
                    throw new BirthDateException("Không đúng định dạng");
                }
                String[] dateParts = dateString.split("/");
                return new Date(Integer.parseInt(dateParts[2]) - 1900, (Integer.parseInt(dateParts[1]) - 1), Integer.parseInt(dateParts[0]));
            } catch (BirthDateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Boolean validateGender(String str) {
        while (true) {
            try {
                System.out.printf("Nhập vào giới tính %s(Nam, Nữ, Giới tính thứ 3): ", str);
                String genderToString = SCANNER.nextLine();
                if (genderToString.equals("Nam")) {
                    return true;
                } else if (genderToString.equals("Nữ")) {
                    return false;
                } else if (genderToString.equals("Giới tính thứ 3")) {
                    return null;
                } else {
                    throw new GenderException("Giới tính không hợp lệ!");
                }
            } catch (GenderException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateIdentityCard(String str) {
        regex = "[0-9]{12}";
        while (true) {
            try {
                System.out.printf("Nhập vào chứng minh nhân dân của %s: ", str);
                String idCard = SCANNER.nextLine();
                if (!(idCard.matches(regex))) {
                    throw new IdentityCardException("Chứng minh nhân dân không hợp lệ!");
                }
                return idCard;
            } catch (IdentityCardException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validatePhoneNumber(String str) {
        regex = "0[0-9]{8}";
        while (true) {
            try {
                System.out.printf("Nhập vào số điện thoại của %s:", str);
                String phoneNumber = SCANNER.nextLine();
                if (!(phoneNumber.matches(regex))) {
                    throw new PhoneNumberException("Số điện thoại không hợp lệ!");
                }
                return phoneNumber;
            } catch (PhoneNumberException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateEmail(String str) {
        regex = "^[\\w_]+@(\\w)+.(\\w)+$";
        while (true) {
            try {
                System.out.printf("Nhập vào email của %s: ", str);
                String email = SCANNER.nextLine();
                if (!(email.matches(regex))) {
                    throw new EmailException("Email không hợp lệ!");
                }
                return email;
            } catch (EmailException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
