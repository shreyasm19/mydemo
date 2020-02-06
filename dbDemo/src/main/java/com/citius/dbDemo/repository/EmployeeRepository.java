package com.citius.dbDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.citius.dbDemo.model.Employee;

@Repository 
public interface EmployeeRepository extends JpaRepository<Employee, Object> {

}
