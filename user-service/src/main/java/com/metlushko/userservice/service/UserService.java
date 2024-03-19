package com.metlushko.userservice.service;

import com.metlushko.userservice.dto.BookDto;
import com.metlushko.userservice.dto.ResponseDto;
import com.metlushko.userservice.dto.UserDto;
import com.metlushko.userservice.entity.User;
import com.metlushko.userservice.mapper.UserMapper;
import com.metlushko.userservice.producer.ProducerService;
import com.metlushko.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

//    @Value("${spring.kafka.topic.userCreated}")
//    private String USER_CREATED_TOPIC;
    private final ApiClient apiClient;
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    private final ProducerService producerService;

    public User saveUser(User user) {
        User createdUser = userRepository.save(user);
        UserDto userDto = userMapper.toUser(createdUser);
//        kafkaProducerService.send(USER_CREATED_TOPIC, createdUser);
//        producerService.sendStringMessage(String.valueOf(createdUser));;
        producerService.sendJsonObject(userDto);

        return createdUser;
    }




    public ResponseDto getUser(Long id) throws Exception {
        ResponseDto responseDto = new ResponseDto();

        User user = userRepository.findById(id).orElseThrow();

        UserDto userDto = userMapper.toUser(user);

        BookDto bookDto = null;
        try {
            bookDto = apiClient.getBookById(user.getId());
        } catch (Exception e) {
            throw new Exception("Failed to fetch book from the API");
        }

        responseDto.setUserDto(userDto);
        responseDto.setBookDto(bookDto);

        return responseDto;

    }







}
