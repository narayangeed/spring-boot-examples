package com.ng.crud.h2.db.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class Address {
	@Id 
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	private String city;
	private String state;
	private String zip;
	private String country;	
}
