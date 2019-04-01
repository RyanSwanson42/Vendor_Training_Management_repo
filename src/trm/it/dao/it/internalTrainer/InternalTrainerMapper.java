package trm.it.dao.it.internalTrainer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import trm.it.dao.employee.Employee;
/*
it_trainer_id number(7) CONSTRAINT it_trainer_fk references employee(employee_id) unique not null,
profile_file_path varchar(100),
trainer_location varchar(20)
*/
public class InternalTrainerMapper implements RowMapper<InternalTrainer>{
	public InternalTrainer mapRow(ResultSet result, int arg1)
			throws SQLException {
		InternalTrainer it = new InternalTrainer();
		it.setInternal_trainer_id(result.getInt("it_trainer_id"));		
		it.setProfile_file_path(result.getString("profile_path_id"));
		it.setTrainer_location(result.getString("trainer_location"));
		return it;
	}
}
