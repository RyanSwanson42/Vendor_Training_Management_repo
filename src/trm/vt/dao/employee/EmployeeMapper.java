package trm.vt.dao.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee> {

	
	public Employee mapRow(ResultSet result, int arg1) throws SQLException {
		Employee employee = new Employee();
		employee.setEmployee_id(result.getInt(1));
		employee.setLast_name(result.getString(2));
		employee.setFirst_name(result.getString(3));
		employee.setUser_name(result.getString(4));
		employee.setPassword(result.getString(5));
		employee.setPhone_number(result.getString(6));
		employee.setEmail(result.getString(7));
		employee.setStreet(result.getString(8));
		employee.setCity(result.getString(9));
		employee.setState(result.getString(10));
		employee.setCountry(result.getString(11));
		employee.setJob_title(result.getString(12));
		employee.setVertical(result.getString(13));
		employee.setProject(result.getString(14));
		employee.setPid(result.getInt(15));
		return employee;
	}
	
}

