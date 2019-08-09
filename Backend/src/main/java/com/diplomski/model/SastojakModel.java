package com.diplomski.model;

public class SastojakModel {

	private String name;
	private Integer amount;
	private String unit;
	
	public SastojakModel(String name, Integer amount, String unit) {
		this.name = name;
		this.amount = amount;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "Sastojak: " + this.name + " " + this.amount + " " + this.unit;
	}
}
