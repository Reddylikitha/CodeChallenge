package com.example.userdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.userdata.entity.UserData;



@Service
public class UserDataTask {
	boolean update = false;
	
	 

	   public List<UserData> updateData(UserData feedDetails,List<UserData> userDetails) {
	                        update = false;
	                    userDetails.stream().forEach(i -> {
	                        if (i.getUserId() == feedDetails.getUserId()) {
	                            i.setBody(feedDetails.getBody());
	                            i.setTitle(feedDetails.getTitle());
	                            update = true;
	                        }
	                    });
	                    if (update == true) {
	                        return userDetails;
	                    } 
	                    else {
	                        throw new RuntimeException("No changes made as userId not found!");
	                        }    
	            }
	                    
	          public  List<UserData> printUpdatedData(UserData feedDetails, List<UserData> userDetails) {
	                		
	        	
	        	if (feedDetails.getUserId() == 0) {
	        		throw new RuntimeException(" UserId is Null");
	        		
	        	}
	        	else {
	        		return updateData(feedDetails,userDetails);
	        	}
	                	}
	                
	   
	 
	          public Map<String, Integer> printCount(List<UserData> userDetails){
	        	  
	        	  return countData(userDetails);
	          }
	          
	          int count = 0;
	          public Map<String, Integer> countData(List<UserData> userDetails){
	        	  
	        	
	        	  Map<Integer, List<UserData>> map = userDetails
	        			  .stream()
	        			  .collect(Collectors.groupingBy(UserData::getUserId));
	        	  if(map == null) {
	        		  throw new RuntimeException("Data Not Found");
	        	  }
	        	  Map<String, Integer> mapUser = new HashMap<>();
	        	  map.forEach((k,v) -> {
	        		 
	        		  count ++;
	        	  });
	        	  mapUser.put("Unique Userid's:", count);
	        	  return mapUser;
	          }
	}

	




	        
	    



