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

import com.diplomski.model.MealModel;
import com.diplomski.services.FoodService;

@RestController
public class FoodController {
	
	@Autowired
	private FoodService foodService;
	
	@GetMapping(path="/restorani/restoran/jela/all")
	public ArrayList<MealModel> getAllFood() {
		
		return foodService.getAllFood();
	}
	
	@GetMapping(path="/restorani/{restoran}/jelovnik")
	public ArrayList<MealModel> getFoodForRestaurant(@PathVariable("restoran") String restaurantName) {
		System.out.println(restaurantName);
		String restaurantNameFix = restaurantName.replace("_", " ");
		System.out.println(restaurantNameFix);
		return foodService.getFoodForRestaurant(restaurantNameFix);
	}
	
	@GetMapping(path="restorani/{restoran}/{jelo}")
	public MealModel getMeal(@PathVariable("jelo") String mealName) {
		return foodService.getMeal(mealName);
	}
	
	@PostMapping(path="/restorani/{restoran}/add")
	public void addNewJelo(@RequestBody MealModel mealModel, @PathVariable("restoran") String restaurantName) {
		this.foodService.addMeal(restaurantName, mealModel);
	}
	
	@PutMapping(path="/restorani/{restoran}/edit")
	public void editMeal(@RequestBody MealModel mealModel, @PathVariable("restoran") String restaurantName) {
		this.foodService.updateMeal(restaurantName, mealModel);
	}
	
	@DeleteMapping(path="/restorani/{restoran}/delete/{jelo}")
	public void deleteMeal( @PathVariable("restoran") String restaurantName, @PathVariable("jelo") String mealName) {
		this.foodService.deleteMeal(restaurantName, mealName);
	}
}
