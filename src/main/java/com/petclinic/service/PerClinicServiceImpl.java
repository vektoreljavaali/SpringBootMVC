package com.petclinic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.petclinic.dao.OwnerRepository;
import com.petclinic.exceptions.OwnerNotFountException;
import com.petclinic.model.Owner;

@Service
public class PerClinicServiceImpl implements PerClinicService{

	private OwnerRepository ownerRepository;
	
	
	@Autowired
	public void setOwnerRepository(OwnerRepository ownerRepository) {
		this.ownerRepository = ownerRepository;
	}

	@Override
	public List<Owner> findOwners() {
		return ownerRepository.findAll();
	}

	@Override
	public List<Owner> findOwners(String lastName) {
		return ownerRepository.findByLastName(lastName);
	}

	@Override
	public Owner findOwner(Long id) throws OwnerNotFountException {
		Owner owner = ownerRepository.findById(id);
		if(owner==null) throw new OwnerNotFountException("HATAAAAA.....: "+id);
		return owner;
	}

	@Override
	public void crateOwner(Owner owner) {
		ownerRepository.create(owner);
	}

	@Override
	public void updateOwner(Owner owner) {
		ownerRepository.update(owner);
		
	}

	@Override
	public void deleteOwner(Long id) {
		ownerRepository.delete(id);
	}

}
