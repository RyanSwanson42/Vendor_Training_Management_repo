package trm.pm.dbo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class EmployeeMapper implements RowMapper<Employee>{

	@Override
	public Employee mapRow(ResultSet rs, int arg1) throws SQLException {
		Employee ebuf = new Employee();

		ebuf.setEmployee_id(rs.getInt(1));
		ebuf.setLast_name(rs.getString(2));
		ebuf.setFirst_name(rs.getString(3));
		ebuf.setUser_name(rs.getString(4));
		ebuf.setPassword(rs.getString(5));
		ebuf.setPhone_number(rs.getString(6));
		ebuf.setEmail(rs.getString(7));
		ebuf.setStreet(rs.getString(8));
		ebuf.setCity(rs.getString(9));
		ebuf.setState(rs.getString(10));
		ebuf.setCountry(rs.getString(11));
		ebuf.setJob_title(rs.getString(12));
		ebuf.setVertical(rs.getString(13));
		ebuf.setProject(rs.getString(14));
		ebuf.setPid(rs.getInt(15));
		return ebuf;
	}
}