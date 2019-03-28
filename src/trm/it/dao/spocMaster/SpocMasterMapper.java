package dao.spocMaster;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.employee.Employee;
import dao.employee.EmployeeMapper;

public class SpocMasterMapper implements RowMapper<SpocMaster>{
	/*
	  spoc_master_id number(5) primary key,
	  spoc_emp_id number(7) CONSTRAINT spoc_emp_fk references employee(employee_id) not null,
	  spoc_vertical varchar(10)
	*/
	public SpocMaster mapRow(ResultSet result, int arg1)
			throws SQLException {
		SpocMaster sm = new SpocMaster();
		sm.setSpoc_master_id(result.getInt("spoc_master_id"));
		sm.setSpoc_emp_id(result.getInt("spoc_emp_id"));
		sm.setSpoc_vertical(result.getString("spoc_vertical"));
		return sm;
	}
}
