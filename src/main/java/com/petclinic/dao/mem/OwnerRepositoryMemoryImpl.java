package com.petclinic.dao.mem;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.petclinic.dao.OwnerRepository;
import com.petclinic.model.Owner;

@Repository
public class OwnerRepositoryMemoryImpl implements OwnerRepository {

	private Map<Long,Owner> ownerMap = new HashMap<>(); 
	
	public OwnerRepositoryMemoryImpl() {
	
		Owner owner1 = new Owner();
		owner1.setFirtName("Muhammet");
		owner1.setLastName("KAYA");
		owner1.setId(1L);
		
		Owner owner2 = new Owner();
		owner2.setFirtName("Veli");
		owner2.setLastName("BAŞ");
		owner2.setId(2L);
		
		ownerMap.put(owner1.getId(),owner1);
		ownerMap.put(owner2.getId(),owner2);
		
		
	}
	
	@Override
	public List<Owner> findAll() {
		return new ArrayList<>(ownerMap.values());
	}

	@Override
	public Owner findById(long id) {
		return ownerMap.get(id);
	}

	@Override
	public List<Owner> findByLastName(String lastName) {
		return ownerMap.values().stream().filter(x-> x.getLastName().equals(lastName)).collect(Collectors.toList());
	}

	@Override
	public void create(Owner owner) {
		owner.setId(new Date().getTime());
		ownerMap.put(owner.getId(), owner);
	}

	@Override
	public Owner update(Owner owner) {
		ownerMap.replace(owner.getId(), owner);
		return owner;
	}

	@Override
	public void delete(Long id) {
		ownerMap.remove(id);
	}

}
