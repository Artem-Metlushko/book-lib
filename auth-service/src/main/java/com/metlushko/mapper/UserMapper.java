package com.metlushko.mapper;


import com.metlushko.dto.SignUpDto;
import com.metlushko.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User toUser(SignUpDto signUpDto ){

        return User.builder()
                .username(signUpDto.getUsername())
                .email(signUpDto.getEmail())
                .password(signUpDto.getPassword())
                .build();
    }
}
