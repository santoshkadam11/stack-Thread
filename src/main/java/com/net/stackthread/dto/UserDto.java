package com.net.stackthread.dto;

import lombok.Data;

@Data
public class UserDto {
    private Long id;
    private String username;
    private String password;
    private String securityQuestion;
    private String securityAnswer;
}
