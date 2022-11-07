package com.example.userdata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.userdata.entity.UserData;
import com.example.userdata.resttemplate.UserDataService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;



@RestController
@RequestMapping("/UserDetails")
public class UserDataController {
	

	@Autowired
	UserDataService restClient;
	
	@GetMapping("/countData")
	public Map<String,Integer> allUserData() throws JsonMappingException, JsonProcessingException{
		return restClient.printCount();
	}
	
	@PutMapping("/update")
	public List<UserData> updatedata(@RequestBody UserData feedDetails) {
		return restClient.updateDetails(feedDetails);
	}

}
