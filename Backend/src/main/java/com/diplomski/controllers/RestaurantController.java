package com.diplomski.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diplomski.entities.Restaurant;
import com.diplomski.model.RestaurantModel;
import com.diplomski.services.RestaurantService;

@RestController
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@GetMapping(path="/restorani/all")
	public ArrayList<RestaurantModel> getAllRestaurants() {
	
		return restaurantService.getAllRestaurants(); 
	}
	
	@GetMapping(path="/restorani/{restaurantName}")
	public Restaurant getRestaurant( @PathVariable("restaurantName") String restaurantName) {
		String restaurantNameFix = restaurantName.replace("_", " ");
		return restaurantService.getRestaurantByName(restaurantNameFix);
	}
	
	@PostMapping(path="/restorani/add")
	public void addNewRestaurant (@RequestBody RestaurantModel restaurant) {
		restaurantService.addRestaurant(restaurant);
	}
	
	@PutMapping(path="/restorani/update/{restaurantName}")
	public void editRestaurant(@PathVariable("restaurantName") String restaurantName, @RequestBody RestaurantModel restaurant) {
		restaurantService.editRestaurant(restaurantName, restaurant);
	}
	
	@DeleteMapping(path="/restorani/delete/{restaurantName}")
	public void deleteRestoran(@PathVariable("restaurantName") String restaurantName) {
		restaurantService.deleteRestaurant(restaurantName);
	}
}
