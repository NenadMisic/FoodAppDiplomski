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
			UserModel userModel = new UserModel(user.getEmail(), user.getUsername(), user.getPassword(), user.getIsAdmin());
			System.out.println(user.toString());
			System.out.println(userModel.toString());
			return userModel;
		} else {
			System.out.println("No requested user");
			return null;
		}
		
	}

}
