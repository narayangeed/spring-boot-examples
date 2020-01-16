package com.ng.crud.db.api.repository;

import java.util.List;

import com.ng.crud.db.api.model.Employee;

public interface CRUDRepository{		
	List<Employee> findByDepartmentName(String depName);	
	List<Employee> findByCity(String city);
	void insert(Employee emp);	
	void insert(List<Employee> empList);
	void save(Employee emp);
	Employee findById(Integer id);
	List<Employee> findAll();
}
