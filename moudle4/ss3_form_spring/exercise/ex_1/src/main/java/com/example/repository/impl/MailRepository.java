package com.example.repository.impl;

import com.example.model.MailForm;
import com.example.repository.IMailRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class MailRepository implements IMailRepository {
    private static List<MailForm> mailForms = new ArrayList<>();

    static {
        mailForms.add(new MailForm(0, "English", 5, true, "MAKE-A-MILK", 0));
        mailForms.add(new MailForm(1, "VietNam", 10, false, "BAO-VIP-PRO", 0));
        mailForms.add(new MailForm(2, "Japanese", 15, true, "ONI-CHAN", 0));
        mailForms.add(new MailForm(3, "Chinese", 20, false, "NI-HAO-MA", 0));
        mailForms.add(new MailForm(4, "English", 25, true, "I-LOVE-U", 0));
        mailForms.add(new MailForm(5, "VietNam", 5, true, "MAI-DINH", 0));
        mailForms.add(new MailForm(6, "Japanese", 10, true, "YAMEROOOOOOOO", 0));
    }

    @Override
    public List<MailForm> getAvailable() {
        List<MailForm> mailFormList = new ArrayList<>();
        for (MailForm mailForm : mailForms) {
            if (mailForm.getIsDelete() == 0) {
                mailFormList.add(mailForm);
            }
        }
        return mailFormList;
    }

    @Override
    public boolean addMailFrom(MailForm mailForm) {
        return mailForms.add(mailForm);
    }

    @Override
    public boolean editMailFrom(MailForm mailForm) {
        mailForms.set(mailForm.getId(), mailForm);
        return true;
    }

    @Override
    public boolean removeMailFrom(Integer mailFormId) {
        MailForm mailForm = mailForms.get(mailFormId);
        mailForm.setIsDelete(1);
        mailForms.set(mailFormId, mailForm);
        return true;
    }
}
