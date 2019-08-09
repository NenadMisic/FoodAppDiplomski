package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.entities.Jelo;
import com.diplomski.model.HranljivostModel;
import com.diplomski.model.JeloModel;
import com.diplomski.model.SastojakModel;
import com.diplomski.repositories.JeloRepository;

@Service
public class JeloService {
	
	@Autowired
	private JeloRepository jeloRepository;
	
	@Autowired
	private RestoranService restoranService;
	
	@Autowired
	private HranVredService hranVredService;
	
	@Autowired
	private SastojakService sastojakService;
	
	public ArrayList<JeloModel> getAllJela() {
		
		ArrayList<JeloModel> jela = new ArrayList<>();
		
		jeloRepository.findAll().forEach(jelo -> {
			JeloModel jeloModel = constructJelo(jelo);
			jela.add(jeloModel);
		});
		
		return jela;
	}
	
	public ArrayList<JeloModel> getJelaForRestoran(String restoranName) {
		
		ArrayList<JeloModel> jela = new ArrayList<>();
		Integer restoranId = restoranService.getRestoranIdByName(restoranName);
		
		if(restoranId != null) {
			jeloRepository.findAllByRestoranId(restoranId).forEach(jelo -> {
				JeloModel jeloModel = constructJelo(jelo);
				jela.add(jeloModel);
			});
			return jela;
		}
		return null;
	}
	
	private JeloModel constructJelo(Jelo jelo) {
			
		String restoranName = restoranService.getRestoranById(jelo.getRestoranId()).getName();
		
		ArrayList<SastojakModel> sastojci = sastojakService.findAllForFood(jelo.getJeloId());
		ArrayList<HranljivostModel> hranljivosti = hranVredService.findAllForFood(jelo.getJeloId());
		
		return new JeloModel(jelo.getName(), jelo.getDescription(), jelo.getPrice(), jelo.getImgUrl(), restoranName, sastojci, hranljivosti);
	}
	
	public JeloModel getJelo(String jeloName) {
		
		Jelo jelo = jeloRepository.findOneByName(jeloName);
		JeloModel jeloModel = constructJelo(jelo);
		
		return jeloModel;
		
	}
	
	public void addJelo(String restoranName, JeloModel jeloModel) {
		String restoranNameFix = restoranName.replace("_", " ");
		Integer restoranId = restoranService.getRestoranIdByName(restoranNameFix);
		Jelo jelo = new Jelo(
				jeloModel.getName(),
				jeloModel.getDescription(),
				jeloModel.getPrice(),
				jeloModel.getImgUrl(),
				restoranId
				);
		jeloRepository.save(jelo);
		Integer jeloId = jeloRepository.getJeloIdByName(jelo.getName());
		hranVredService.addNutrition(jeloModel.getNutritions(), jeloId);
		sastojakService.addIngredients(jeloModel.getIngredients(), jeloId);
	}
}
