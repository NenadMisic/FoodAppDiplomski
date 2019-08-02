package com.diplomski.model;

import com.diplomski.model.RestoranModel;

import java.util.ArrayList;

import com.diplomski.model.JeloModel;

public class FullRestoranModel {
	
	private RestoranModel restoran;
	
	private ArrayList<JeloModel> jelovnik;

	public FullRestoranModel(RestoranModel restoran, ArrayList<JeloModel> jelovnik) {
		this.restoran = restoran;
		this.jelovnik = jelovnik;
	}
	
	public RestoranModel getRestoran() {
		return restoran;
	}
	public void setRestoran(RestoranModel restoran) {
		this.restoran = restoran;
	}
	public ArrayList<JeloModel> getJelovnik() {
		return jelovnik;
	}

	public void setJelovnik(ArrayList<JeloModel> jelovnik) {
		this.jelovnik = jelovnik;
	}
	
}
