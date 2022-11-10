package com.example.userdata.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	
	
	
	@GetMapping
	public ResponseEntity<Map<String,Integer>> allUserData() throws JsonMappingException, JsonProcessingException{
		return new ResponseEntity<>(restClient.printCount(),HttpStatus.OK);
	}
	
	@PutMapping
	public ResponseEntity<List<UserData>> updatedata(@RequestBody UserData feedDetails)throws Exception {
		return new ResponseEntity<List<UserData>>(restClient.updateDetails(feedDetails),HttpStatus.CREATED);
	}

}
