package com.example.userdata.resttemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.userdata.entity.UserData;
import com.example.userdata.service.UserDataTask;


@Service
public class UserDataService {
	
	@Autowired
 RestTemplate  restTemplate; 
	
	@Autowired
	UserDataTask serviceClass;
	
	List<UserData>  userDetails;
	
	@Value ("${JsonFeed:http://localhost:}")
	String FeedLink;
	
	public List<UserData> updateDetails(UserData feedDetails) {
	      
	       
        UserData[] user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserData[].class);
        List<UserData> userDetails;
       userDetails = new ArrayList<>(Arrays.asList(user));
       return serviceClass.printUpdatedData(feedDetails,userDetails);

}
	
	public Map<String, Integer> printCount(){
		UserData[] user = restTemplate.getForObject("http://jsonplaceholder.typicode.com/posts", UserData[].class);
		userDetails = new ArrayList<>(Arrays.asList(user));
		if(Optional.ofNullable(userDetails).isPresent()) {
			return serviceClass.printCount(userDetails);
		}
		
		return null;
		}

}
