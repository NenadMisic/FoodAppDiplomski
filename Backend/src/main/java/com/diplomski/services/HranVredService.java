package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.entities.HranljivaVrednost;
import com.diplomski.entities.HranljivostiZaJelo;
import com.diplomski.model.HranljivostModel;
import com.diplomski.repositories.HranVredRepository;
import com.diplomski.repositories.HranljivostiZaJeloRepository;

@Service
public class HranVredService {
	
	@Autowired
	private HranljivostiZaJeloRepository hranljivostiZaJeloRepository;
	
	@Autowired
	private HranVredRepository hranVredRepository;
	
	public void addHranVrednosti(ArrayList<HranljivaVrednost> hranVrednosti)  {
		
		hranVrednosti.forEach(hranVrednost -> {
			hranVredRepository.save(hranVrednost);
		});	
	}
	
	private ArrayList<HranljivostiZaJelo> findHranVredForFood(Integer jeloId) {
		
		ArrayList<HranljivostiZaJelo> hranVrednosti = new ArrayList<>();
		hranljivostiZaJeloRepository.findByJeloId(jeloId).forEach(hranVred -> {
			hranVrednosti.add(hranVred);
		});
		return hranVrednosti;
	}
	
	public ArrayList<HranljivostModel> findAllForFood(Integer jeloId) {
		
		ArrayList<HranljivostiZaJelo> hranljivostiZaJelo = findHranVredForFood(jeloId);
		ArrayList<HranljivostModel> hranVrednosti = new ArrayList<>();
		
		hranljivostiZaJelo.forEach(hranljivost -> {
			
			HranljivaVrednost hranVred = hranVredRepository.findByHranljivostId(hranljivost.getHranljivostId());
			hranVrednosti.add(new HranljivostModel(hranVred.getNaziv(), hranljivost.getVrednost(), hranVred.getJedinicaMere()));
		});
		return hranVrednosti;
	}
	
	

}
