package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.entities.Nutrition;
import com.diplomski.entities.NutritionsForMeal;
import com.diplomski.model.FullNutritionModel;
import com.diplomski.model.NutritionModel;
import com.diplomski.repositories.NutritionRepository;
import com.diplomski.repositories.NutritionsForMealRepository;

@Service
public class NutritionService {
	
	@Autowired
	private NutritionsForMealRepository nutritionsForMealRepository;
	
	@Autowired
	private NutritionRepository nutritionRepository;
	
	public void addNutritions(ArrayList<Nutrition> nutritions)  {
		
		nutritions.forEach(nutrition -> {
			nutritionRepository.save(nutrition);
		});	
	}
	
	private ArrayList<NutritionsForMeal> findNutritionsForMeal(Integer mealId) {
		
		ArrayList<NutritionsForMeal> nutritions = new ArrayList<>();
		nutritionsForMealRepository.findByJeloId(mealId).forEach(nutrition -> {
			nutritions.add(nutrition);
		});
		return nutritions;
	}
	
	public ArrayList<NutritionModel> findAllForMeal(Integer mealId) {
		
		ArrayList<NutritionsForMeal> nutritionsForMeal = findNutritionsForMeal(mealId);
		ArrayList<NutritionModel> nutritions = new ArrayList<>();
		
		nutritionsForMeal.forEach(nutritionForMeal -> {
			
			Nutrition nutrition = nutritionRepository.findByHranljivostId(nutritionForMeal.getHranljivostId());
			nutritions.add(new NutritionModel(nutrition.getNaziv(), nutritionForMeal.getVrednost(), nutrition.getJedinicaMere()));
		});
		return nutritions;
	}
	
	public void addNutrition(ArrayList<NutritionModel> nutritionModelArr, Integer mealId) {
		ArrayList<FullNutritionModel> notExisting = new ArrayList<>(); 
		ArrayList<FullNutritionModel> existing = new ArrayList<>(); 
		for (NutritionModel nutritionModel : nutritionModelArr) {
			Integer nutritionId = nutritionRepository.getIdByName(nutritionModel.getName());
			if(nutritionId != null && nutritionId > 0) {
				existing.add(new FullNutritionModel(nutritionId, nutritionModel));
			} else {
				notExisting.add(new FullNutritionModel(nutritionId, nutritionModel));
			}
		}
		for (FullNutritionModel nutrition : notExisting) {
			nutritionRepository.save(new Nutrition(nutrition.getNutritionName(), nutrition.getNutritionValueUnit()));
			Integer nutritionId = nutritionRepository.getIdByName(nutrition.getNutritionName());
			nutritionsForMealRepository.save(new NutritionsForMeal(mealId, nutritionId, nutrition.getNutritionValue()));
		}
		for (FullNutritionModel nutrition : existing) {
			Integer nutritionId = nutritionRepository.getIdByName(nutrition.getNutritionName());
			nutritionsForMealRepository.save(new NutritionsForMeal(mealId, nutritionId, nutrition.getNutritionValue()));
		}
	}
	
	public void deleteAllNutitions(Integer mealId) {
		nutritionsForMealRepository.deleteAllByJeloId(mealId);
	}
}
