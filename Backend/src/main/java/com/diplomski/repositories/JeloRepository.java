package com.diplomski.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.Jelo;

public interface JeloRepository extends CrudRepository<Jelo, Integer> {
	
	public Iterable<Jelo> findAllByRestoranId(Integer restoranId);
	
	public Jelo findOneByName(String name);
	
	@Query(value = "SELECT j.jeloId FROM Jelo j WHERE j.name =:name and j.restoranId =:restoranId")
	public Integer getJeloIdByName(@Param("name") String name1, @Param("restoranId") Integer restoranId1);

}
