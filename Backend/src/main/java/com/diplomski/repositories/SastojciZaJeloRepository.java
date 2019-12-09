package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.diplomski.entities.SastojciZaJelo;

public interface SastojciZaJeloRepository extends CrudRepository<SastojciZaJelo, Integer> {
	
	public Iterable<SastojciZaJelo> findByJeloId(Integer jeloId);
	
	@Transactional
	public void deleteAllByJeloId(Integer jeloId);

}
