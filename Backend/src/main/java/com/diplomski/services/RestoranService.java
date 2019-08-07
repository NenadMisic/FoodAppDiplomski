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
	
	public void addRestoranAlt( 
			@RequestParam String name, 
			@RequestParam String description,
			@RequestParam String adress,
			@RequestParam String imgUrl,
			@RequestParam String phone) {
		
		Restoran restoran = new Restoran(null, name, description, adress, imgUrl, phone);
		/*restoran.setName(name);
		restoran.setDescription(description);
		restoran.setAdress(adress);
		restoran.setImgUrl(imgUrl);
		restoran.setPhone(phone);*/
		System.out.println(restoran.toString());
		restoranRepository.save(restoran);
	}
	
	public void addRestoran(RestoranModel restoranModel) {
		System.out.println("IN SERVICE: \n" + restoranModel.toString());
		Restoran restoran = new Restoran(
				null,
				restoranModel.getName(),
				restoranModel.getDescription(),
				restoranModel.getAdress(),
				restoranModel.getImgUrl(),
				restoranModel.getPhone());
		System.out.println(restoran.toString());
		/*restoran.setName(restoranModel.getName());
		restoran.setDescription(restoranModel.getDescription());
		restoran.setAdress(restoranModel.getAdress());
		restoran.setImgUrl(restoranModel.getImgUrl());
		restoran.setPhone(restoranModel.getPhone());*/
		
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
