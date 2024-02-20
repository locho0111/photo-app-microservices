package com.rick.photoappapiuserservice.service;

import com.rick.photoappapiuserservice.dto.UserDto;

public interface UsersService {
    UserDto createUser(UserDto UserDto);

    UserDto getUser(Long id);

    UserDto getUserByUserId(String userId);
}
