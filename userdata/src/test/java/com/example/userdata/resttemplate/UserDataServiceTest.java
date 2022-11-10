package com.example.userdata.resttemplate;



import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.web.client.RestTemplate;

import com.example.userdata.entity.UserData;
import com.example.userdata.service.UserDataTask;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)

class UserDataServiceTest {
	
	@InjectMocks
	UserDataService restClient;
	
	@Mock
	private UserDataTask userDataTask;
	
	ObjectMapper object = new ObjectMapper();
	
	@Mock
	private RestTemplate restTemplate;
	
	
	@Mock
	List<UserData> userDetails;
	


	@Test
public void testUpdatedData() throws JsonMappingException, JsonProcessingException{
		
		UserData[] user = new UserData[1];
		user[0] = new UserData(4,35,"title","body");
		
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserData[].class))
		.thenReturn(user);
		
		String reqBody = "{\"userId\":4,\"title\":\"1800Flowers\",\"body\":\"Likitha\"}";
		
		UserData feedDetails = object.readValue(reqBody, UserData.class);
		
		
		assertNotNull(restClient.updateDetails(feedDetails));
	}
	
	@Test
	public void testCountData() throws JsonMappingException, JsonProcessingException{
		
		UserData[] user = new UserData[1];
		user[0] = new UserData(1,2," title"," body");
		
		Mockito.when(restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserData[].class))
		.thenReturn(user);
		
		List<UserData> userDetails1 = new ArrayList<>(Arrays.asList(user));
	
	
		assertNotNull(restClient.printCount());
		
	}

}
