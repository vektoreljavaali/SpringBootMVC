package com.petclinic.web;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.petclinic.exceptions.OwnerNotFountException;
import com.petclinic.model.Owner;

import com.petclinic.service.PerClinicService;

@RestController
@RequestMapping("/rest")
public class PetClinicRestController {

	@Autowired
	private PerClinicService perClinicService;
	
	@RequestMapping(method = RequestMethod.GET,value = "/owners")
	public ResponseEntity<List<Owner>> getOwners(){
		List<Owner> owners = perClinicService.findOwners();
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/ekle")
	public String eklemeYap() {
		Owner owner = new Owner();
		owner.setFirtName("Muhammet");
		owner.setLastName("HOCA");
		perClinicService.crateOwner(owner);
		Owner owner1 = new Owner();
		owner1.setFirtName("Ayşe");
		owner1.setLastName("HOCA");
		perClinicService.crateOwner(owner1);
		
		
		return "OK";
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/owner")
	public ResponseEntity<List<Owner>> getOwners(@RequestParam("ln") String lastName){
		List<Owner> owners = perClinicService.findOwners(lastName);
		return ResponseEntity.ok(owners);
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/owner/{id}")
	public ResponseEntity<Owner> getOwners(@PathVariable("id") Long id){
		try {
			Owner owner = perClinicService.findOwner(id);
			return ResponseEntity.ok(owner);
		}catch (OwnerNotFountException ex) {
			return ResponseEntity.notFound().build();
		}
	}
	
	
	
}
