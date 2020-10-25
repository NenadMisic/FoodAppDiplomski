package com.diplomski.model;

import java.util.ArrayList;

import com.diplomski.model.IngredientModel;
import com.diplomski.model.NutritionModel;

public class MealModel {

	private String name;
	private String description;
    private Integer price;
    private String imgUrl;
    private String restoranName;
    private ArrayList<IngredientModel> sastojci;
    private ArrayList<NutritionModel> hranVrednosti;
    
    public MealModel() {}
    public MealModel(
    		String name,
    		String description,
    		Integer price,
    		String imgUrl,
    		String restoranName,
    		ArrayList<IngredientModel> sastojci,
    		ArrayList<NutritionModel> hranVrednosti) {
    	this.name = name;
    	this.description = description;
    	this.price = price;
    	this.imgUrl = imgUrl;
    	this.restoranName = restoranName;
    	this.sastojci = sastojci;
    	this.hranVrednosti = hranVrednosti;
    }
    
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getRestoranName() {
		return restoranName;
	}

	public void setRestoranName(String restoranName) {
		this.restoranName = restoranName;
	}
	
	public void setSastojci(ArrayList<IngredientModel> sastojci) {
		this.sastojci = sastojci;
	}
	
	public ArrayList<IngredientModel> getIngredients() {
		return this.sastojci;
	}
	
	public IngredientModel getSastojakByIndex(Integer index) {
		for (IngredientModel sastojak : sastojci) {
			if (sastojci.indexOf(sastojak) == index) {
				return sastojak;
			}
		}
		return null;
	}
	
	public void addSastojak(IngredientModel sastojak) {
		this.sastojci.add(sastojak);
	}
	
	public void setHranVrednosti(ArrayList<NutritionModel> hranVred) {
		this.hranVrednosti = hranVred;
	}
	
	public ArrayList<NutritionModel> getNutritions() {
		return this.hranVrednosti;
	}
	
	public NutritionModel getHranVrednostByIndex(Integer index) {
		for (NutritionModel hrvr : hranVrednosti) {
			if (hranVrednosti.indexOf(hrvr) == index) {
				return hrvr;
			}
		}
		return null;
	}
	
	public void addHranljivost(NutritionModel hrvr) {
		this.hranVrednosti.add(hrvr);
	}
	
}
