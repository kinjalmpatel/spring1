package com.example.demo.controller;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFound;
import com.example.demo.model.Employee;
import com.example.demo.model.Experience;
import com.example.demo.repositary.EmployeeRepository;
import com.example.demo.service.ExperienceService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	ExperienceService experienceService;
	
	//get all employees
	@GetMapping("/employees")
	public List<Employee> getAllEmployees(){
		return employeeRepository.findAll();
	}
	//create employee rest api;
	@PostMapping("/employees")
	public Employee createEmployee(@RequestBody  Employee employeeUI) {
		Employee employee = new Employee();
		employee.setFirstName(employeeUI.getFirstName());
		employee.setLastName(employeeUI.getLastName());
		employee.setEmailId(employeeUI.getEmailId());
		employeeRepository.save(employee);
		for(Experience experience : employeeUI.getExperience()) {
		   experience.setEmployees(employee);
		   experienceService.saveExperience(experience);
		}
	return employee;
}
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
		Employee employee = employeeRepository.findById(id)
				.orElseThrow();
		return ResponseEntity.ok(employee);
	}	
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmplopyee(@PathVariable Long id,@RequestBody Employee employeeDetails){
		Employee employee = employeeRepository.findById(id)
				.orElseThrow();
		employee.setFirstName(employeeDetails.getFirstName());
		employee.setLastName(employeeDetails.getLastName());
		employee.setEmailId(employeeDetails.getEmailId());
	//	employeeRepository.save(employee);
		for(Experience experience : employeeDetails.getExperience()) {
		   experience.setEmployees(employee);
		   experienceService.saveExperience(experience);
		}
		Employee updatedEmplopyee=employeeRepository.save(employee);
	return ResponseEntity.ok(updatedEmplopyee);
		
	}
}