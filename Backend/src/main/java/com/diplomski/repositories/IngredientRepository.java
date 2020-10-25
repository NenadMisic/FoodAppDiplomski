package com.diplomski.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Integer> {
	
	public Ingredient findOneBySastojakId(Integer sastojakId);
	
	@Query(value = "SELECT s.sastojakId FROM Ingredient s WHERE s.name = :name")
	public Integer getIdByName(@Param("name") String name);

}
