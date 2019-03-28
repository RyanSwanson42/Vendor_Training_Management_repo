package trm.vt.dao.trainingManagementStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingManagementStatusMapper implements RowMapper<TrainingManagementStatus>{

	public TrainingManagementStatus mapRow(ResultSet result, int arg1)
			throws SQLException {
		
		TrainingManagementStatus tms = new TrainingManagementStatus();
		
		tms.setTraining_management_stauts_id(result.getInt(1));
		tms.setTraining_request_id(result.getInt(2));
		tms.setStatus(result.getInt(3));
		
		return tms;
	}
}
