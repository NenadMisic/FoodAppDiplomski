package com.diplomski.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.Jelo;

public interface JeloRepository extends CrudRepository<Jelo, Integer> {
	
	public Iterable<Jelo> findAllByRestoranId(Integer restoranId);
	
	public Jelo findOneByName(String name);
	
	@Query(value = "SELECT j.restoranId FROM Jelo j WHERE j.name = :name")
	public Integer getJeloIdByName(@Param("name") String name);

}
