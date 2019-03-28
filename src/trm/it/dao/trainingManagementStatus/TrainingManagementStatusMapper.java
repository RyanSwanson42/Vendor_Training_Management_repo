package dao.trainingManagementStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.trainingRequest.TrainingRequest;
import dao.trainingRequest.TrainingRequestMapper;

public class TrainingManagementStatusMapper implements RowMapper<TrainingManagementStatus> {
	/*
	  training_management_status_id number(5) primary key,
	  training_request_id number(5) CONSTRAINT tms_tr_fk references training_request(training_request_id) not null,
	  status number(5) not null
	*/
	
	public TrainingManagementStatus mapRow(ResultSet result, int arg1)
			throws SQLException {
		TrainingManagementStatus tms = new TrainingManagementStatus();
		tms.setTraining_management_id(result.getInt("training_management_status_id"));
		tms.setTraining_request(result.getInt("training_request_id"));
		tms.setStatus(result.getInt("status"));
		return tms;
	}
}
