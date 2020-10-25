package com.diplomski.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diplomski.entities.Restaurant;
import com.diplomski.model.FullRestaurantModel;
import com.diplomski.model.MealModel;
import com.diplomski.model.RestaurantModel;
import com.diplomski.services.FoodService;
import com.diplomski.services.RestaurantService;

@RestController
public class MenuController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping(path="/restorani/{restaurantName}/full")
	public FullRestaurantModel getRestaurantWithMenu( @PathVariable("restaurantName") String restaurantName) {
		String restaurantNameFix = restaurantName.replace("_", " ");
		FullRestaurantModel frm;
		
		Restaurant restaurant = restaurantService.getRestaurantByName(restaurantNameFix);
		RestaurantModel restaurantMdl = new RestaurantModel(restaurant.getName(), restaurant.getDescription(), restaurant.getAdress(), restaurant.getImgUrl(), restaurant.getPhone());
		ArrayList<MealModel> menu = foodService.getFoodForRestaurant(restaurantNameFix);
		
		frm = new FullRestaurantModel(restaurantMdl, menu);
		return frm;
	}
	
	// TODO Ubaciti pojedinacno sastojak, nutritivnu vrednost
	// TODO Update pojedinacnog sastojka, nutritivne vrednosti
	// TODO DELETE

}
