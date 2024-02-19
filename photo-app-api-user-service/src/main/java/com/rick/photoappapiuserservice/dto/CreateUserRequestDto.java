package com.rick.photoappapiuserservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserRequestDto {

    @NotNull(message = "First name can not be null")
    @Size(min = 2, message = "First name must not be less than 2 characters")
    private String firstName;

    @NotNull(message = "Last name can not be null")
    @Size(min = 2, message = "Last name must not be less than 2 characters")
    private String lastName;

    @NotNull(message = "Password can not be null")
    @Size(min = 8, max = 16, message = "Password must be between 8-16 characters")
    private String password;

    @Email
    @NotNull(message = "Email can not be null")
    private String email;

}
