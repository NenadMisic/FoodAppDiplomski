package com.diplomski.model;

public class UserModel {
	
	private String email;
	private String username;
	private String password;
	private Integer admin;
	
	public UserModel(String email, String username, String password, Integer admin) {
		
		this.email = email;
		this.username = username;
		this.password = password;
		this.admin = admin;
		
	}
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAdmin() {
		return admin;
	}

	public void setAdmin(Integer admin) {
		this.admin = admin;
	}
	
	@Override
	public String toString() {
		return "UserModel: " + this.email + ", " + this.password +", " + this.username + ", " + this.admin;
	}

}
