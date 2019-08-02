package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diplomski.entities.Sastojak;

public interface SastojakRepository extends CrudRepository<Sastojak, Integer> {
	
	public Sastojak findOneBySastojakId(Integer sastojakId);

}
