package com.example.userdata.entity;



public class UserData {
	
	
	private int userId;
	private int id;
	private String title;
	private String body;
	
	public UserData(){
		
	}
	
	
	public UserData(int userId,int id,String title,String body) {
		
		this.setUserId(userId);
		this.setId(id);
		this.setTitle(title);
		this.setBody(body);
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}

}



