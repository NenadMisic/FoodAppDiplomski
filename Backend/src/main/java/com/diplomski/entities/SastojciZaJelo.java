package com.diplomski.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="sastojci_za_jela")
public class SastojciZaJelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="jelo_id")
	private Integer jeloId;
	
	@Column(name="sastojak_id")
	private Integer sastojakId;
	
	@Column(name="kolicina")
	private Integer kolicina;
	
	public SastojciZaJelo(Integer jeloId, Integer sastojakId, Integer kolicina) {
		this.id = null;
		this.jeloId = jeloId;
		this.sastojakId = sastojakId;
		this.kolicina = kolicina;
	}

	public Integer getId() {
		return id;
	}

	public Integer getJeloId() {
		return jeloId;
	}

	public void setJeloId(Integer jeloId) {
		this.jeloId = jeloId;
	}

	public Integer getSastojakId() {
		return sastojakId;
	}

	public void setSastojakId(Integer sastojakId) {
		this.sastojakId = sastojakId;
	}

	public Integer getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}
	
	@Override
	public String toString() {
		return "_______________________________\n" +
				"Sastojak za jelo: \n" +
				"Tabela id: " + id + "\n" +
				"Jelo id: " + jeloId + "\n" +
				"Kolicina: " + kolicina + "\n" +
				"Sastojak id: " + sastojakId + "\n";
	}

}
