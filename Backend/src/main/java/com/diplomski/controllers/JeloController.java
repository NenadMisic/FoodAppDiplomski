package com.diplomski.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diplomski.entities.HranljivaVrednost;
import com.diplomski.entities.Jelo;
import com.diplomski.entities.Sastojak;
import com.diplomski.model.JeloModel;
import com.diplomski.services.HranVredService;
import com.diplomski.services.JeloService;
import com.diplomski.services.SastojakService;

@RestController
public class JeloController {
	
	@Autowired
	private JeloService jeloService;
	
	@Autowired
	private SastojakService sastojakService;
	
	@Autowired
	private HranVredService hranVredService;
	
	@GetMapping(path="/restorani/restoran/jela/all")
	public ArrayList<JeloModel> getAllJela() {
		
		return jeloService.getAllJela();
	}
	
	@GetMapping(path="/restorani/{restoran}/jelovnik")
	public ArrayList<JeloModel> getJelaForRestoran(@PathVariable("restoran") String restoranName) {
		System.out.println(restoranName);
		String restoranNameFix = restoranName.replace("_", " ");
		System.out.println(restoranNameFix);
		return jeloService.getJelaForRestoran(restoranNameFix);
	}
	
	@PostMapping(path="/restorani/{restoran}/addJelo")
	public void addNewJelo (@RequestParam String name, 
			@RequestParam String description, @RequestParam Integer price, @RequestParam String imgUrl, @RequestParam Integer restoranId,
			@RequestParam ArrayList<Sastojak> sastojci, @RequestParam ArrayList<HranljivaVrednost> hranVred ) {
		
		Jelo jelo = new Jelo();
		
		jelo.setName(name);
		jelo.setDescription(description);
		jelo.setPrice(price);
		jelo.setImgUrl(imgUrl);
		jelo.setRestoranId(restoranId);
		
		jeloService.addJelo(jelo);
		
		sastojakService.addSastojke(sastojci);
		
		hranVredService.addHranVrednosti(hranVred);
		
	}
	
}
