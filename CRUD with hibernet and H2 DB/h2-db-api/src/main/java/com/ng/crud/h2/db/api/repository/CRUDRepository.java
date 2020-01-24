package com.ng.crud.h2.db.api.repository;

import java.util.List;

import com.ng.crud.h2.db.api.dbmodel.Employee;

public interface CRUDRepository{		
	List<Employee> findByDepartmentName(String depName);	
	List<Employee> findByCity(String city);
	void insert(Employee emp);	
	void insert(List<Employee> empList);
	void save(Employee emp);
	Employee findById(Long id);
	List<Employee> findAll();
}
