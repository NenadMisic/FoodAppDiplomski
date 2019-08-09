package com.diplomski.model;

public class HranljivostModel {

	private String name;
	private Integer value;
	private String unit;
	
	public HranljivostModel(String name, Integer value, String unit) {
		this.name = name;
		this.value = value;
		this.unit = unit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "Name: " + this.name + ", " + "Value: " + this.value;
	}
	
}
