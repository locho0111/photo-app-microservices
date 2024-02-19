package com.rick.photoappapiuserservice.service;

import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import com.rick.photoappapiuserservice.dto.UserDto;
import com.rick.photoappapiuserservice.entity.UserEntity;
import com.rick.photoappapiuserservice.repository.UserRepository;

@Service
public class UsersServiceImpl implements UsersService {
    private UserRepository userRepository;
    private ModelMapper mapper;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersServiceImpl(UserRepository userRepository, ModelMapper mapper,
            BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        // userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        userDetails.setEncryptedPassword(userDetails.getPassword());
        UserEntity userEntity = mapper.map(userDetails, UserEntity.class);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return mapper.map(savedUserEntity, UserDto.class);
    }

}
