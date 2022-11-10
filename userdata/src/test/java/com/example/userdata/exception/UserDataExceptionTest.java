package com.example.userdata.exception;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.userdata.entity.UserData;
import com.example.userdata.resttemplate.UserDataService;
import com.example.userdata.service.UserDataTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@MockitoSettings(strictness = Strictness.LENIENT)

public class UserDataExceptionTest {

	
	ObjectMapper object = new ObjectMapper();
	
	@InjectMocks
	private UserDataTask userDataTask;
	
	@InjectMocks
	UserDataException exception;
	
	
	
	@InjectMocks
	UserDataService restClient;
	
	@Mock
	List<UserData> userDetails;
	UserData[] user;
	
	@Mock
	Exception e;
	
	@Test
	public void testUpdatedData() throws JsonMappingException, JsonProcessingException {

		String reqBody = "{\"userId\":1,\"title\":\"1800Flowers\",\"body\":\"Likitha\"}";
		UserData feedDetails = object.readValue(reqBody, UserData.class);
		UserData[] user = new UserData[1];
		user[0] = new UserData(4,35,"title","body");
		List<UserData> userDetails = Arrays.asList(user);
		assertThrows(RuntimeException.class,
				() -> 
					userDataTask.printUpdatedData(feedDetails,userDetails),"Changes Not made as UserId is not found");
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		assertEquals(responseEntity,exception.handleRuntimeException(e));
		}
	}


