package com.example.userdata.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.example.userdata.resttemplate.UserDataService;
import com.fasterxml.jackson.databind.ObjectMapper;

@AutoConfigureMockMvc
@WebMvcTest
public class UserDataControllerTest {
	
	@Autowired
	  MockMvc mockMvc;
	
	@MockBean
	 UserDataService restClient;
	
	ObjectMapper obj = new ObjectMapper();
	
	@Test
	public void testGetMapping() throws Exception{
		
		mockMvc.perform(get("/UserDetails").contentType(MediaType.APPLICATION_JSON))
		       .andExpect(status().isOk())
		       .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testPutMapping() throws Exception{
		String reqBody = "{\"userId\":4,\"title\":\"1800Flowers\",\"body\":\"1800Flowers\"}";
		mockMvc.perform(put("/UserDetails").content(reqBody).contentType(MediaType.APPLICATION_JSON))
		       .andExpect(status().isCreated())
		       .andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
		       
	}
	
	
	
}
