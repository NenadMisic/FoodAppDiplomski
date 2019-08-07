package com.diplomski.repositories;

import org.springframework.data.repository.CrudRepository;

import com.diplomski.entities.User;

public interface UserRepository extends CrudRepository<User, Integer> {

	public User findOneByUsername(String username);
	
}
