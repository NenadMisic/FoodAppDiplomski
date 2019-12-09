package com.diplomski.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sastojak")
public class Sastojak {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sastojak_id")
    private Integer sastojakId;

	@Column(name="naziv")
	private String name;
	
	@Column(name="jedinica_mere")
	private String unit;
	
	public Sastojak(String name, String unit) {

		this.sastojakId = null;
		this.name = name;
		this.unit = unit;
	}
	
	public Sastojak() {}

	public Integer getSastojakId() {
		return sastojakId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}
	
	@Override
	public String toString() {
		return "Sastojak: " + sastojakId + " " + name + " " + unit;
	}


}
