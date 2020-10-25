package com.diplomski.model;

public class FullNutritionModel {
	
	private Integer nutritionId;
	private String nutritionName;
	private Integer nutritionValue;
	private String nutritionValueUnit;
	
	public FullNutritionModel() {}

	public FullNutritionModel(Integer nutritionId, String nutritionName, Integer nutritionValue,
			String nutritionValueUnit) {
		this.nutritionId = nutritionId;
		this.nutritionName = nutritionName;
		this.nutritionValue = nutritionValue;
		this.nutritionValueUnit = nutritionValueUnit;
	}
	
	public FullNutritionModel(Integer nutritionId, NutritionModel hrvr) {
		this.nutritionId = nutritionId;
		this.nutritionName = hrvr.getName();
		this.nutritionValue = hrvr.getValue();
		this.nutritionValueUnit = hrvr.getUnit();
	}

	public Integer getNutritionId() {
		return nutritionId;
	}

	public String getNutritionName() {
		return nutritionName;
	}

	public Integer getNutritionValue() {
		return nutritionValue;
	}

	public String getNutritionValueUnit() {
		return nutritionValueUnit;
	}

}
