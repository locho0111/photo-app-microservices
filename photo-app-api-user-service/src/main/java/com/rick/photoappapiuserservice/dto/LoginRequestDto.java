package com.rick.photoappapiuserservice.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequestDto {

    @NotNull(message = "Last name can not be null")
    @Size(min = 2, message = "Last name must not be less than 2 characters")
    private String email;

    @NotNull(message = "Password can not be null")
    @Size(min = 8, max = 16, message = "Password must be between 8-16 characters")
    private String password;
}
