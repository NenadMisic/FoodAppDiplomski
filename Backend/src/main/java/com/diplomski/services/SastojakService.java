package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.entities.Sastojak;
import com.diplomski.entities.SastojciZaJelo;
import com.diplomski.model.FullIngredientModel;
import com.diplomski.model.SastojakModel;
import com.diplomski.repositories.SastojakRepository;
import com.diplomski.repositories.SastojciZaJeloRepository;

@Service
public class SastojakService {
	
	@Autowired
	private SastojakRepository sastojakRepository;
	
	@Autowired
	private SastojciZaJeloRepository sastojciZaJeloRepository;
	
	private ArrayList<SastojciZaJelo> findSastojkeForFood(Integer jeloId) {
		
		ArrayList<SastojciZaJelo> sastojci = new ArrayList<>();
		sastojciZaJeloRepository.findByJeloId(jeloId).forEach(sastojak -> {
			sastojci.add(sastojak);
		});
		return sastojci;
	}
	
	public ArrayList<SastojakModel> findAllForFood(Integer jeloId) {
		
		ArrayList<SastojciZaJelo> sastojciZaJelo = findSastojkeForFood(jeloId);
		ArrayList<SastojakModel> sastojci = new ArrayList<>();
		sastojciZaJelo.forEach(sastojakZaJelo -> {
			Sastojak sastojak = sastojakRepository.findOneBySastojakId(sastojakZaJelo.getSastojakId());
			sastojci.add(new SastojakModel(sastojak.getName(), sastojakZaJelo.getKolicina(), sastojak.getUnit()));
		});
		return sastojci;
	}
	
	public void addIngredients(ArrayList<SastojakModel> sastojci, Integer jeloId)  {
		ArrayList<FullIngredientModel> notExisting = new ArrayList<>(); 
		ArrayList<FullIngredientModel> existing = new ArrayList<>();
		for (SastojakModel sm : sastojci) {
			Integer sastojakId = sastojakRepository.getIdByName(sm.getName());
			if(sastojakId != null && sastojakId > 0) {
				existing.add(new FullIngredientModel(sastojakId, sm));
			} else {
				notExisting.add(new FullIngredientModel(sastojakId, sm));
			}
		}
		for (FullIngredientModel sm : notExisting) {
			sastojakRepository.save(new Sastojak(sm.getIngredientName(), sm.getIngredientAmountUnit()));
			Integer sastojakId = sastojakRepository.getIdByName(sm.getIngredientName());
			sastojciZaJeloRepository.save(new SastojciZaJelo(jeloId, sastojakId, sm.getIngredientAmount()));
		}
		for (FullIngredientModel sm : existing) {
			Integer sastojakId = sastojakRepository.getIdByName(sm.getIngredientName());
			sastojciZaJeloRepository.save(new SastojciZaJelo(jeloId, sastojakId, sm.getIngredientAmount()));
		}
	}
	
	public void deleteAllIngredients(Integer jeloId) {
		sastojciZaJeloRepository.deleteAllByJeloId(jeloId);
	}
}
