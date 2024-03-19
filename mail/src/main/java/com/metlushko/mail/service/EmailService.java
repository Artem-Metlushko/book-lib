package com.metlushko.mail.service;

import com.metlushko.mail.repository.MailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailService {
    public final MailRepository mailRepository;

//    public void sendSimpleMessage(UserDto input) {
//
//        Mail newMail = new Mail();
//        newMail.setSend(input.getUsername());
//        newMail.setSubject(input.getUsername()+"_successful_registration");
//        newMail.setText("Congratulations");
//
//        mailRepository.save(newMail);

//    }
}
