package com.ng.crud.h2.db.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ng.crud.h2.db.api.dbmodel.Employee;
import com.ng.crud.h2.db.api.repository.H2DBRepository;

@Service
public class HrmsService {
	
	@Autowired
	private H2DBRepository crudRepo;
	
	public Employee saveEmployee(Employee emp) {		
		Employee savedEmp = crudRepo.save(emp);
		System.out.println("Inserted Object : "+savedEmp.toString());
		return savedEmp;
	}
	
	public String saveAllEmployees(List<Employee> empList) {		
		crudRepo.saveAll(empList);
		System.out.println("Inserted Employees are  : ");
		empList.stream().forEach(e -> e.getEmployeeId());
		return "Employee saved count: "+empList.stream().count();
	}	
	
	public Optional<Employee> getEmployeeById(Long id) {		
		Optional<Employee> optional = crudRepo.findById(id);
		return optional;
	}
	
	public String deleteEmployeeById(Long id) {		
		crudRepo.deleteById(id);
		System.out.println("deleted Object : "+id);
		return "Record deleted : "+id;
	}
	
	public String deleteEmployee(Employee emp) {		
		crudRepo.delete(emp);
		System.out.println("deleted Object : "+emp.getEmployeeId());
		return "Record deleted : "+emp.getEmployeeId();
	}
	
	
	/*public ResponseEntity<?> getEmployeeByDepartmentName(String depName) {	
		System.out.println("Dep Name  -->"+depName);
		List<Employee> empList = crudRepo.findByDepartmentName(depName);
		System.out.println("fetched Object : "+empList.stream().count());
		return ResponseEntity.ok().body(empList);
	}
	
	public ResponseEntity<?> getEmployeeByCity(String city) {	
		System.out.println("City -->"+city);
		List<Employee> empList = crudRepo.findByCity(city);
		System.out.println("fetched Object : "+empList.stream().count());
		return ResponseEntity.ok().body(empList);
	}*/
	
	public List<Employee> getAllEmployees() {		
		List<Employee> empList = crudRepo.findAll();
		System.out.println("fetched Object : "+empList.toString());
		return empList;
	}

}
