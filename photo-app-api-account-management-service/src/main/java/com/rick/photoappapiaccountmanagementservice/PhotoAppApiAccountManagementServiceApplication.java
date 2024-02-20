package com.rick.photoappapiaccountmanagementservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PhotoAppApiAccountManagementServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PhotoAppApiAccountManagementServiceApplication.class, args);
	}

}
