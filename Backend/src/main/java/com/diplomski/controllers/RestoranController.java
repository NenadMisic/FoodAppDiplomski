package com.diplomski.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.diplomski.entities.Restoran;
import com.diplomski.model.RestoranModel;
import com.diplomski.services.RestoranService;

@RestController
public class RestoranController {
	
	@Autowired
	private RestoranService restoranService;
	
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
	public Restoran getRestoran( @RequestParam String restoranName) {
		return restoranService.getRestoranByName(restoranName);
	}
	
	@PutMapping(path="/restorani/update/{imeRestorana}")
	public void updateRestoran(@RequestParam Restoran restoran) {
		restoranService.updateRestoran(restoran);
	}
	
	@DeleteMapping(path="/restorani/delete")
	public void deleteRestoran(@RequestParam Restoran restoran) {
		restoranService.deleteRestoran(restoran);
	}
}
