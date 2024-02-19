package com.rick.photoappapiuserservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.rick.photoappapiuserservice.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
