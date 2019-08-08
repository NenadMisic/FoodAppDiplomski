package com.diplomski.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@GetMapping(path="/restorani/all")
	public ArrayList<RestoranModel> getAllRestorani() {
	
		return restoranService.getAllRestorani(); 
	}
	
	@GetMapping(path="/restorani/{restoranName}")
	public Restoran getRestoran( @PathVariable("restoranName") String restoranName) {
		String restoranNameFix = restoranName.replace("_", " ");
		return restoranService.getRestoranByName(restoranNameFix);
	}
	
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
	
	@PostMapping(path="/restorani/add")
	public void addNewRestoran (@RequestBody RestoranModel restoran) {
		restoranService.addRestoran(restoran);
	}
	
	@PutMapping(path="/restorani/update/{restoranName}")
	public void updateRestoran(@PathVariable("restoranName") String restoranName, @RequestBody RestoranModel restoran) {
		restoranService.updateRestoran(restoranName, restoran);
	}
	
	@DeleteMapping(path="/restorani/delete/{restoranName}")
	public void deleteRestoran(@PathVariable("restoranName") String restoranName) {
		restoranService.deleteRestoran(restoranName);
	}
}
