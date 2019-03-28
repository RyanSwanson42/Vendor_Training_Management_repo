package trm.dt.dao.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>
{

	public Employee mapRow(ResultSet result, int num) throws SQLException {
		Employee emp = new Employee();
		emp.setEmployee_id(result.getInt("employee_id"));
		emp.setLast_name(result.getString("last_name"));
		emp.setFirst_name(result.getString("first_name"));
		emp.setUser_name(result.getString("user_name"));
		emp.setPassword(result.getString("password"));
		emp.setPhone_number(result.getString("phone_number"));
		emp.setEmail(result.getString("email"));
		emp.setStreet(result.getString("street"));
		emp.setCity(result.getString("city"));
		emp.setState(result.getString("state"));
		emp.setCountry(result.getString("country"));
		emp.setJob_title(result.getString("job_title"));
		emp.setVertical(result.getString("vertical"));
		emp.setProject(result.getString("project"));
		emp.setPid(result.getInt("pid"));
		return emp;
	}

}
