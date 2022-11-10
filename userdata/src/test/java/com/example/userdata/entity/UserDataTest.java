package com.example.userdata.entity;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;



public class UserDataTest {
	
	ObjectMapper obj = new ObjectMapper();
	
	@Test
	public void testSetter() throws JsonMappingException, JsonProcessingException{
		
		UserData userData = new UserData(1,2,"1800Flowers","1800Flowers");
		UserData expectedData = new UserData(4,35,"1800Flowers","1800Flowers");
		
		userData.setId(35);
		
		userData.setUserId(4);
		
		userData.setTitle("1800Flowers");
		
		userData.setBody("1800Flowers");
		
	
		String originalData = obj.writeValueAsString(userData);
		String expectedValue = obj.writeValueAsString(expectedData);
		
		assertEquals(expectedValue,originalData);
	}
	
	@Test
	public void testGetter() {
		
		UserData userData = new UserData(4,35,"1800Flowers","1800Flowers");
		
		
		Integer actualUserID = userData.getUserId();
		assertNotNull(actualUserID);
		
		
		Integer actualId = userData.getId();
		assertNotNull(actualId);
		
		
		String actualTitle = userData.getTitle();
		assertNotNull(actualTitle);
		
		
		String actualBody = userData.getBody();
		assertNotNull(actualBody);
	}
}
