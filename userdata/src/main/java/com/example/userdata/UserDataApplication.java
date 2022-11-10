package com.example.userdata;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.userdata.service.UserDataTask;

@SpringBootApplication

public class UserDataApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(UserDataTask.class);
	
	@Bean
	public RestTemplate getRestTemplate() {
	       return new RestTemplate();

	    }

	public static void main(String[] args) {
		logger.info("Before Starting application");
		SpringApplication.run(UserDataApplication.class, args);
	     logger.debug("Starting my application in debug with {} args", args.length);
	
	}

}
