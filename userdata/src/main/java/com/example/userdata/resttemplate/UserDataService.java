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
	
RestTemplate  restTemplate = new RestTemplate();
	
	@Autowired
	UserDataTask serviceClass;
	
	List<UserData>  userDetails;
	
	@Value ("${JsonFeed:http://localhost:}")
	String FeedLink;
	
	public List<UserData> updateDetails(UserData feedDetails) {
	      
	       
        UserData[] user = restTemplate.getForObject(FeedLink, UserData[].class);
        List<UserData> userDetails;
       userDetails = new ArrayList<>(Arrays.asList(user));
       return serviceClass.printUpdatedData(feedDetails,userDetails);

}
	

	public Map<String, Integer> printCount(){
		if(Optional.ofNullable(userDetails).isPresent()) {
			return serviceClass.printCount(userDetails);
		}
		UserData[] user = restTemplate.getForObject(FeedLink, UserData[].class);
		userDetails = new ArrayList<>(Arrays.asList(user));
		return serviceClass.printCount(userDetails);
		}

}
