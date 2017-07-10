package be.steformations.java_data.timesheets.mappers;

import org.springframework.jdbc.core.RowMapper;
import be.steformations.laura.java_data.timesheets.entities.EmployeeImpl;
import java.sql.ResultSet;
import java.sql.SQLException;


public class EmployeeRowMapper implements RowMapper<EmployeeImpl>{

	@Override
	public EmployeeImpl mapRow(ResultSet rs, int rownum) throws SQLException {
		EmployeeImpl employee = null;
		Long id = rs.getLong("id");
		String firstname = rs.getString("firstname");
		String name = rs.getString("name");
		String login = rs.getString("login");
		String password = rs.getString("password");
		employee = new EmployeeImpl();
		employee.setId(id);
		employee.setFirstname(firstname);
		employee.setName(name);
		employee.setLogin(login);
		employee.setPassword(password);
		return employee;
	}
}
