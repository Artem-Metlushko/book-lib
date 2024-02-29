package com.metlushko.userservice.mapper;

import com.metlushko.userservice.dto.UserDto;
import com.metlushko.userservice.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public UserDto toUser(User user){
        UserDto userDto = new UserDto();

        userDto.setPassword(user.getPassword());
        userDto.setEmail(user.getEmail());
        userDto.setUsername(user.getUsername());
        return userDto;
    }
}
