package com.metlushko.userservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

@Setter
@Data
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private String username;

    private String password;

    private String email;


}
