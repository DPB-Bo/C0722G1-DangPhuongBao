package com.example.repository;

import com.example.model.MailForm;

import java.util.List;

public interface IMailRepository {
    List<MailForm> getAvailable();

    boolean addMailFrom(MailForm mailForm);

    boolean editMailFrom(MailForm mailForm);

    boolean removeMailFrom(Integer mailFormId);
}
