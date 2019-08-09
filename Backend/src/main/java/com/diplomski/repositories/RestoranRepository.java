package com.diplomski.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.Restoran;

public interface RestoranRepository extends CrudRepository<Restoran, Integer> {
	
	public Restoran findOneByRestoranId(Integer restoranId);
	
	public Restoran findOneByName(String name);
	
	@Transactional
	public void deleteOneByName(String name);
	
	@Query(value = "SELECT r.restoranId FROM Restoran r WHERE r.name = :name")
	public Integer getRestoranIdByName(@Param("name") String name);
}
