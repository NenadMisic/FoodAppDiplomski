package com.diplomski.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hranljivosti_za_jela")
public class HranljivostiZaJelo {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
	private Integer id;
	
	@Column(name="jelo_id")
	private int jeloId;
	
	@Column(name="hranljivost_id")
	private int hranljivostId;
	
	@Column(name="vrednost")
	private int vrednost;

	public Integer getId() {
		return id;
	}

	public int getJeloId() {
		return jeloId;
	}

	public void setJeloId(int jeloId) {
		this.jeloId = jeloId;
	}

	public int getHranljivostId() {
		return hranljivostId;
	}

	public void setHranljivostId(int hranljivostId) {
		this.hranljivostId = hranljivostId;
	}

	public int getVrednost() {
		return vrednost;
	}

	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	
}
