package com.diplomski.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.model.UserModel;
import com.diplomski.repositories.UserRepository;
import com.diplomski.entities.User;

@Service
public class AuthService {
	
	@Autowired
	private UserRepository userRepository;
	
	public UserModel getUserByUsername(String username) {
		
		User user = userRepository.findOneByUsername(username);

		if(user != null) {
			UserModel userModel = new UserModel(user.getEmail(), user.getUsername(), user.getIsAdmin());
			System.out.println(user.toString());
			System.out.println(userModel.toString());
			return userModel;
		} else {
			System.out.println("No requested user");
			return null;
		}
		
	}
	
	public UserModel getUserByEmail(String email) throws Exception {
		
		User user = userRepository.findOneByEmail(email);
		
		if(user != null) {
			UserModel userModel = new UserModel(user.getEmail(), user.getUsername(), user.getIsAdmin());
			System.out.println(user.toString());
			System.out.println(userModel.toString());
			return userModel;
		} else {
			System.out.println("No requested user");
			throw new Exception("No user found");
		}
		
	}
	
	public UserModel loginUser(String email, String password) throws Exception {
		User user = userRepository.findOneByEmail(email);
		if (user != null) {
			try {
				if (user.getPassword().equals(password)) {
					UserModel userModel = new UserModel(user.getEmail(), user.getUsername(), user.getIsAdmin());
					return userModel;
				} else {
					throw new Exception("Wrong password");
				}
			} catch(Exception e) {
				throw new Exception(e);
			}
		} else {
			throw new Exception("User not found!");
		}
	}
	
	public UserModel registerUser(String email, String username, String password) throws Exception {
		try {
			userRepository.save(new User(email, username, password, 0));
		} catch(Exception e) {
			String exception = e.getMessage();
			if(exception.contains("email")) {
				throw new Exception("This email is already used");
			}
			if(exception.contains("username")) {
				throw new Exception("This username is already used");
			}
			else {
				throw new Exception(e);
			}
		}
		User user1 = userRepository.findOneByEmail(email);
		UserModel userModel = new UserModel(user1.getEmail(), user1.getUsername(), user1.getIsAdmin());
		return userModel; 
	}
	
}
