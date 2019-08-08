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
	
	public ArrayList<RestoranModel> getAllRestorani() {
		ArrayList<RestoranModel> restorani = new ArrayList<>();
		
		restoranRepository.findAll().forEach(restoran -> {
			restorani.add(new RestoranModel(restoran.getName(), restoran.getDescription(), restoran.getAdress(), restoran.getImgUrl(), restoran.getPhone()));
		});;
		return restorani;
	}
	
	public Restoran getRestoranByName(@RequestParam String restoranName) {
		Restoran restoran =  restoranRepository.findOneByName(restoranName);
		return restoran;
	}
	
	public Restoran getRestoranById(@RequestParam Integer restoranId) {
		Restoran restoran = restoranRepository.findOneByRestoranId(restoranId);
		if(restoran != null) {
			return restoran;
		}
		return null;
	}
	
	public void addRestoran(RestoranModel restoranModel) {
		Restoran restoran = new Restoran(
				null,
				restoranModel.getName(),
				restoranModel.getDescription(),
				restoranModel.getAdress(),
				restoranModel.getImgUrl(),
				restoranModel.getPhone());
		
		restoranRepository.save(restoran);
	}
	
	public void updateRestoran(@RequestParam String restoranName, @RequestParam RestoranModel restoranModel) {
		
		Restoran r = restoranRepository.findOneByName(restoranName);
		
		Restoran restoran = new Restoran(
				r.getRestoranId(),
				restoranModel.getName() == null || restoranModel.getName() == "" ? r.getName() : restoranModel.getName(),
				restoranModel.getDescription() == null || restoranModel.getDescription() == "" ? r.getDescription() : restoranModel.getDescription(),
				restoranModel.getAdress() == null || restoranModel.getAdress() == "" ? r.getAdress() : restoranModel.getAdress(),
				restoranModel.getImgUrl() == null || restoranModel.getImgUrl() == "" ? r.getImgUrl() : restoranModel.getImgUrl(),
				restoranModel.getPhone() == null || restoranModel.getPhone() == "" ? r.getPhone() : restoranModel.getPhone());
		
		restoranRepository.save(restoran);
	}

	public void deleteRestoran(@RequestParam String restoranName) {
		restoranRepository.deleteOneByName(restoranName);
	}
}
