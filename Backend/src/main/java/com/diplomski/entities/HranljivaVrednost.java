package com.diplomski.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hranljivost")
public class HranljivaVrednost {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="hranljivost_id")
	private Integer hranljivostId;
	
	@Column(name="naziv")
	private String naziv;
	
	@Column(name="jedinica_mere")
	private String jedinicaMere;

	public Integer getHranljivostId() {
		return hranljivostId;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getJedinicaMere() {
		return jedinicaMere;
	}

	public void setJedinicaMere(String jedinicaMere) {
		this.jedinicaMere = jedinicaMere;
	}
	
}
