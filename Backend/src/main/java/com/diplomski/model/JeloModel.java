package com.diplomski.model;

import java.util.ArrayList;

import com.diplomski.model.SastojakModel;
import com.diplomski.model.HranljivostModel;

public class JeloModel {

	private String name;
	private String description;
    private Integer price;
    private String imgUrl;
    private String restoranName;
    private ArrayList<SastojakModel> sastojci;
    private ArrayList<HranljivostModel> hranVrednosti;
    
    public JeloModel(
    		String name,
    		String description,
    		Integer price,
    		String imgUrl,
    		String restoranName,
    		ArrayList<SastojakModel> sastojci,
    		ArrayList<HranljivostModel> hranVrednosti) {
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
	
	public void setSastojci(ArrayList<SastojakModel> sastojci) {
		this.sastojci = sastojci;
	}
	
	public ArrayList<SastojakModel> getIngredients() {
		return this.sastojci;
	}
	
	public SastojakModel getSastojakByIndex(Integer index) {
		for (SastojakModel sastojak : sastojci) {
			if (sastojci.indexOf(sastojak) == index) {
				return sastojak;
			}
		}
		return null;
	}
	
	public void addSastojak(SastojakModel sastojak) {
		this.sastojci.add(sastojak);
	}
	
	public void setHranVred(ArrayList<HranljivostModel> hranVred) {
		this.hranVrednosti = hranVred;
	}
	
	public ArrayList<HranljivostModel> getNutritions() {
		return this.hranVrednosti;
	}
	
	public HranljivostModel getHranVrednostByIndex(Integer index) {
		for (HranljivostModel hrvr : hranVrednosti) {
			if (hranVrednosti.indexOf(hrvr) == index) {
				return hrvr;
			}
		}
		return null;
	}
	
	public void addSastojak(HranljivostModel hrvr) {
		this.hranVrednosti.add(hrvr);
	}
	
}
