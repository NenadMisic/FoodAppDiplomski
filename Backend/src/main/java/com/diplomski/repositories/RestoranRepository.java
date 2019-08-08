package com.diplomski.repositories;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.diplomski.entities.Restoran;

public interface RestoranRepository extends CrudRepository<Restoran, Integer> {
	
	public Restoran findOneByRestoranId(Integer restoranId);
	
	public Restoran findOneByName(String name);
	
	@Transactional
	public void deleteOneByName(String name);
}
