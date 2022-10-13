package bank_menu.service;

import bank_menu._enum.BankEnum;
import bank_menu.model.BankAccount;
import bank_menu.model.PayAccount;
import bank_menu.model.SaveAccount;
import bank_menu.utils.read_write_utils.ReadFileUtils;
import bank_menu.utils.read_write_utils.WriteFileUtils;
import bank_menu.utils.validate.BankAccountValidate;
import bank_menu.utils.validate.PayAccountValidate;
import bank_menu.utils.validate.SaveAccountValidate;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

import static bank_menu._enum.BankEnum.PAYACCOUNT;
import static bank_menu._enum.BankEnum.SAVEACCOUNT;

public class BankAccountServiceImpl implements BankAccountService {
    private final Scanner SCANNER = new Scanner(System.in);

    private BankAccountValidate bankAccountValidate = new BankAccountValidate();
    private SaveAccountValidate saveAccountValidate = new SaveAccountValidate();
    private PayAccountValidate payAccountValidate = new PayAccountValidate();

    private ArrayList<BankAccount> bankAccountList = new ArrayList<>();

    private final String PATH = "src/bank_menu/data/bank_accounts.csv";

    @Override
    public void addAccount(BankEnum bankEnum) {
        ReadFileUtils.ReadFileUtils(bankAccountList, PATH);
        if (bankEnum == PAYACCOUNT) {
            PayAccount account = addPayAccountInformation();
            if (bankAccountList.size() == 0) {
                account.setId(0);
            } else {
                account.setId(bankAccountList.get(bankAccountList.size() - 1).getId() + 1);
            }
            account.setId(bankAccountList.get(bankAccountList.size() - 1).getId() + 1);
            bankAccountList.add(account);
        }
        if (bankEnum == SAVEACCOUNT) {
            SaveAccount account = addSaveAccountInformation();
            if (bankAccountList.size() == 0) {
                account.setId(0);
            } else {
                account.setId(bankAccountList.get(bankAccountList.size() - 1).getId() + 1);
            }
            bankAccountList.add(account);
        }
        WriteFileUtils.WriteFileUtils(bankAccountList, PATH);
        System.out.println("Thêm mới thành công!");
    }

    private <E extends BankAccount> E addBankAccountInformation(E account) {
        account.setCodeAccount(bankAccountValidate.validateCodeAccount());
        account.setOwnerName(bankAccountValidate.validateOwnerName());
        account.setDateCreated(bankAccountValidate.validateDateCreate());
        return account;
    }

    private PayAccount addPayAccountInformation() {
        PayAccount account = new PayAccount();
        addBankAccountInformation(account);
        account.setCardCode(payAccountValidate.validateCardCode());
        account.setMoneyInAccount(payAccountValidate.validateMoneyInAccount());
        return account;
    }

    private SaveAccount addSaveAccountInformation() {
        SaveAccount account = new SaveAccount();
        addBankAccountInformation(account);
        account.setSaveMoney(saveAccountValidate.validateSaveMoney());
        account.setDateSaved(saveAccountValidate.validateDateSave());
        account.setBonus(saveAccountValidate.validateBonus());
        account.setLimitTime(saveAccountValidate.validateLimitTime());
        return account;
    }

    @Override
    public void deleteAccount() {
        ReadFileUtils.ReadFileUtils(bankAccountList, PATH);
        System.out.println("Nhập vào mã tài khoản: ");
        String code = SCANNER.nextLine();
        boolean flag = false;
        for (BankAccount account : bankAccountList) {
            if (account.getCodeAccount().equals(code)) {
                System.out.println("Bạn có muốn xoá tài khoản này?(Y: yes, N: no): ");
                String choice = SCANNER.nextLine();
                if (choice.equals("Y")) {
                    flag = true;
                    bankAccountList.remove(account);
                }
            }
        }
        WriteFileUtils.WriteFileUtils(bankAccountList, PATH);

        if (flag) {
            System.out.println("Xoá thành công!");
        } else {
            System.out.println("Xoá thất bại!");
        }
    }

    @Override
    public void display() {
        ReadFileUtils.ReadFileUtils(bankAccountList, PATH);

        for (BankAccount account : bankAccountList) {
            System.out.println(account);
        }
    }

    @Override
    public void search() {

        ReadFileUtils.ReadFileUtils(bankAccountList, PATH);

        while (true) {
            System.out.println("------------ TÌM KIẾM TÀI KHOẢN NGÂN HÀNG ------------\n" +
                    "\n" +
                    "Chọn chứ năng theo số (để tiếp tục):\n" +
                    "1.Mã tài khoản\n" +
                    "2.Tên chủ tài khoản\n" +
                    "3.Thoát");
            String choice = SCANNER.nextLine();
            switch (choice) {
                case "1":
                    searchByCode();
                case "2":
                    searchByOwerName();
                case "3":
                    System.out.println("Thoát tìm kiếm");
                    return;
                default:
                    System.out.println("Không có lựa chọn này. Vui lòng nhập lại!");
            }
        }
    }

    private void searchByCode() {
        System.out.println("Nhập vào mã tài khoản: ");
        String code = SCANNER.nextLine();
        boolean flag = false;
        for (BankAccount account : bankAccountList) {
            if (account.getCodeAccount().equals(code)) {
                flag = true;
                System.out.println(account);
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy tài khoản có mã " + code);
        }
    }

    private void searchByOwerName() {
        System.out.println("Nhập tên chủ tài khoản: ");
        String name = SCANNER.nextLine();
        boolean flag = false;
        for (BankAccount account : bankAccountList) {
            if (account.getCodeAccount().contains(name)) {
                flag = true;
                System.out.println(account);
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy tài khoản có chủ tài khoản tên: " + name);
        }
    }
}
