package com.rick.photoappapiuserservice.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.rick.photoappapiuserservice.dto.CreateUserRequestDto;
import com.rick.photoappapiuserservice.dto.CreateUserResponseDto;
import com.rick.photoappapiuserservice.dto.UserDto;
import com.rick.photoappapiuserservice.service.UsersService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private Environment env;

    private UsersService usersService;
    private ModelMapper modelMapper;


    public UserController(UsersService usersService, ModelMapper modelMapper) {
        this.usersService = usersService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/status/check")
    public String status() {
        return "Users Working on port " + env.getProperty("local.server.port");
    }

    @PostMapping
    public ResponseEntity<CreateUserResponseDto> createUser(
            @Valid @RequestBody CreateUserRequestDto userRequestDto) {
        UserDto userDto = modelMapper.map(userRequestDto, UserDto.class);
        UserDto savedUserDto = usersService.createUser(userDto);
        CreateUserResponseDto savedUserResponseDto =
                modelMapper.map(savedUserDto, CreateUserResponseDto.class);
        return new ResponseEntity<CreateUserResponseDto>(savedUserResponseDto, HttpStatus.CREATED);
    }
}
