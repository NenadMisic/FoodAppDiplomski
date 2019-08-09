package com.diplomski.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restoran")
public class Restoran {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="restoran_id")
    private Integer restoranId;

	@Column(name="ime_restorana", unique=true)
	private String name;
    
	@Column(name="opis_restorana")
    private String description;
    
	@Column(name="adresa")
    private String adress;
    
	@Column(name="img_url")
    private String imgUrl;

	@Column(name="telefon")
    private String phone;
	
	public Restoran () {}
	public Restoran (Integer restoranId, String name, String description, String adress, String imgUrl, String phone) {
		this.restoranId = restoranId;
		this.name = name;
		this.description = description;
		this.adress = adress;
		this.imgUrl = imgUrl;
		this.phone = phone;
	}


    public Integer getRestoranId() {
		return restoranId;
	}

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
		return "Restoran: " + this.restoranId + ", " + this.name + ", " + this.description + ", " + this.adress + ", " + this.imgUrl + ", " + this.phone;
	}
	
}
