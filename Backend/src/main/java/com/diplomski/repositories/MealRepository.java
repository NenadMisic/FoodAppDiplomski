package com.diplomski.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.Meal;

public interface MealRepository extends CrudRepository<Meal, Integer> {
	
	public Iterable<Meal> findAllByRestoranId(Integer restoranId);
	
	public Meal findOneByName(String name);
	
	@Query(value = "SELECT j.jeloId FROM Meal j WHERE j.name =:name and j.restoranId =:restoranId")
	public Integer getJeloIdByName(@Param("name") String name1, @Param("restoranId") Integer restoranId1);

}
