package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.diplomski.entities.Restaurant;
import com.diplomski.model.RestaurantModel;
import com.diplomski.repositories.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	public ArrayList<RestaurantModel> getAllRestaurants() {
		ArrayList<RestaurantModel> restaurants = new ArrayList<>();
		
		restaurantRepository.findAll().forEach(restaurant -> {
			restaurants.add(new RestaurantModel(restaurant.getName(), restaurant.getDescription(), restaurant.getAdress(), restaurant.getImgUrl(), restaurant.getPhone()));
		});
		return restaurants;
	}
	
	public Restaurant getRestaurantByName(@RequestParam String restaurantName) {
		Restaurant restaurant =  restaurantRepository.findOneByName(restaurantName);
		return restaurant;
	}
	
	public Restaurant getRestaurantById(@RequestParam Integer restaurantId) {
		Restaurant restaurant = restaurantRepository.findOneByRestoranId(restaurantId);
		if(restaurant != null) {
			return restaurant;
		}
		return null;
	}
	
	public Integer getRestaurantIdByName(@RequestParam String name) {
		Integer restaurantId = restaurantRepository.getRestoranIdByName(name);
		return restaurantId;
	}
	
	public void addRestaurant(RestaurantModel restoranModel) {
		Restaurant restaurant = new Restaurant(
				null,
				restoranModel.getName(),
				restoranModel.getDescription(),
				restoranModel.getAdress(),
				restoranModel.getImgUrl(),
				restoranModel.getPhone());
		
		restaurantRepository.save(restaurant);
	}
	
	public void editRestaurant(@RequestParam String restaurantName, @RequestParam RestaurantModel restаurantModel) {
		
		Restaurant oldRestaurant = restaurantRepository.findOneByName(restaurantName);
		
		Restaurant newRestaurant = new Restaurant(
				oldRestaurant.getRestoranId(),
				restаurantModel.getName() == null || restаurantModel.getName() == "" ? oldRestaurant.getName() : restаurantModel.getName(),
				restаurantModel.getDescription() == null || restаurantModel.getDescription() == "" ? oldRestaurant.getDescription() : restаurantModel.getDescription(),
				restаurantModel.getAdress() == null || restаurantModel.getAdress() == "" ? oldRestaurant.getAdress() : restаurantModel.getAdress(),
				restаurantModel.getImgUrl() == null || restаurantModel.getImgUrl() == "" ? oldRestaurant.getImgUrl() : restаurantModel.getImgUrl(),
				restаurantModel.getPhone() == null || restаurantModel.getPhone() == "" ? oldRestaurant.getPhone() : restаurantModel.getPhone());
		
		restaurantRepository.save(newRestaurant);
	}

	public void deleteRestaurant(@RequestParam String restaurantName) {
		restaurantRepository.deleteOneByName(restaurantName);
	}
}
