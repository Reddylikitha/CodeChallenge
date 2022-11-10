package com.example.userdata.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.userdata.entity.UserData;



@Service
public class UserDataTask {
	  static boolean update = false;
	
	  private static final Logger logger = LoggerFactory.getLogger(UserDataTask.class);
	  

	   public static  List<UserData> updateData(UserData feedDetails,List<UserData> userDetails) {
	                        update = false;
	                    userDetails.stream().forEach(i -> {
	                        if (i.getUserId() == feedDetails.getUserId()) {
	                            i.setBody(feedDetails.getBody());
	                            i.setTitle(feedDetails.getTitle());
	                            update = true;
	                           
	                        }
	                    });
	                    if (update == true) {
	                    	logger.info("Details are updated");
	                        return userDetails;
	                    } 
	                    else {
	                    	logger.error("UserId not Found:" +feedDetails.getUserId());
	                        throw new RuntimeException("No changes made as userId not found!");
	                        }    
	            }
	                    
	          public   List<UserData> printUpdatedData(UserData feedDetails, List<UserData> userDetails) {
	                		
	        	
	        	if (feedDetails.getUserId() == 0) {
	        		throw new RuntimeException(" UserId is Null");
	        		
	        	}
	        	else {
	        		return updateData(feedDetails,userDetails);
	        	}
	                	}
	                
	   
	 
	          public static Map<String, Integer> printCount(List<UserData> userDetails){
	        	  
	        	  return countData(userDetails);
	          }
	          
	          static int count  ;
	          public static Map<String, Integer> countData(List<UserData> userDetails){
	        	  
	        	  count = 0;
	        	
	        	  Map<Integer, List<UserData>> map = userDetails
	        			  .stream()
	        			  .collect(Collectors.groupingBy(UserData::getUserId));
	        	  if(map == null) {
	        		  throw new RuntimeException("Data Not Found");
	        	  }
	        	  else {
	        	  Map<String, Integer> mapUser = new HashMap<>();
	        	  map.forEach((k,v) -> {
	        		 
	        		  count ++;
	        	  });
	        	  mapUser.put("Unique Userid's:", count);
	        	  return mapUser;
	          }
	          }
	}

	




	        
	    



