package com.example.emailbox.service;

import com.example.emailbox.model.EmailBox;

public interface IEmailService {
    EmailBox getEmailBox();
    void update(EmailBox emailBox);
}
