package bank_menu.utils.read_write_utils;

import bank_menu.model.BankAccount;
import bank_menu.model.PayAccount;
import bank_menu.model.SaveAccount;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ReadFileUtils {
    public static void ReadFileUtils(ArrayList<BankAccount> bankAccount, String path) {
        File file = new File(path);
        String line;
        String[] info;
        bankAccount.clear();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                info = line.split(",");
                if (info.length == 6) {
                    bankAccount.add(new PayAccount(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], Integer.parseInt(info[5])));
                } else {
                    bankAccount.add(new SaveAccount(Integer.parseInt(info[0]), info[1], info[2], info[3], Integer.parseInt(info[4]), info[5], Integer.parseInt(info[6]), Integer.parseInt(info[7])));
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Đường dẫn không hợp lệ! ");
        }
    }
}
