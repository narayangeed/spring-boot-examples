package com.ng.crud.h2.db.api.dbmodel;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "TBL_EMPLOYEES")
public class Employee {
	@Id
	@GeneratedValue
	private Long employeeId;
	private String name;
	private String gender;
	private String email;
	private Long salary;

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="address_id")
	private Address address;
	
	@OneToMany(targetEntity = Department.class, cascade=CascadeType.ALL)
	@JoinColumn(name = "EmpDep_FK", referencedColumnName = "employeeId")
	//@JoinTable(name="employee_department_mapping",joinColumns=@JoinColumn(name="employee_id"),inverseJoinColumns=@JoinColumn(name="department_id"))
	private List<Department> departments;
}
