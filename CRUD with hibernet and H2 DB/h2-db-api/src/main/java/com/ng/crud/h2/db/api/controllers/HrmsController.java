package com.ng.crud.h2.db.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ng.crud.h2.db.api.model.Employee;
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
		return hrmsService.saveEmployee(emp);
	}

	@ApiOperation(value = "API to Add bulk Employees", response = ResponseEntity.class)
	@PostMapping("/addEmployees")
	public ResponseEntity<?> saveAllEmployees(@RequestBody final List<Employee> empList) {
		return hrmsService.saveAllEmployees(empList);
	}

	@ApiOperation(value = "API to update single employee", response = ResponseEntity.class)
	@PutMapping("/updateEmployee")
	public ResponseEntity<?> updateEmployee(@RequestBody final Employee emp) {
		return hrmsService.updateEmployee(emp);
	}
	
	@ApiOperation(value = "API to get single Employee", response = ResponseEntity.class)
	@GetMapping("/getEmployeeById/{id}")
	public ResponseEntity<?> getEmployeeById(@PathVariable final Long id) {
		return hrmsService.getEmployeeById(id);
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
		return hrmsService.getAllEmployees();
	}

}
