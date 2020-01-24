package com.ng.crud.h2.db.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ng.crud.h2.db.api.dbmodel.Employee;

@Repository
public interface H2DBRepository extends JpaRepository<Employee, Long>{

	//List<Employee> findByDepartmentName(String depName);

	//List<Employee> findByCity(String city);

}
