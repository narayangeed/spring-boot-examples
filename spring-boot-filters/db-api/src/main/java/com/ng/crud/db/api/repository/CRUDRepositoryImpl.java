package com.ng.crud.db.api.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ng.crud.db.api.model.Address;
import com.ng.crud.db.api.model.Department;
import com.ng.crud.db.api.model.Employee;

@Repository
public class CRUDRepositoryImpl implements CRUDRepository {
	
	private static List<Employee> empSchema = prepareInitialData();

	@Override
	public List<Employee> findByDepartmentName(String depName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Employee> findByCity(String city) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insert(Employee emp) {
		if(empSchema!=null && (!empSchema.contains(emp))) {
			empSchema.add(emp);
		}
	}

	
	@Override
	public void insert(List<Employee> empList) {
		if(empSchema!=null && (!empSchema.contains(empList))) {
			empSchema.addAll(empList);
		}

	}

	@Override
	public void save(Employee emp) {
		if(empSchema!=null) {			
			empSchema.remove(empSchema.indexOf(emp));
			empSchema.add(emp);
		}
	}

	@Override
	public Employee findById(Integer id) {		
		List<Employee> emp = empSchema.stream().filter(f -> f.getEmployeeId()==id).collect(Collectors.toList());			
		return emp.get(0);		
	}
	
	//empSchema.stream().filter(f -> f.getEmployeeId()==id).collect(Collectors.toList())

	@Override
	public List<Employee> findAll() {		
		return empSchema;
	}
	
	private static List<Employee> prepareInitialData(){
		
		List<Employee> empList = new ArrayList<Employee>();
		
		//prepare employee data
		Address addr = new Address("Pune", "MH", "411001", "INDIA");
		List<Department> depList = new ArrayList<>();		
		depList.add(new Department("IT-D", "IT"));
		depList.add(new Department("CS-D", "CS"));
		Employee emp = new Employee(1, "Om Prakash", "M", 10000L, addr, depList);
		empList.add(emp);
		return empList;
	}

}
