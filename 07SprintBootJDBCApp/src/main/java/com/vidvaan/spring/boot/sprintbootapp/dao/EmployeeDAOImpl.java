package com.vidvaan.spring.boot.sprintbootapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.vidvaan.spring.boot.sprintbootapp.domain.Employee;


@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

	private static final String FIND_EMP_BY_ENO = "select * from empl WHERE ENO =?";
	private static final String INSERT_EMPL = "INSERT INTO EMPL(ENO,ENAME,SALARY) VALUES (EMPL_SEQ.NEXTVAL, :name, :salary)";
	private static final String DELETE_BY_ID = "DELETE FROM EMPL WHERE ENO = ?";
	private static final String FIND_ALL = "SELECT * FROM EMPL";
	private static final String UPDATE_BY_ID = "UPDATE EMPL SET ENAME=?,SALARY=? WHERE ENO = ?";
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Override
	public Employee insert(Employee employee) {
		KeyHolder keyHolder = new GeneratedKeyHolder();

		MapSqlParameterSource parameters = new MapSqlParameterSource();
		parameters.addValue("name", employee.getName());
		parameters.addValue("salary", employee.getSalary());
		namedParameterJdbcTemplate.update(INSERT_EMPL, parameters, keyHolder, new String[] { "ENO" });
		int generatedId = keyHolder.getKey().intValue();
		employee.setEno(generatedId);
		return employee;
	}

	public Employee findById(int eno) {

		List<Employee> list = jdbcTemplate.query(FIND_EMP_BY_ENO, new Object[] { eno }, (rs, i) -> {
			Employee employee = new Employee();
			employee.setEno(rs.getInt("ENO"));
			employee.setName(rs.getString("ENAME"));
			employee.setSalary(rs.getDouble("SALARY"));
			return employee;
		});

		Optional<Employee> findFirst = list.stream().findFirst();
		if (findFirst.isPresent()) {
			return findFirst.get();
		}

		return null;

	}

	@Override
	public void deleteById(int eno) {
		jdbcTemplate.update(DELETE_BY_ID, new Object[] { eno });

	}

	@Override
	public List<Employee> get() {

		List<Employee> list = jdbcTemplate.query(FIND_ALL, (rs, i) -> {
			Employee employee = new Employee();
			employee.setEno(rs.getInt("ENO"));
			employee.setName(rs.getString("ENAME"));
			employee.setSalary(rs.getDouble("SALARY"));
			return employee;
		});
		return list;

	}

@Override
public int update(Employee employee) {
	return jdbcTemplate.update(UPDATE_BY_ID,employee.getName(),employee.getSalary(),employee.getEno());
	
}
}
