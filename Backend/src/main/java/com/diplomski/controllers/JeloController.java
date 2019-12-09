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

import com.diplomski.model.JeloModel;
import com.diplomski.services.JeloService;

@RestController
public class JeloController {
	
	@Autowired
	private JeloService jeloService;
	
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
	
	@GetMapping(path="restorani/{restoran}/{jelo}")
	public JeloModel getJelo(@PathVariable("jelo") String jeloName) {
		return jeloService.getJelo(jeloName);
	}
	
	@PostMapping(path="/restorani/{restoran}/add")
	public void addNewJelo(@RequestBody JeloModel jeloModel, @PathVariable("restoran") String restoranName) {
		this.jeloService.addJelo(restoranName, jeloModel);
	}
	
	@PutMapping(path="/restorani/{restoran}/edit")
	public void editJelo(@RequestBody JeloModel jeloModel, @PathVariable("restoran") String restoranName) {
		this.jeloService.updateJelo(restoranName, jeloModel);
	}
	
	@DeleteMapping(path="/restorani/{restoran}/delete/{jelo}")
	public void deleteJelo( @PathVariable("restoran") String restoranName,  @PathVariable("jelo") String jeloName) {
		this.jeloService.deleteJelo(restoranName, jeloName);
	}
}
