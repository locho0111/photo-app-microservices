package com.rick.photoappapiuserservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumResponseModel {
    private String albumId;
    private String userId;
    private String name;
    private String description;
}
