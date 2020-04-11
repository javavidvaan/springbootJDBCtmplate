package com.vidvaan.spring.boot.sprintbootapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.vidvaan.spring.boot.sprintbootapp.dao.EmployeeDAO;
import com.vidvaan.spring.boot.sprintbootapp.domain.Employee;

@SpringBootTest
class SprintbootappApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(SprintbootappApplicationTests.class);

	@Autowired
	private EmployeeDAO employeeDAO;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Test
	@Transactional
	@Rollback
	void testFindById() {
		Employee employee = new Employee();
		employee.setName("SRAVAN");
		employee.setSalary(80000.0);
		Employee insertedEmployee = employeeDAO.insert(employee);

		Employee e = employeeDAO.findById(insertedEmployee.getEno());
		assertNotNull(e);
		assertEquals(e.getName(), "SRAVAN");
		assertEquals(e.getSalary(), 80000.0);
	}

	@Test
	@Transactional
	@Rollback
	void testInsert() {

		Employee employee = new Employee();
		employee.setName("Raju");
		employee.setSalary(88888);
		Employee insertedEmployee = employeeDAO.insert(employee);
		logger.info("Employee created with eno : {} on date : {}" , insertedEmployee.getEno(), new Date());
		assertTrue(insertedEmployee.getEno() != 0);
	}
	
	@Test
	@Transactional
	@Rollback
	void testDeleteById() {

		Employee employee = new Employee();
		employee.setName("Raju");
		employee.setSalary(88888);
		Employee insertedEmployee = employeeDAO.insert(employee);
		
		employeeDAO.deleteById(insertedEmployee.getEno());
		
		Employee e = employeeDAO.findById(insertedEmployee.getEno());
		//assertNull(e);
	
		
	}

}
