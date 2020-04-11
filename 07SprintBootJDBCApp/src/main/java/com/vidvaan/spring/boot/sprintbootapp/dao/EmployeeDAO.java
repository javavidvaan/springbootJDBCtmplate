package com.vidvaan.spring.boot.sprintbootapp.dao;

import java.util.List;

import com.vidvaan.spring.boot.sprintbootapp.domain.Employee;

public interface EmployeeDAO {
	
	List<Employee> get();

	public Employee insert(Employee employee);

	public Employee findById(int eno);

	public void deleteById(int eno);
	
	public int update(Employee employee);
}
