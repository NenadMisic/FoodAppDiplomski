package com.diplomski.model;


public class RestaurantModel {
	
	private String name;
    private String description;
    private String adress;
    private String imgUrl;
    private String phone;
    
    public RestaurantModel(String name, String description, String adress, String imgUrl, String phone) {
    	this.name = name;
    	this.description = description;
    	this.adress = adress;
    	this.imgUrl = imgUrl;
    	this.phone = phone;
    }
    public RestaurantModel() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString() {
		return "Restoran MODEL: " + this.name + ", " + this.description + ", " + this.adress + ", " + this.imgUrl + ", " + this.phone;
	}

}
