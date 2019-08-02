package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diplomski.entities.Restoran;

public interface RestoranRepository extends CrudRepository<Restoran, Integer> {
	
	public Restoran findOneByRestoranId(Integer restoranId);
	
	public Restoran findOneByName(String name);

}
