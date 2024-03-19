//package com.metlushko.mail.controller;
//
//import com.metlushko.mail.dto.UserDto;
//import com.metlushko.mail.service.EmailService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.ResponseStatus;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//public class KafkaController {
//    private final EmailService emailService;
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("/send")
//    public String sendMessage(@RequestBody UserDto userDto) {
//        emailService.sendSimpleMessage(userDto);
//        return "Message sent";
//    }
//
//}
