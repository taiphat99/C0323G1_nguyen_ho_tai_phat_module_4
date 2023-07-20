package com.example.emailbox.repository;

import com.example.emailbox.model.EmailBox;
import org.springframework.stereotype.Repository;

@Repository
public class EmailRepository implements IEmailRepository {
    private static final EmailBox EMAIL_BOX = new EmailBox("English", 15, true, "Danny");

    public EmailBox getEmailBox (){
        return EMAIL_BOX;
    }
    public void update(EmailBox emailBox) {
        EMAIL_BOX.setLanguage(emailBox.getLanguage());
        EMAIL_BOX.setPageSize(emailBox.getPageSize());
        EMAIL_BOX.setSpamFilter(emailBox.isSpamFilter());
        EMAIL_BOX.setSignature(emailBox.getSignature());
    }


}
