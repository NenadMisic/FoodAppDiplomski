package com.diplomski.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.diplomski.entities.Restaurant;

public interface RestaurantRepository extends CrudRepository<Restaurant, Integer> {
	
	public Restaurant findOneByRestoranId(Integer restoranId);
	
	public Restaurant findOneByName(String name);
	
	@Transactional
	public void deleteOneByName(String name);
	
	@Query(value = "SELECT r.restoranId FROM Restaurant r WHERE r.name = :name")
	public Integer getRestoranIdByName(@Param("name") String name);
}
