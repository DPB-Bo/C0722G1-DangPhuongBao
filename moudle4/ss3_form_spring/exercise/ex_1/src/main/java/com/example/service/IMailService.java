package com.example.service;

import com.example.model.MailForm;

import java.util.List;

public interface IMailService {
    List<MailForm> getAvailable();

    boolean addMailFrom(MailForm mailForm);

    boolean editMailFrom(MailForm mailForm);

    boolean removeMailFrom(Integer mailFormId);

    MailForm findById(Integer mailFormId);
}
