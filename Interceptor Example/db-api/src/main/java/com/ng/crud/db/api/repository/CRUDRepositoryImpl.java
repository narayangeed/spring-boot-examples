package com.ng.crud.db.api.repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
		List<Employee> empList = empSchema.stream().filter(em -> em.getDepartments().stream().anyMatch(dn -> dn.getName().equalsIgnoreCase(depName))).collect(Collectors.toList());	
		return empList;	
	}

	@Override
	public List<Employee> findByCity(String city) {
		List<Employee> empList = empSchema.stream().filter(em -> (em.getAddress().getCity()).equalsIgnoreCase(city)).collect(Collectors.toList());	
		return empList;
	}

	@Override
	public void insert(Employee emp) {
		if(empSchema!=null && (!empSchema.contains(emp))) {
			empSchema.add(emp);
			Set<Employee> empSet = new HashSet<>(empSchema);
			empSchema.clear();
			empSchema.addAll(empSet);	
		}
	}

	
	@Override
	public void insert(List<Employee> empList) {
		if(empSchema!=null) {
			empSchema.addAll(empList);
			Set<Employee> empSet = new HashSet<>(empSchema);
			empSchema.clear();
			empSchema.addAll(empSet);	
		}

	}

	@Override
	public void save(Employee emp) {
		if(empSchema!=null) {					
			empSchema.add(emp);			
			Set<Employee> empSet = new HashSet<>(empSchema);
			empSchema.clear();
			empSchema.addAll(empSet);			
		}
	}

	@Override
	public Employee findById(Integer id) {		
		List<Employee> empList = empSchema.stream().filter(f -> f.getEmployeeId()==id).collect(Collectors.toList());			
		return empList.get(0);		
	}
	

	@Override
	public List<Employee> findAll() {		
		return empSchema;
	}
	
	private static List<Employee> prepareInitialData(){
		
		List<Employee> empList = new ArrayList<>();
		
		//prepare employee data
		Address addr = new Address("Pune", "MH", "411001", "INDIA");
		List<Department> depList = new ArrayList<>();		
		depList.add(new Department("IT-D", "IT"));
		depList.add(new Department("CS-D", "CS"));
		Employee emp = new Employee(1, "Om Prakash", "M", 10000L, addr, depList);
		empList.add(emp);			
		
		empList.add(new Employee(1, "Om Prakash", "M", 10000L, new Address("Bhopal", "MP", "411002", "INDIA"), new ArrayList<>(Arrays.asList(new Department("EC-D", "IT"),new Department("CS-D", "CS")))));
		
		
		return empList;
	}

}
