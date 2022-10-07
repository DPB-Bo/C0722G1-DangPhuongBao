package case_study.service.impl;

import case_study.model.booking.Booking;
import case_study.model.contract.Contract;
import case_study.service.ContactService;
import case_study.utils.file.ReadFileUtils;
import case_study.utils.file.WriteFileUtils;
import case_study.utils.validate.ContractValidate;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactServiceImpl implements ContactService {
    private final Scanner SCANNER = new Scanner(System.in);
    private BookingServiceImpl booking = new BookingServiceImpl();
    private ArrayList<Booking> bookingList = booking.getBookingList();
    private ArrayList<Contract> contracts = new ArrayList<>();
    private ContractValidate contractValidate = new ContractValidate();
    private final String PATH = "src/case_study/data/contract.csv";

    @Override
    public void add() {
        ReadFileUtils.readFileContract(PATH, contracts);
        ArrayList<String> availableBookingCode = availableBookingCode();
        if (availableBookingCode.size() > 0) {
            Contract contract = createContract(availableBookingCode);
            contracts.add(contract);
            System.out.println("Thêm mới thành công");
            WriteFileUtils.writeContractFile(PATH, contracts);
        } else {
            System.out.println("Hiện không có booking nào cần hợp đồng");
        }
    }

    private Contract createContract(ArrayList<String> availableBookingCode) {
        String contractCode = contractValidate.validateContractCode();

        String bookingCode = contractValidate.validateBookingCode(availableBookingCode.get(0));

        String customerCode = contractValidate.validateCustomerCode(getCustomerCode(bookingCode));

        Integer totalPayment = contractValidate.validateContractTotalPayment();

        Integer contractDeposit = contractValidate.validateContractDeposit(totalPayment);

        return new Contract(contractCode, bookingCode, customerCode, totalPayment, contractDeposit);
    }

    @Override
    public void display() {
        ReadFileUtils.readFileContract(PATH, contracts);
        for (Contract contract : contracts) {
            System.out.println(contract);
        }
    }

    private ArrayList<String> getBookingCodeHaveContract() {
        ArrayList<String> bookingCodeInContract = new ArrayList<>();
        if (contracts.size() != 0) {
            for (Contract contract : contracts) {
                bookingCodeInContract.add(contract.getBookingCode());
            }
        }
        return bookingCodeInContract;
    }

    private ArrayList<String> availableBookingCode() {
        ArrayList<String> bookingCodes = new ArrayList<>();
        for (Booking b : bookingList) {
            if (b.getBookingCode().contains("VL") || b.getBookingCode().contains("HO")) {
                bookingCodes.add(b.getBookingCode());
            }
        }
        ArrayList<String> bookingHaveContracts = getBookingCodeHaveContract();
        if (bookingHaveContracts.size() != 0) {
            bookingCodes.removeIf(bookingHaveContracts::contains);
        }
        return bookingCodes;
    }

    private String getCustomerCode(String bookingCode) {
        for (Booking b : bookingList) {
            if (b.getBookingCode().equals(bookingCode)) {
                return b.getCustomerCode();
            }
        }
        return "Không xác định";
    }

    private boolean editContract(Contract contract) {
        System.out.print("-------- Chỉnh sửa hợp đồng --------\n" +
                "1. Tiền cọc\n" +
                "2. Tổng tiền thanh toán\n" +
                "Nhập vào lựa chọn ở đây: ");

        String choice = SCANNER.nextLine();
        switch (choice) {
            case "1":
                Integer contractDeposit = contractValidate.validateContractDeposit(contract.getContractTotalPayment());
                if (checkAccept()) {
                    contracts.get(contracts.indexOf(contract)).setContractDeposit(contractDeposit);
                    WriteFileUtils.writeContractFile(PATH, contracts);
                    System.out.println("Chỉnh sửa thành công");
                    return true;
                }
                break;
            case "2":
                Integer contractTotalPayment = contractValidate.validateContractTotalPayment();
                if (checkAccept()) {
                    contracts.get(contracts.indexOf(contract)).setContractTotalPayment(contractTotalPayment);
                    WriteFileUtils.writeContractFile(PATH, contracts);
                    System.out.println("Chỉnh sửa thành công");
                    return true;
                }
                break;
            default:
                System.out.println("\nKhông có lựa chọn này!");
                return false;
        }
        return false;
    }

    private Contract getContractWithCode(String contractCode) {
        for (Contract contract : contracts) {
            if (contract.getContractCode().equals(contractCode)) {
                return contract;
            }
        }
        return null;
    }

    private boolean checkAccept() {
        System.out.print("Xác nhận chỉnh sửa (Bất cứ gì ngoại trừ 'Y' là huỷ bỏ) :");
        return SCANNER.nextLine().equals("Y");
    }

    @Override
    public void edit() {
        System.out.println("Nhập vào mã hợp đồng cần sửa: ");
        Contract contract = getContractWithCode(SCANNER.nextLine());
        boolean flag = true;
        if (contract != null) {
            flag = editContract(contract);
        } else {
            System.out.println("Mã hợp đồng không tồn tại");
        }
        if (!flag) {
            System.out.println("Chỉnh sửa thất bại");
        }
    }
}
