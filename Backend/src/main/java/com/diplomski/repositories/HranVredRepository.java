package com.diplomski.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.HranljivaVrednost;

public interface HranVredRepository extends CrudRepository<HranljivaVrednost, Integer> {
	
	public HranljivaVrednost findByHranljivostId(Integer hranljivostId);
	
	@Query(value = "SELECT hvr.hranljivostId FROM HranljivaVrednost hvr WHERE hvr.naziv = :name")
	public Integer getIdByName(@Param("name") String name);

}
