package com.example.emailbox.service;

import com.example.emailbox.model.EmailBox;
import com.example.emailbox.repository.IEmailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements IEmailService{
    @Autowired
    private IEmailRepository emailRepository;

    @Override
    public EmailBox getEmailBox() {
        return emailRepository.getEmailBox();
    }

    @Override
    public void update(EmailBox emailBox) {
        emailRepository.update(emailBox);
    }
}
