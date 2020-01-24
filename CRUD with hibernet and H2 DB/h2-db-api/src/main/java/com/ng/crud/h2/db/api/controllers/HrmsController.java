package com.ng.crud.h2.db.api.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ng.crud.h2.db.api.dbmodel.Employee;
import com.ng.crud.h2.db.api.service.HrmsService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/rest")
@Api(value="HRMS DB API", description="HRMS DB API for service")
public class HrmsController {

	@Autowired
	private HrmsService hrmsService;
	
	@ApiOperation(value = "API to Add Single Employee", response = ResponseEntity.class)
	@PostMapping("/addEmployee")
	public ResponseEntity<?> saveEmployee(@RequestBody final Employee emp) {
		Employee savedEmp = hrmsService.saveEmployee(emp);
		return new ResponseEntity<Employee>(savedEmp, new HttpHeaders(), HttpStatus.CREATED);
	}

	@ApiOperation(value = "API to Add bulk Employees", response = ResponseEntity.class)
	@PostMapping("/addEmployees")
	public ResponseEntity<?> saveAllEmployees(@RequestBody final List<Employee> empList) {
		String response = hrmsService.saveAllEmployees(empList);
		return new ResponseEntity<String>(response, new HttpHeaders(), HttpStatus.CREATED);
	}

	@ApiOperation(value = "API to get single Employee", response = ResponseEntity.class)
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable final Long id) {		
		Optional<Employee> optional = hrmsService.getEmployeeById(id);
		if(optional.isPresent()) {
			return new ResponseEntity<Optional<Employee>>(optional, new HttpHeaders(), HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("No data Found ", new HttpHeaders(), HttpStatus.NOT_FOUND);
		}		
	}
	
	@ApiOperation(value = "API to delete single Employee by ID", response = ResponseEntity.class)
	@GetMapping("/deleteEmployeeById/{id}")
	public ResponseEntity<?> deleteEmployeeById(@PathVariable final Long id) {
		String response =  hrmsService.deleteEmployeeById(id);
		return new ResponseEntity<String>(response, new HttpHeaders(), HttpStatus.OK);		
	}
	
	@ApiOperation(value = "API to delete single Employee", response = ResponseEntity.class)
	@GetMapping("/deleteEmployee")
	public ResponseEntity<?> deleteEmployee(@RequestBody final Employee emp) {
		String deletedEmp = hrmsService.deleteEmployee(emp);
		return new ResponseEntity<String>(deletedEmp, new HttpHeaders(), HttpStatus.OK);
	}
	
	/*@ApiOperation(value = "API to get Employee by department name", response = ResponseEntity.class)
	@GetMapping("/getEmployeeByDepartmentName/{depName}")
	public ResponseEntity<?> getEmployeeByDepartmentName(@PathVariable final String depName) {
		return hrmsService.getEmployeeByDepartmentName(depName);
	}

	@ApiOperation(value = "API to get Employee by City name", response = ResponseEntity.class)
	@GetMapping("/getEmployeeByCity/{city}")
	public ResponseEntity<?> getEmployeeByCity(@PathVariable final String city) {
		return hrmsService.getEmployeeByCity(city);
	}*/

	@ApiOperation(value = "API to get All employees", response = ResponseEntity.class)
	@GetMapping("/getAllEmployees")
	public ResponseEntity<?> getAllEmployees() {
		List<Employee> empList = hrmsService.getAllEmployees();
		if(!empList.isEmpty()) {
			return new ResponseEntity<List<Employee>>(empList, new HttpHeaders(), HttpStatus.OK);
		}else {
			return new ResponseEntity<String>("Data not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
		}
				
	}

}
