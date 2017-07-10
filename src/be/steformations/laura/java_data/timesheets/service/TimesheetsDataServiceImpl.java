package be.steformations.laura.java_data.timesheets.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import be.steformations.java_data.timesheets.entities.Employee;
import be.steformations.java_data.timesheets.entities.Prestation;
import be.steformations.java_data.timesheets.entities.Project;
import be.steformations.java_data.timesheets.service.TimesheetsDataService;
import be.steformations.laura.java_data.timesheets.entities.EmployeeImpl;

public class TimesheetsDataServiceImpl implements TimesheetsDataService {

	JdbcTemplate jdbcTemplate;
	
	public TimesheetsDataServiceImpl() {
		super();
		DataSource dataSource = new DriverManagerDataSource("jdbc:postgresql://localhost:5432/timesheet", "postgres", "postgres");
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public List<? extends Employee> findAllEmployees() {
	/*	List<EmployeeImpl> liste = null;
		String sql = "select id, firstname, name from employee";
		liste = this.jdbcTemplate.query(sql, new EmployeeRowMapper());*/
		return null;
	}

	@Override
	public Employee findOneEmployeeById(long id) {
		EmployeeImpl employee = null;
		String sql = "select id, firstname, name, login, password into employee where id = ?";
		if (id > 0){
			try {
				Map<String, Object> map = this.jdbcTemplate.queryForMap(sql, id);
				if (! map.isEmpty()){
					Long idE = (Long) map.get("id");
					String firstnameE = (String) map.get("firstname");
					String nameE = (String) map.get("name");
					String loginE = (String) map.get("login");
					String passwordE = (String) map.get("password");
					employee = new EmployeeImpl();
					employee.setId(idE);
					employee.setFirstname(firstnameE);
					employee.setName(nameE);
					employee.setLogin(loginE);
					employee.setPassword(passwordE);
				}
			} catch(EmptyResultDataAccessException e){
			}
		}
		
		return employee;
	}

	@Override
	public Employee findOneEmployeeByFirstnameAndName(String firstname, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employee findOneEmployeeByLoginAndPassword(String login, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Project> findAllProjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findOneProjectById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Project findOneProjectByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prestation findOnePrestationById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Prestation> findAllPrestationsByEmployeeId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<? extends Prestation> findAllPrestationsByProjectId(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prestation addPrestation(long employeeId, long projectId, String comment, Date day, int duration) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Prestation deletePrestation(long id) {
		// TODO Auto-generated method stub
		return null;
	}

}
