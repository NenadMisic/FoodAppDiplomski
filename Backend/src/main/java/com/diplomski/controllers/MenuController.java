package com.diplomski.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.diplomski.entities.Restoran;
import com.diplomski.model.FullRestoranModel;
import com.diplomski.model.JeloModel;
import com.diplomski.model.RestoranModel;
import com.diplomski.services.JeloService;
import com.diplomski.services.RestoranService;

@RestController
public class MenuController {
	
	@Autowired
	private RestoranService restoranService;
	
	@Autowired
	private JeloService jeloService;
	
	@GetMapping(path="/restorani/{restoranName}/full")
	public FullRestoranModel getRestoranWithMenu( @PathVariable("restoranName") String restoranName) {
		String restoranNameFix = restoranName.replace("_", " ");
		FullRestoranModel frm;
		
		Restoran restoran = restoranService.getRestoranByName(restoranNameFix);
		RestoranModel restoranMdl = new RestoranModel(restoran.getName(), restoran.getDescription(), restoran.getAdress(), restoran.getImgUrl(), restoran.getPhone());
		ArrayList<JeloModel> jelovnik = jeloService.getJelaForRestoran(restoranNameFix);
		
		frm = new FullRestoranModel(restoranMdl, jelovnik);
		return frm;
	}
	
	// TODO Ubaciti pojedinacno sastojak, nutritivnu vrednost
	// TODO Update pojedinacnog sastojka, nutritivne vrednosti
	// TODO DELETE

}
