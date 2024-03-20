package com.metlushko.mail.dto;

import lombok.*;


@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto  {

    private String username;

    private String password;

    private String email;
}
