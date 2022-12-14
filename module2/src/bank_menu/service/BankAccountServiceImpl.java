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
        System.out.println("Th??m m???i th??nh c??ng!");
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
        System.out.println("Nh???p v??o m?? t??i kho???n: ");
        String code = SCANNER.nextLine();
        boolean flag = false;
        for (BankAccount account : bankAccountList) {
            if (account.getCodeAccount().equals(code)) {
                System.out.println("B???n c?? mu???n xo?? t??i kho???n n??y?(Y: yes, N: no): ");
                String choice = SCANNER.nextLine();
                if (choice.equals("Y")) {
                    flag = true;
                    bankAccountList.remove(account);
                }
            }
        }
        WriteFileUtils.WriteFileUtils(bankAccountList, PATH);

        if (flag) {
            System.out.println("Xo?? th??nh c??ng!");
        } else {
            System.out.println("Xo?? th???t b???i!");
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
            System.out.println("------------ T??M KI???M T??I KHO???N NG??N H??NG ------------\n" +
                    "\n" +
                    "Ch???n ch??? n??ng theo s??? (????? ti???p t???c):\n" +
                    "1.M?? t??i kho???n\n" +
                    "2.T??n ch??? t??i kho???n\n" +
                    "3.Tho??t");
            String choice = SCANNER.nextLine();
            switch (choice) {
                case "1":
                    searchByCode();
                case "2":
                    searchByOwerName();
                case "3":
                    System.out.println("Tho??t t??m ki???m");
                    return;
                default:
                    System.out.println("Kh??ng c?? l???a ch???n n??y. Vui l??ng nh???p l???i!");
            }
        }
    }

    private void searchByCode() {
        System.out.println("Nh???p v??o m?? t??i kho???n: ");
        String code = SCANNER.nextLine();
        boolean flag = false;
        for (BankAccount account : bankAccountList) {
            if (account.getCodeAccount().equals(code)) {
                flag = true;
                System.out.println(account);
            }
        }
        if (!flag) {
            System.out.println("Kh??ng t??m th???y t??i kho???n c?? m?? " + code);
        }
    }

    private void searchByOwerName() {
        System.out.println("Nh???p t??n ch??? t??i kho???n: ");
        String name = SCANNER.nextLine();
        boolean flag = false;
        for (BankAccount account : bankAccountList) {
            if (account.getCodeAccount().contains(name)) {
                flag = true;
                System.out.println(account);
            }
        }
        if (!flag) {
            System.out.println("Kh??ng t??m th???y t??i kho???n c?? ch??? t??i kho???n t??n: " + name);
        }
    }
}
