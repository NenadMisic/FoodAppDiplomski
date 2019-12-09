package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.diplomski.entities.HranljivostiZaJelo;

public interface HranljivostiZaJeloRepository extends CrudRepository<HranljivostiZaJelo, Integer> {
	
	public Iterable<HranljivostiZaJelo> findByJeloId(Integer jeloId);
	
	@Transactional
	public void deleteAllByJeloId(Integer jeloId);
	
}
