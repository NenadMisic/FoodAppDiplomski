package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diplomski.entities.Jelo;
import com.diplomski.entities.Restoran;
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
	
	public void addJelo(Jelo jelo) {
		jeloRepository.save(jelo);
	}
	
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
		Restoran restorann = restoranService.getRestoranByName(restoranName);
		System.out.println("JeloService: ");
		System.out.println(restorann.getRestoranId());
		Integer restoranId = restoranService.getRestoranByName(restoranName).getRestoranId();
		
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

}
