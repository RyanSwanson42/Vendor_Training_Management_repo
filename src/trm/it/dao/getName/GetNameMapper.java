package dao.getName;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.employee.Employee;

public class GetNameMapper implements RowMapper {

	public GetName mapRow(ResultSet result, int arg1) throws SQLException {
		Employee emp = new Employee();
		emp.setLast_name(result.getString("last_name"));
		emp.setFirst_name(result.getString("first_name"));
		
		GetName name = new GetName();
		name.setEmployee(emp);
		return name;
	}

}
