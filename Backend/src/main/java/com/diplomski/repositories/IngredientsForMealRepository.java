package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.diplomski.entities.IngredientsForMeal;

public interface IngredientsForMealRepository extends CrudRepository<IngredientsForMeal, Integer> {
	
	public Iterable<IngredientsForMeal> findByJeloId(Integer jeloId);
	
	@Transactional
	public void deleteAllByJeloId(Integer jeloId);

}
