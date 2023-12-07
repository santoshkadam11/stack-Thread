package com.net.stackthread.service;

import com.net.stackthread.dto.UserDto;

public interface UserService {

    void createUser(UserDto userDto);

    boolean login(UserDto userDto);
}
