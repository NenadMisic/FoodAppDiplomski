package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diplomski.entities.HranljivaVrednost;

public interface HranVredRepository extends CrudRepository<HranljivaVrednost, Integer> {
	
	public HranljivaVrednost findByHranljivostId(Integer hranljivostId);

}
