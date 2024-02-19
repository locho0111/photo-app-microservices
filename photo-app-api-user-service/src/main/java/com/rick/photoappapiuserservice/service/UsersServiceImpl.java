package com.rick.photoappapiuserservice.service;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import com.rick.photoappapiuserservice.dto.UserDto;
import com.rick.photoappapiuserservice.entity.UserEntity;
import com.rick.photoappapiuserservice.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {
    private UserRepository userRepository;
    private ModelMapper mapper;


    public UsersServiceImpl(UserRepository userRepository, ModelMapper mapper) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }


    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        UserEntity userEntity = mapper.map(userDetails, UserEntity.class);
        userEntity.setEncryptedPassword("test encrypted password");
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return mapper.map(savedUserEntity, UserDto.class);
    }

}
