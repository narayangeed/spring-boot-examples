package com.ng.crud.db.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Address {	
	private String city;
	private String state;
	private String zip;
	private String country;
}
