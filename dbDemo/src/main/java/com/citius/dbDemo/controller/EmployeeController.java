package com.citius.dbDemo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.citius.dbDemo.model.Employee;
import com.citius.dbDemo.repository.EmployeeRepository;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeRepository employeeRepository;

	@GetMapping("/all")
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@PostMapping("/addEmployee")
	public Employee addNewEmployee(@RequestParam Integer empID, @RequestParam String name, @RequestParam String email) {
		Employee emp = new Employee();
		emp.setEmpID(empID);
		emp.setName(name);
		emp.setEmail(email);
		return employeeRepository.save(emp);

	}

	@DeleteMapping("/delete")
	public void deleteEmployee(@RequestParam Integer empID) {
		employeeRepository.deleteById(empID);
	}
	
	@PutMapping("/update/{id}")
	public void updateEmployee(@PathVariable(value = "id") Integer empId,@RequestBody Employee emp) {
		Optional<Employee> e=employeeRepository.findById(empId);
      if(e.isPresent()) {
    	 e.get().setEmail(emp.getEmail());
    	 e.get().setName(emp.getName());
    	 employeeRepository.save(e.get());
      }
}

}
