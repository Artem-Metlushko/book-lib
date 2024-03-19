package com.metlushko.userservice.producer;

import com.metlushko.userservice.dto.UserDto;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ProducerService {

    //    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);
//
//    private final KafkaTemplate<String, User> kafkaTemplate;
//
//    public void send(String topic, User payload) {
//        LOGGER.info("sending payload='{}' to topic='{}'", payload, topic);
//        kafkaTemplate.send(topic, payload);
//    }
    @Value("${spring.kafka.topic.userCreated}")
    private String topic;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);
    private final KafkaTemplate<String, UserDto> kafkaJSONTemplate;

    public void sendJsonObject(UserDto userDto)  {
        LOGGER.info("===>> sending payload='{}' to topic='{}'", userDto, topic);

        kafkaJSONTemplate.send(topic, userDto);
    }
}
