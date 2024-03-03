package com.metlushko.userservice.controler;

import com.metlushko.userservice.dto.BookDto;
import com.metlushko.userservice.dto.ResponseDto;
import com.metlushko.userservice.dto.UserDto;
import com.metlushko.userservice.entity.User;
import com.metlushko.userservice.service.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        User savedUser = userService.saveUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    @CircuitBreaker(name = "getUserCB", fallbackMethod = "getUserFallback")
    public ResponseEntity<ResponseDto> getUser(@PathVariable("id") Long userId) throws Exception {
        ResponseDto responseDto = userService.getUser(userId);
        return ResponseEntity.ok(responseDto);
    }

    public ResponseEntity<ResponseDto> getUserFallback(Exception exception) {

        BookDto bookDto = BookDto.builder().description("Failed to fetch book from the API").build();

        ResponseDto responseDto = new ResponseDto();
        responseDto.setBookDto(bookDto);
        responseDto.setUserDto(new UserDto());

        return new ResponseEntity<>(responseDto, HttpStatus.NOT_FOUND);


    }




}
