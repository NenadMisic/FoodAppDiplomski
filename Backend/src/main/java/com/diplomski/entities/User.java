package com.diplomski.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="korisnici")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id;

	@Column(name="email")
	private String email;
    
	@Column(name="password")
    private String password;
    
	@Column(name="username")
    private String username;
    
	@Column(name="is_admin")
    private Integer isAdmin;
	
	public User(Integer id, String email, String password, String username, Integer isAdmin) {
		this.id = id;
		this.email = email;
		this.password = password;
		this.username = username;
		if(isAdmin != null) {
			this.isAdmin = isAdmin;
		} else {
			this.isAdmin = 0;
		}
	}
	
	public User() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Integer getIsAdmin() {
		return isAdmin;
	}
	
	public void setIsAdmin(Integer isAdmin) {
		this.isAdmin = isAdmin;
	}
	
	@Override
	public String toString() {
		return "UserDAO: " + this.email + ", " + this.password +", " + this.username + ", " + this.isAdmin;
	}

}
