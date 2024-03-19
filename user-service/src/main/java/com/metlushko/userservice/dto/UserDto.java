package com.metlushko.userservice.dto;

import lombok.*;

@Setter
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String username;

    private String password;

    private String email;


}
