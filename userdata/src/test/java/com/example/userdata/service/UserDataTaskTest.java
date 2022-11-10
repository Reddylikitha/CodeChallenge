package com.example.userdata.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;


import com.example.userdata.entity.UserData;
import com.example.userdata.resttemplate.UserDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
public class UserDataTaskTest {
	
	@InjectMocks
	UserDataTask userDataTask;
	
	
	ObjectMapper object = new ObjectMapper();
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	UserDataService restClient;
	
	
	
	//UserData[] user;
	
	@Test
	public void updatedDataTest() throws JsonMappingException, JsonProcessingException{
		
		String reqBody = "{\"userId\":4,\"title\":\"1800Flowers\",\"body\":\"Likitha\"}";
		String resBody = "[{\"userId\":4,\"id\":35,\"title\":\"1800Flowers\",\"body\":\"Likitha\"}]";
		
		UserData feedDetails = object.readValue(reqBody, UserData.class);
		UserData[] user = new UserData[1];
		user[0] = new UserData(4,35,"title","body");
		
		List<UserData> userDetails = Arrays.asList(user);
		
         List<String> expected = Arrays.asList(resBody);
         
       
         List<UserData> userDetails2 =   UserDataTask.updateData(feedDetails,userDetails);  
		
		String original = object.writeValueAsString(userDetails2);
		
		assertEquals(expected,Arrays.asList(original));
	}

	@Test
	public void countTest() throws JsonMappingException, JsonProcessingException{
		
		UserData[] user = new UserData[1];
		user[0] = new UserData(1,2," title"," body");
		List<UserData> userDetails1 = new ArrayList<>(Arrays.asList(user));
		
		assertNotNull( UserDataTask.countData(userDetails1));
		
		
	}
}
