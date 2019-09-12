package com.diplomski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diplomski.model.UserModel;
import com.diplomski.model.LoginModel;
import com.diplomski.model.RegisterModel;
import com.diplomski.services.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping(path="/getUser/{username}")
	public UserModel getUserByUsername(@PathVariable(value = "username") String username) {
	
		UserModel um = authService.getUserByUsername(username);
		System.out.println(um.toString());
		return um;
	}
	
	@GetMapping(path="/auth/getUser/{email}")
	public UserModel getUserByEmail(@PathVariable(value = "email") String email) throws Exception {
		
		try {
			UserModel um = authService.getUserByEmail(email);
			System.out.println(um.toString());
			return um;
		}
		catch(Exception e) {
			throw new Exception(e);
		}
		
	}
	
	@PostMapping(path="/auth/login")
	public UserModel loginUser(@RequestBody LoginModel loginModel) throws Exception {
		UserModel um = authService.loginUser(loginModel.getEmail(), loginModel.getPassword());
		return um;
	}
	
	@PostMapping(path="auth/register")
	public UserModel registerUser(@RequestBody RegisterModel registerModel) throws Exception {
		
		UserModel um = authService.registerUser(registerModel.getEmail(), registerModel.getUsername(), registerModel.getPassword());
		
		return um;
		
	}
	
}
