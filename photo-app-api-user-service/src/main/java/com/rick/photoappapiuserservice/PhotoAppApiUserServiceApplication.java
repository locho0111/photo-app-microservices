package com.rick.photoappapiuserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import feign.Logger;

@SpringBootApplication(scanBasePackages = "com.rick")
@EnableDiscoveryClient
@EnableFeignClients(
		basePackageClasses = com.rick.photoappapiuserservice.feign.AlbumServiceClient.class)
public class PhotoAppApiUserServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiUserServiceApplication.class, args);
	}

	@Bean
	Logger.Level fiegnLoggerLevel() {
		return Logger.Level.FULL;
	}
}
