package com.rick.photoappapiuserservice.security;

import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.rick.photoappapiuserservice.entity.UserEntity;
import com.rick.photoappapiuserservice.repository.UserRepository;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user =
                userRepository.findByEmail(email).orElseThrow(
                        () -> new UsernameNotFoundException(
                                "User not found with email: " + email));
        System.out.println("***********************: " + user);
        Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();

        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getEncryptedPassword(), authorities);
    }
}
