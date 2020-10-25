package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.entities.Meal;
import com.diplomski.model.NutritionModel;
import com.diplomski.model.MealModel;
import com.diplomski.model.IngredientModel;
import com.diplomski.repositories.MealRepository;

@Service
public class FoodService {
	
	@Autowired
	private MealRepository mealRepository;
	
	@Autowired
	private RestaurantService restaurantService;
	
	@Autowired
	private NutritionService nutritionService;
	
	@Autowired
	private IngredientService ingredientService;
	
	public ArrayList<MealModel> getAllFood() {
		
		ArrayList<MealModel> food = new ArrayList<>();
		
		mealRepository.findAll().forEach(meal -> {
			if (food.size() < 8) {
				MealModel mealModel = constructMeal(meal);
				food.add(mealModel);
			} else {
				return;
			}
		});
		System.out.println(food.size());
		return food;
	}
	
	public ArrayList<MealModel> getFoodForRestaurant(String restaurantName) {
		
		ArrayList<MealModel> food = new ArrayList<>();
		Integer restaurantId = restaurantService.getRestaurantIdByName(restaurantName);
		
		if(restaurantId != null) {
			mealRepository.findAllByRestoranId(restaurantId).forEach(meal -> {
				MealModel mealModel = constructMeal(meal);
				food.add(mealModel);
			});
			return food;
		}
		return null;
	}
	
	private MealModel constructMeal(Meal meal) {
			
		String restaurantName = restaurantService.getRestaurantById(meal.getRestoranId()).getName();
		
		ArrayList<IngredientModel> ingredients = ingredientService.findAllForMeal(meal.getJeloId());
		ArrayList<NutritionModel> nutritions = nutritionService.findAllForMeal(meal.getJeloId());
		
		return new MealModel(meal.getName(), meal.getDescription(), meal.getPrice(), meal.getImgUrl(), restaurantName, ingredients, nutritions);
	}
	
	public MealModel getMeal(String mealName) {
		
		Meal meal = mealRepository.findOneByName(mealName);
		MealModel mealModel = constructMeal(meal);
		
		return mealModel;
		
	}
	
	public void addMeal(String restaurantName, MealModel mealModel) {
		String restaurantNameFix = restaurantName.replace("_", " ");
		Integer restaurantId = restaurantService.getRestaurantIdByName(restaurantNameFix);
		Meal meal = new Meal(
				mealModel.getName(),
				mealModel.getDescription(),
				mealModel.getPrice(),
				mealModel.getImgUrl(),
				restaurantId
				);
		if (meal != null) {
			mealRepository.save(meal);
		}
		if (mealModel.getNutritions() == null || mealModel.getIngredients() == null ) {
			return;
		} else {
			Integer mealId = mealRepository.getJeloIdByName(meal.getName(), restaurantId);
			nutritionService.addNutrition(mealModel.getNutritions(), mealId);
			ingredientService.addIngredients(mealModel.getIngredients(), mealId);
		}
	}
	
	public void updateMeal(String restaurantName, MealModel mealModel) {
		String restaurantNameFix = restaurantName.replace("_", " ");
		Integer restaurantId = restaurantService.getRestaurantIdByName(restaurantNameFix);
		Meal oldMeal = mealRepository.findOneByName(mealModel.getName());
		Meal newMeal = new Meal(
				oldMeal.getJeloId(),
				mealModel.getName(),
				mealModel.getDescription(),
				mealModel.getPrice(),
				mealModel.getImgUrl(),
				restaurantId
				);
		mealRepository.save(newMeal);
		
	}
	
	public void deleteMeal(String restaurantName, String mealName) {
		String restaurantNameFix = restaurantName.replace("_", " ");
		String mealNameFix = mealName.replace("_", " ");
		System.out.println(restaurantNameFix + " " + mealNameFix);
		Integer restaurantId = restaurantService.getRestaurantIdByName(restaurantNameFix);
		Integer mealId = mealRepository.getJeloIdByName(mealNameFix, restaurantId);
		System.out.println(restaurantId + " " + mealId);
		mealRepository.deleteById(mealId);
		ingredientService.deleteAllIngredients(mealId);
		nutritionService.deleteAllNutitions(mealId);
	}
}
