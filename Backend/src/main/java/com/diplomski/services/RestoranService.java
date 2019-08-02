package com.diplomski.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.diplomski.entities.Restoran;
import com.diplomski.model.RestoranModel;
import com.diplomski.repositories.RestoranRepository;

@Service
public class RestoranService {
	
	@Autowired
	private RestoranRepository restoranRepository;
	
	public void addRestoran( @RequestParam String name, 
			@RequestParam String description, @RequestParam String adress, @RequestParam String imgUrl, @RequestParam String phone) {
		
		Restoran restoran = new Restoran();
		restoran.setName(name);
		restoran.setDescription(description);
		restoran.setAdress(adress);
		restoran.setImgUrl(imgUrl);
		restoran.setPhone(phone);
		
		restoranRepository.save(restoran);
	}
	
	public ArrayList<RestoranModel> getAllRestorani() {
		ArrayList<RestoranModel> restorani = new ArrayList<>();
		
		restoranRepository.findAll().forEach(restoran -> {
			restorani.add(new RestoranModel(restoran.getName(), restoran.getDescription(), restoran.getAdress(), restoran.getImgUrl(), restoran.getPhone()));
		});;
		return restorani;
	}
	
	public Restoran getRestoranByName(@RequestParam String restoranName) {
		System.out.println("RestoranService Name: ");
		System.out.println(restoranName);
		Restoran restoran =  restoranRepository.findOneByName(restoranName);
		System.out.println("RestoranService Restoran Id: ");
		System.out.println(restoran.getRestoranId());
		return restoran;
	}
	
	public Restoran getRestoranById(@RequestParam Integer restoranId) {
		Restoran restoran = restoranRepository.findOneByRestoranId(restoranId);
		if(restoran != null) {
			return restoran;
		}
		return null;
	}
	
	public void updateRestoran(@RequestParam Restoran restoran) {
		restoranRepository.save(restoran);
	}

	public void deleteRestoran(@RequestParam Restoran restoran) {
		restoranRepository.delete(restoran);
	}
}
