package com.example.service.impl;

import com.example.model.MailForm;
import com.example.repository.IMailRepository;
import com.example.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailService implements IMailService {
    @Autowired
    private IMailRepository mailRepository;

    @Override
    public List<MailForm> getAvailable() {
        return mailRepository.getAvailable();
    }

    @Override
    public boolean addMailFrom(MailForm mailForm) {
        return mailRepository.addMailFrom(mailForm);
    }

    @Override
    public boolean editMailFrom(MailForm mailForm) {
        return mailRepository.editMailFrom(mailForm);
    }

    @Override
    public boolean removeMailFrom(Integer mailFormId) {
        return mailRepository.removeMailFrom(mailFormId);
    }

    @Override
    public MailForm findById(Integer mailFormId) {
        return getAvailable().get(mailFormId);
    }
}
