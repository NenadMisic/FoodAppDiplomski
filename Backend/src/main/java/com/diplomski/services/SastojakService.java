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
		System.out.println("######################################");
		sastojciZaJeloRepository.findByJeloId(jeloId).forEach(sastojak -> {
			System.out.println(sastojak.toString());
			sastojci.add(sastojak);
		});
		System.out.println("######################################");
		return sastojci;
	}
	
	public ArrayList<SastojakModel> findAllForFood(Integer jeloId) {
		
		ArrayList<SastojciZaJelo> sastojciZaJelo = findSastojkeForFood(jeloId);
		ArrayList<SastojakModel> sastojci = new ArrayList<>();
		sastojciZaJelo.forEach(sastojakZaJelo -> {
			System.out.println(sastojakZaJelo.toString());
			Sastojak sastojak = sastojakRepository.findOneBySastojakId(sastojakZaJelo.getSastojakId());
			sastojci.add(new SastojakModel(sastojak.getName(), sastojakZaJelo.getKolicina(), sastojak.getUnit()));
			System.out.println(sastojak.toString());
			System.out.println("Do ovde radi SastojakService -> 49");
		});
		System.out.println("Do ovde radi SastojakService -> 51");
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
		System.out.println("Not Existing");
		for (FullIngredientModel sm : notExisting) {
			System.out.println(sm.toString());
			sastojakRepository.save(new Sastojak(sm.getIngredientName(), sm.getIngredientAmountUnit()));
			Integer sastojakId = sastojakRepository.getIdByName(sm.getIngredientName());
			sastojciZaJeloRepository.save(new SastojciZaJelo(jeloId, sastojakId, sm.getIngredientAmount()));
		}
		System.out.println("Existing");
		for (FullIngredientModel sm : existing) {
			System.out.println(sm.toString());
			Integer sastojakId = sastojakRepository.getIdByName(sm.getIngredientName());
			sastojciZaJeloRepository.save(new SastojciZaJelo(jeloId, sastojakId, sm.getIngredientAmount()));
		}
	}
	
	public void deleteAllIngredients(Integer jeloId) {
		sastojciZaJeloRepository.deleteAllByJeloId(jeloId);
	}
}
