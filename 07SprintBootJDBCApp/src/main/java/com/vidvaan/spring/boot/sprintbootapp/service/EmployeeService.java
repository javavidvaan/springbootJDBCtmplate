package com.vidvaan.spring.boot.sprintbootapp.service;

import java.util.List;

import com.vidvaan.spring.boot.sprintbootapp.domain.Employee;

public interface EmployeeService {
	List<Employee> get();
	
	public Employee insert(Employee employee);

	public Employee findById(int eno);

	public void deleteById(int eno);
	
	public int update(Employee employee);
	
	List<Employee> findByNameAndSalary(String name, double salary);
}
