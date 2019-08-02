package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diplomski.entities.SastojciZaJelo;

public interface SastojciZaJeloRepository extends CrudRepository<SastojciZaJelo, Integer> {
	
	public Iterable<SastojciZaJelo> findByJeloId(int jeloId);

}
