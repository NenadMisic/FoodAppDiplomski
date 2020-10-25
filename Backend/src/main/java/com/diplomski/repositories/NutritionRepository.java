package com.diplomski.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.Nutrition;

public interface NutritionRepository extends CrudRepository<Nutrition, Integer> {
	
	public Nutrition findByHranljivostId(Integer hranljivostId);
	
	@Query(value = "SELECT hvr.hranljivostId FROM Nutrition hvr WHERE hvr.naziv = :name")
	public Integer getIdByName(@Param("name") String name);

}
