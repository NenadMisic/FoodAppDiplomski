package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.entities.Ingredient;
import com.diplomski.entities.IngredientsForMeal;
import com.diplomski.model.FullIngredientModel;
import com.diplomski.model.IngredientModel;
import com.diplomski.repositories.IngredientRepository;
import com.diplomski.repositories.IngredientsForMealRepository;

@Service
public class IngredientService {
	
	@Autowired
	private IngredientRepository ingredientRepository;
	
	@Autowired
	private IngredientsForMealRepository ingredientsForMealRepository;
	
	private ArrayList<IngredientsForMeal> findIngredientsForMeal(Integer mealId) {
		
		ArrayList<IngredientsForMeal> ingredients = new ArrayList<>();
		ingredientsForMealRepository.findByJeloId(mealId).forEach(ingredient -> {
			ingredients.add(ingredient);
		});
		return ingredients;
	}
	
	public ArrayList<IngredientModel> findAllForMeal(Integer mealId) {
		
		ArrayList<IngredientsForMeal> ingredientsForMeal = findIngredientsForMeal(mealId);
		ArrayList<IngredientModel> ingredients = new ArrayList<>();
		ingredientsForMeal.forEach(ingredientForMeal -> {
			Ingredient ingredient = ingredientRepository.findOneBySastojakId(ingredientForMeal.getSastojakId());
			ingredients.add(new IngredientModel(ingredient.getName(), ingredientForMeal.getKolicina(), ingredient.getUnit()));
		});
		return ingredients;
	}
	
	public void addIngredients(ArrayList<IngredientModel> ingredients, Integer mealId)  {
		ArrayList<FullIngredientModel> notExisting = new ArrayList<>(); 
		ArrayList<FullIngredientModel> existing = new ArrayList<>();
		for (IngredientModel im : ingredients) {
			Integer ingredientId = ingredientRepository.getIdByName(im.getName());
			if(ingredientId != null && ingredientId > 0) {
				existing.add(new FullIngredientModel(ingredientId, im));
			} else {
				notExisting.add(new FullIngredientModel(ingredientId, im));
			}
		}
		for (FullIngredientModel fim : notExisting) {
			ingredientRepository.save(new Ingredient(fim.getIngredientName(), fim.getIngredientAmountUnit()));
			Integer ingredientId = ingredientRepository.getIdByName(fim.getIngredientName());
			ingredientsForMealRepository.save(new IngredientsForMeal(mealId, ingredientId, fim.getIngredientAmount()));
		}
		for (FullIngredientModel fim : existing) {
			Integer ingredientId = ingredientRepository.getIdByName(fim.getIngredientName());
			ingredientsForMealRepository.save(new IngredientsForMeal(mealId, ingredientId, fim.getIngredientAmount()));
		}
	}
	
	public void deleteAllIngredients(Integer mealId) {
		ingredientsForMealRepository.deleteAllByJeloId(mealId);
	}
}
