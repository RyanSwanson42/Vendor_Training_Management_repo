package trm.it.dao.employee;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/*
employee_id number(7) primary key,
last_name varchar(20) not null,
first_name varchar(20) not null,
user_name varchar(20) unique not null,
password varchar(20) not null,
phone_number varchar(20) unique not null,
email varchar(40) unique not null,
street varchar(40) not null,
city varchar(40) not null,
state varchar(40) not null,
country varchar(40) not null,
job_title varchar(20) not null,
vertical varchar(10),
project varchar(30),
pid number(5)
	*/
public class EmployeeMapper implements RowMapper<Employee>{
	public Employee mapRow(ResultSet result, int arg1)
			throws SQLException {
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
