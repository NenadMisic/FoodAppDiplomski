package com.diplomski.model;

import com.diplomski.model.RestaurantModel;

import java.util.ArrayList;

import com.diplomski.model.MealModel;

public class FullRestaurantModel {
	
	private RestaurantModel restoran;
	
	private ArrayList<MealModel> jelovnik;

	public FullRestaurantModel(RestaurantModel restoran, ArrayList<MealModel> jelovnik) {
		this.restoran = restoran;
		this.jelovnik = jelovnik;
	}
	
	public RestaurantModel getRestoran() {
		return restoran;
	}
	public void setRestoran(RestaurantModel restoran) {
		this.restoran = restoran;
	}
	public ArrayList<MealModel> getJelovnik() {
		return jelovnik;
	}

	public void setJelovnik(ArrayList<MealModel> jelovnik) {
		this.jelovnik = jelovnik;
	}
	
}
