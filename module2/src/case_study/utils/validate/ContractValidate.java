package case_study.utils.validate;

import case_study.utils.exception.contract_exception.ContractCodeException;
import case_study.utils.exception.contract_exception.ContractDepositException;
import case_study.utils.exception.contract_exception.ContractTotalPayment;

import java.util.Scanner;

public class ContractValidate {
    private final Scanner SCANNER = new Scanner(System.in);

    public String validateContractCode() {
        while (true) {
            try {
                System.out.println("Nhập vào mã hợp đồng: ");
                String contractCode = SCANNER.nextLine();

                if (contractCode.length() < 1) {
                    throw new ContractCodeException("Mã hợp đồng không hợp lệ!");
                }

                return contractCode;
            } catch (ContractCodeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer validateContractTotalPayment() {
        while (true) {
            try {
                System.out.println("Nhập vào tổng số tiền thanh toán: ");
                Integer totalPayment = Integer.parseInt(SCANNER.nextLine());

                if (totalPayment < 1) {
                    throw new ContractTotalPayment("Tổng số tiền thanh toán không hợp lệ");
                }

                return totalPayment;
            } catch (NumberFormatException | ContractTotalPayment e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Integer validateContractDeposit(Integer totalPayment) {
        while (true) {
            try {
                System.out.println("Nhâp vào số tiền cọc trước: ");
                Integer contractDeposit = Integer.parseInt(SCANNER.nextLine());

                if (contractDeposit < 1 || contractDeposit > totalPayment) {
                    throw new ContractDepositException("Tiền cọc không hợp lệ!");
                }
                return contractDeposit;
            } catch (ContractDepositException | NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public String validateBookingCode(String code) {
        return code;
    }

    public String validateCustomerCode(String code) {
        return code;
    }
}
