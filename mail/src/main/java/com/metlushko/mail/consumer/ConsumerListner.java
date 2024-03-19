package com.metlushko.mail.consumer;


import com.metlushko.mail.entity.UserDto;
import com.metlushko.mail.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsumerListner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerListner.class);

    private final EmailService emailService;

    //    @KafkaListener(topics = "USER_CREATED_TOPIC", groupId = "mail-task", containerFactory = "kafkaListenerContainerFactory")
//    @KafkaListener(topics = "${spring.kafka.topic.userCreated}", groupId = "${spring.kafka.consumer.group-id}")
    @KafkaListener(topics = "USER_CREATED_TOPIC", groupId = "mail-task")
    public void receive(UserDto userDto) {
        LOGGER.info("received payload='{}'");
//        emailService.sendSimpleMessage(payload);

        System.out.println("Cosumed msg:"+userDto.toString());

    }


}
