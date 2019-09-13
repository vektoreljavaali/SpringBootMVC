package com.petclinic.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_owner")
public class Owner {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "petSeqOwner")
	@SequenceGenerator(name = "petSeqOwner",sequenceName = "sq_owner")
	private Long id;
	@Column(name = "first_name")
	private String firtName;
	@Column(name = "last_name")
	private String lastName;
	
	@OneToMany(mappedBy = "owner")
	private Set<Pet> pets = new HashSet<>();
	
	public Set<Pet> getPets() {
		return pets;
	}
	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirtName() {
		return firtName;
	}
	public void setFirtName(String firtName) {
		this.firtName = firtName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "Owner [id=" + id + ", firtName=" + firtName + ", lastName=" + lastName + "]";
	}
	
	
}
