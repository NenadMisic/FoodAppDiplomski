package com.diplomski.model;

public class FullIngredientModel {

	private Integer ingredientId;
	private String ingredientName;
	private Integer ingredientAmount;
	private String ingredientAmountUnit;
	
	public FullIngredientModel(Integer ingredientId, String ingredientName, Integer ingredientAmount,
			String ingredientAmountUnit) {
		this.ingredientId = ingredientId;
		this.ingredientName = ingredientName;
		this.ingredientAmount = ingredientAmount;
		this.ingredientAmountUnit = ingredientAmountUnit;
	}
	
	public FullIngredientModel(Integer ingredientId, SastojakModel sastojak) {
		this.ingredientId = ingredientId;
		this.ingredientName = sastojak.getName();
		this.ingredientAmount = sastojak.getAmount();
		this.ingredientAmountUnit = sastojak.getUnit();
	}

	public Integer getIngredientId() {
		return ingredientId;
	}

	public String getIngredientName() {
		return ingredientName;
	}

	public Integer getIngredientAmount() {
		return ingredientAmount;
	}

	public String getIngredientAmountUnit() {
		return ingredientAmountUnit;
	}
	
	@Override
	public String toString() {
		return this.ingredientId + ", " +
		this.ingredientName + ", " +
		this.ingredientAmount + ", " +
		this.ingredientAmountUnit;
	}
	
}
