package com.diplomski.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.Sastojak;

public interface SastojakRepository extends CrudRepository<Sastojak, Integer> {
	
	public Sastojak findOneBySastojakId(Integer sastojakId);
	
	@Query(value = "SELECT s.sastojakId FROM Sastojak s WHERE s.name = :name")
	public Integer getIdByName(@Param("name") String name);

}
