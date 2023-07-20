package com.example.emailbox.repository;

import com.example.emailbox.model.EmailBox;

public interface IEmailRepository {
    EmailBox getEmailBox();
    void update(EmailBox emailBox);

}
