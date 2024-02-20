package com.rick.photoappapiuserservice.service;

import java.util.List;
import java.util.UUID;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.rick.photoappapiuserservice.dto.AlbumResponseModel;
import com.rick.photoappapiuserservice.dto.UserDto;
import com.rick.photoappapiuserservice.entity.UserEntity;
import com.rick.photoappapiuserservice.feign.AlbumServiceClient;
import com.rick.photoappapiuserservice.repository.UserRepository;
import feign.FeignException;

@Service
public class UsersServiceImpl implements UsersService {
    private UserRepository userRepository;
    private ModelMapper mapper;
    private PasswordEncoder bCryptPasswordEncoder;
    private AlbumServiceClient albumServiceClient;
    private Environment environment;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public UsersServiceImpl(UserRepository userRepository, ModelMapper mapper,
            PasswordEncoder bCryptPasswordEncoder, AlbumServiceClient albumServiceClient,
            Environment environment) {
        this.userRepository = userRepository;
        this.mapper = mapper;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.albumServiceClient = albumServiceClient;
        this.environment = environment;
    }



    @Override
    public UserDto createUser(UserDto userDetails) {
        userDetails.setUserId(UUID.randomUUID().toString());
        userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
        // userDetails.setEncryptedPassword(userDetails.getPassword());
        UserEntity userEntity = mapper.map(userDetails, UserEntity.class);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        return mapper.map(savedUserEntity, UserDto.class);
    }



    @Override
    public UserDto getUser(Long id) {
        UserEntity userEntity = userRepository.findById(id).get();
        return mapper.map(userEntity, UserDto.class);
    }

    @Override
    public UserDto getUserByUserId(String userId) {
        UserEntity userEntity = userRepository.findByUserId(userId).get();
        UserDto user = mapper.map(userEntity, UserDto.class);

        // String albumsUrl = String.format(environment.getProperty("albums.url"), userId);



        List<AlbumResponseModel> albumsList = null;
        try {
            albumsList = albumServiceClient.getAlbums(userId);
        } catch (FeignException e) {
            logger.error(e.getLocalizedMessage());
        }

        user.setAlbums(albumsList);
        return user;
    }
}
