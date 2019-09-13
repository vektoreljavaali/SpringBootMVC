package com.petclinic.service;

import java.util.List;

import com.petclinic.exceptions.OwnerNotFountException;
import com.petclinic.model.Owner;

public interface PerClinicService {

	List<Owner> findOwners();
	List<Owner> findOwners(String lastName);
	Owner findOwner(Long id) throws OwnerNotFountException;
	void crateOwner(Owner owner);
	void updateOwner(Owner owner);
	void deleteOwner(Long id);
	
}
