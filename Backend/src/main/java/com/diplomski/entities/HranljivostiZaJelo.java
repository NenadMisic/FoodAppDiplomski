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
	private Integer jeloId;
	
	@Column(name="hranljivost_id")
	private Integer hranljivostId;
	
	@Column(name="vrednost")
	private Integer vrednost;

	public HranljivostiZaJelo(Integer jeloId, Integer hranljivostId, Integer vrednost) {
		this.id = null;
		this.jeloId = jeloId;
		this.hranljivostId = hranljivostId;
		this.vrednost = vrednost;
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

	public Integer getHranljivostId() {
		return hranljivostId;
	}

	public void setHranljivostId(Integer hranljivostId) {
		this.hranljivostId = hranljivostId;
	}

	public int getVrednost() {
		return vrednost;
	}

	public void setVrednost(int vrednost) {
		this.vrednost = vrednost;
	}
	
}
