/*
package com.metlushko.userservice.producer;

import com.metlushko.userservice.dto.UserDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {

    @Value("${spring.kafka.topic.userCreated}")
    private String topic;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);
    private final KafkaTemplate<String, UserDto> kafkaJSONTemplate;

    @Autowired
    public ProducerService(KafkaTemplate<String, UserDto> kafkaJSONTemplate) {
        this.kafkaJSONTemplate = kafkaJSONTemplate;
    }

    public void sendJsonObject(UserDto userDto) {
        LOGGER.info("===>> sending payload='{}' to topic='{}'", userDto, topic);

        kafkaJSONTemplate.send(topic, userDto);
    }
}
*/
