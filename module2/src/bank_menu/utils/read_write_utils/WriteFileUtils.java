package bank_menu.utils.read_write_utils;

import bank_menu.model.BankAccount;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WriteFileUtils {
    public static void WriteFileUtils(ArrayList<BankAccount> bankAccounts, String path) {
        File file = new File(path);
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (BankAccount account : bankAccounts) {
                writer.write(account.getInformation());
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Đường dẫn file không hợp lệ! ");
        }
    }
}
