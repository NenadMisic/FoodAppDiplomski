package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diplomski.entities.HranljivostiZaJelo;

public interface HranljivostiZaJeloRepository extends CrudRepository<HranljivostiZaJelo, Integer> {
	
	public Iterable<HranljivostiZaJelo> findByJeloId(int jeloId);
	
}
