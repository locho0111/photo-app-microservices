package com.rick.photoappapiuserservice.feign;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.rick.photoappapiuserservice.dto.AlbumResponseModel;

@FeignClient(name = "album-service")
public interface AlbumServiceClient {

    @GetMapping("/users/{userId}/albums")
    public List<AlbumResponseModel> getAlbums(@PathVariable String userId);
}
