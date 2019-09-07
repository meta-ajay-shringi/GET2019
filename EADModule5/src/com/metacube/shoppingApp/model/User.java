package com.metacube.shoppingApp.model;

public class User extends BaseModel {

	private int userId;
	private int email;
	private int password;

	
	public User(int user_id, int email, int password) {
		super();
		this.userId = user_id;
		this.email = email;
		this.password = password;
	}

	public int getUserId() {
		return userId;
	}
	

	public void setUserId(int user_id) {
		this.userId = user_id;
	}

	public int getEmail() {
		return email;
	}

	public void setEmail(int email) {
		this.email = email;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

}
