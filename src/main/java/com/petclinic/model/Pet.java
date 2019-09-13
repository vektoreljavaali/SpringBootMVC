package com.petclinic.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_pet")
public class Pet {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "petSeqPet")
	@SequenceGenerator(name = "petSeqPet",sequenceName = "sq_pet")
	private Long id;
	@Column(name = "name")
	private String name;
	@Column(name = "birt_date")
	private Date birtDate;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private Owner owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirtDate() {
		return birtDate;
	}

	public void setBirtDate(Date birtDate) {
		this.birtDate = birtDate;
	}

	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}

	@Override
	public String toString() {
		return "Pet [id=" + id + ", name=" + name + ", birtDate=" + birtDate + "]";
	}
	
	
}
