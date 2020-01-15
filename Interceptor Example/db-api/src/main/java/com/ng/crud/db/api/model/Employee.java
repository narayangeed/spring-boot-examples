package com.ng.crud.db.api.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Employee {	

	private Integer employeeId;
	private String name;
	private String gender;
	private Long salary;
	private Address address;
	private List<Department> departments;
}
