package com.petclinic.dao;

import java.util.List;


import com.petclinic.model.Pet;

public interface PetRepository {

	List<Pet> findAll();
	Pet findById(long id);
	List<Pet> findByOwnerId(Long ownerId);
	void create(Pet pet);
	Pet update(Pet pet);
	void delete(Long id);
	void deleteByOwnerId(Long ownerId);
	
}
