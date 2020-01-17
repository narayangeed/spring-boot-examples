package com.ng.crud.h2.db.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ng.crud.h2.db.api.model.Employee;
import com.ng.crud.h2.db.api.repository.H2DBRepository;

@Service
public class HrmsService {
	
	@Autowired
	private H2DBRepository crudRepo;
	
	public ResponseEntity<?> saveEmployee(Employee emp) {		
		crudRepo.save(emp);
		System.out.println("Inserted Object : "+emp.toString());
		return new ResponseEntity<>("Employee saved : "+emp.getEmployeeId(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> saveAllEmployees(List<Employee> empList) {		
		crudRepo.saveAll(empList);
		System.out.println("Inserted Employees are  : ");
		empList.stream().forEach(e -> e.getEmployeeId());
		return new ResponseEntity<>("Employee saved count: "+empList.stream().count(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> updateEmployee(Employee emp) {		
		crudRepo.save(emp);		
		System.out.println("Inserted Object : "+emp.toString());
		return new ResponseEntity<>("Employee updated : "+emp.getEmployeeId(), HttpStatus.OK);
	}
	
	public ResponseEntity<?> getEmployeeById(Long id) {		
		Optional<Employee> emp = crudRepo.findById(id);
		System.out.println("fetched Object : "+emp.toString());
		return ResponseEntity.ok().body(emp);
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
	
	public ResponseEntity<?> getAllEmployees() {		
		List<Employee> emp = crudRepo.findAll();
		System.out.println("fetched Object : "+emp.toString());
		return ResponseEntity.ok().body(emp);
	}

}
