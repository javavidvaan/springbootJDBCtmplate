package com.vidvaan.spring.boot.sprintbootapp.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vidvaan.spring.boot.sprintbootapp.domain.Employee;
import com.vidvaan.spring.boot.sprintbootapp.domain.EmployeeNotFoundException;
import com.vidvaan.spring.boot.sprintbootapp.service.EmployeeService;


@RestController
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger logger = LogManager.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/find/{eno}")
	public Employee find(@PathVariable(name = "eno") Integer eno) {
		logger.info("Find by eno :{}", eno);
		if(eno == null) {
			throw new RuntimeException("Employee not found for the Id:"+eno);
//			throw new EmployeeNotFoundException();
		
	}
		return employeeService.findById(eno);
	}

	@DeleteMapping("/deleteById/{eno}")
	public void deleteById(@PathVariable int eno) {
		employeeService.deleteById(eno);

	}

	@PutMapping("/update")
	public int update(@RequestBody Employee employee) {
		return employeeService.update(employee);
	     
	}

	@PostMapping("/save")
	public Employee insert(@RequestBody Employee employee) {
		return employeeService.insert(employee);
	}

	@GetMapping("/findAll")
	public List<Employee> get() {
		return employeeService.get();

	}
	@GetMapping("/find/{ename}/{salary}")
	public List<Employee> findByNameAndSalary(@PathVariable(name = "ename,salary") String name,double salary) {
		logger.info("Find by eno :{}", name);
		if(name == null) {
			throw new RuntimeException("Employee not found for the name:"+name);
//			throw new EmployeeNotFoundException();
		
	}
		return employeeService.findByNameAndSalary(name, salary);
}}