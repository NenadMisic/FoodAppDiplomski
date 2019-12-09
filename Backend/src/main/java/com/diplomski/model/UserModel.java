package com.diplomski.model;

public class UserModel {
	
	private String email;
	private String username;
	private Integer admin;
	
	public UserModel(String email, String username, Integer admin) {
		this.email = email;
		this.username = username;
		this.admin = admin;
	}
	public UserModel() {}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "UserModel: " + this.email + ", " + this.username + ", " + this.admin;
	}

}
