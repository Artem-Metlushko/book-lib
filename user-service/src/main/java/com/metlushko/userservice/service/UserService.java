package com.metlushko.userservice.service;

import com.metlushko.userservice.dto.BookDto;
import com.metlushko.userservice.dto.ResponseDto;
import com.metlushko.userservice.dto.UserDto;
import com.metlushko.userservice.entity.User;
import com.metlushko.userservice.mapper.UserMapper;
import com.metlushko.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final ApiClient apiClient;
    private final UserRepository userRepository;

    private final UserMapper userMapper;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public ResponseDto getUser(Long id){
        ResponseDto responseDto = new ResponseDto();

        User user = userRepository.findById(id).orElseThrow();

        UserDto userDto = userMapper.toUser(user);

        BookDto bookDto = apiClient.getBookById(user.getId());

        responseDto.setUserDto(userDto);
        responseDto.setBookDto(bookDto);

        return responseDto;

    }



}
