package com.opencejav.LibMaster.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class User {
	private String username;
	private String password;
	
	public User() {}

	public User(String username, String password) {
		this.username = username;
		this.password = password;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsername() {
		return this.username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword() {
		return this.password;
	}
}
