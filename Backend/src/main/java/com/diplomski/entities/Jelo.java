package com.diplomski.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="jelo")
public class Jelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="jelo_id")
    private Integer jeloId;

	@Column(name="ime_jela", unique=true)
	private String name;

	@Column(name="opis_jela")
	private String description;
    
	@Column(name="cena")
    private Integer price;
    
	@Column(name="img_url")
    private String imgUrl;

    @Column(name="restoran_id")
    private Integer restoranId;
    
    public Jelo() {}
    
    public Jelo(Integer jeloId ,String name, String description, Integer price, String imgUrl, Integer restoranId) {
    	this.jeloId = jeloId;
    	this.name = name;
    	this.description = description;
    	this.price = price;
    	this.imgUrl = imgUrl;
    	this.restoranId = restoranId;
    }
    
    public Jelo(String name, String description, Integer price, String imgUrl, Integer restoranId) {
    	this.name = name;
    	this.description = description;
    	this.price = price;
    	this.imgUrl = imgUrl;
    	this.restoranId = restoranId;
    }

    public Integer getJeloId() {
		return jeloId;
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

	public Integer getRestoranId() {
		return restoranId;
	}

	public void setRestoranId(Integer restoranId) {
		this.restoranId = restoranId;
	}
	
	@Override
	public String toString() {
		return this.name + ", " + this.description + ", " + this.price + ", " + this.imgUrl + ", " + this.restoranId;
	}
	
}
