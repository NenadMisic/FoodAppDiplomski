package com.diplomski.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diplomski.model.UserModel;
import com.diplomski.services.AuthService;

@RestController
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@GetMapping(path="/getUser")
	public UserModel getUserByUsername(@RequestParam(value = "username") String username) {
	
		UserModel um = authService.getUserByUsername(username);
		System.out.println(um.toString());
		return um;
	}

}
