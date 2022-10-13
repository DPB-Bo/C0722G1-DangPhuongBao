package bank_menu.service;

import bank_menu._enum.BankEnum;

public interface BankAccountService {
    void addAccount(BankEnum bankEnum);



    void deleteAccount();

    void display();

    void search();
}
