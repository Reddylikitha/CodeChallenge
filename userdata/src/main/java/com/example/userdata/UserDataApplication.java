package com.example.userdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserDataApplication {
	
	@Bean
	public RestTemplate getRestTemplate() {
	       return new RestTemplate();

	    }

	public static void main(String[] args) {
		SpringApplication.run(UserDataApplication.class, args);
	}

}
