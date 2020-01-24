package com.ng.crud.h2.db.api.repository;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.ng.crud.h2.db.api.dbmodel.Employee;

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
	public Employee findById(Long id) {		
		List<Employee> empList = empSchema.stream().filter(f -> f.getEmployeeId()==id).collect(Collectors.toList());			
		return empList.get(0);		
	}
	

	@Override
	public List<Employee> findAll() {		
		return empSchema;
	}
	
	private static List<Employee> prepareInitialData(){		
		/*List<Employee> empList = new ArrayList<>();		
		//prepare employee data				
		empList.add(new Employee(2L, "Gopal", "M", "abc@gmail.com", 10000L, new Address("Pune", "MH", "411001", "INDIA"), new ArrayList<>(Arrays.asList(new Department("CS", "CD-D"),new Department("IT", "IT-D")))));
		empList.add(new Employee(2L, "Om Prakash", "M", "abc@gmail.com", 10000L, new Address("Bhopal", "MP", "411002", "INDIA"), new ArrayList<>(Arrays.asList(new Department("EC", "EC-D"),new Department("CS", "CS-D")))));
		return empList;*/
		return null;
	}

}
