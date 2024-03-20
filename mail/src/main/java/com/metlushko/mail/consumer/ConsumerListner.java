package com.metlushko.mail.consumer;


import com.metlushko.mail.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ConsumerListner {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerListner.class);

    @KafkaListener(
            topics = "USER_CREATED_TOPIC",
            groupId = "mail-task",
            containerFactory = "jsonKafkaListenerContainerFactory")
    public void receive(UserDto userDto) {
        LOGGER.info("received payload='{}'", userDto.toString());

    }


}
