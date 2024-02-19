package com.rick.photoappapiuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserResponseDto {
    private String firstName;
    private String lastName;
    private String email;
    private String userId;
}
