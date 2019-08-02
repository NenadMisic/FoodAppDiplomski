package com.diplomski.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diplomski.entities.Restoran;
import com.diplomski.model.FullRestoranModel;
import com.diplomski.model.JeloModel;
import com.diplomski.model.RestoranModel;
import com.diplomski.services.JeloService;
import com.diplomski.services.RestoranService;

@RestController
public class RestoranController {
	
	@Autowired
	private RestoranService restoranService;
	
	@Autowired
	private JeloService jeloService;
	
	@PostMapping(path="/restorani/add")
	public void addNewRestoran (@RequestParam String name, 
			@RequestParam String description, @RequestParam String adress, @RequestParam String imgUrl, @RequestParam String phone) {
		
		restoranService.addRestoran(name, description, adress, imgUrl, phone);
	}
	
	@GetMapping(path="/restorani/all")
	public ArrayList<RestoranModel> getAllRestorani() {
	
		return restoranService.getAllRestorani(); 
	}
	
	@GetMapping(path="/restorani/{imeRestorana}")
	public Restoran getRestoran( @PathVariable("imeRestorana") String restoranName) {
		String restoranNameFix = restoranName.replace("_", " ");
		return restoranService.getRestoranByName(restoranNameFix);
	}
	
	@GetMapping(path="/restorani/{imeRestorana}/full")
	public FullRestoranModel getRestoranWithMenu( @PathVariable("imeRestorana") String restoranName) {
		String restoranNameFix = restoranName.replace("_", " ");
		FullRestoranModel frm;
		
		Restoran restoran = restoranService.getRestoranByName(restoranNameFix);
		RestoranModel restoranMdl = new RestoranModel(restoran.getName(), restoran.getDescription(), restoran.getAdress(), restoran.getImgUrl(), restoran.getPhone());
		ArrayList<JeloModel> jelovnik = jeloService.getJelaForRestoran(restoranNameFix);
		
		frm = new FullRestoranModel(restoranMdl, jelovnik);
		return frm;
	}
	
	@PutMapping(path="/restorani/update/{imeRestorana}")
	public void updateRestoran(@PathVariable("imeRestorana") Restoran restoran) {
		restoranService.updateRestoran(restoran);
	}
	
	@DeleteMapping(path="/restorani/delete/{imeRestorana}")
	public void deleteRestoran(@PathVariable("imeRestorana") Restoran restoran) {
		restoranService.deleteRestoran(restoran);
	}
}
