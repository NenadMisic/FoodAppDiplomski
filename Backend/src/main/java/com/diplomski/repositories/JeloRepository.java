package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diplomski.entities.Jelo;

public interface JeloRepository extends CrudRepository<Jelo, Integer> {
	
	public Iterable<Jelo> findAllByRestoranId(Integer restoranId);
	
	public Jelo findOneByName(String name);

}
