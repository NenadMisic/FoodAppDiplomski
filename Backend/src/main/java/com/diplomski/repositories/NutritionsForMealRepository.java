package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.diplomski.entities.NutritionsForMeal;

public interface NutritionsForMealRepository extends CrudRepository<NutritionsForMeal, Integer> {
	
	public Iterable<NutritionsForMeal> findByJeloId(Integer jeloId);
	
	@Transactional
	public void deleteAllByJeloId(Integer jeloId);
	
}
