package trm.it.dao.trainingParticipant;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.it.dao.employee.Employee;
import trm.it.dao.employee.EmployeeMapper;
import trm.it.dao.trainingRequest.TrainingRequest;
import trm.it.dao.trainingRequest.TrainingRequestMapper;

public class TrainingParticipantMapper implements RowMapper<TrainingParticipant>{
	/*
	training_participant_id number(5) primary key,
	participant_employee_id number(7) CONSTRAINT tp_participant_fk references employee(employee_id) not null,
	training_session_attended number(5) CONSTRAINT tp_tr_fk references training_request(training_request_id) not null
*/

	public TrainingParticipant mapRow(ResultSet result, int arg1)
			throws SQLException {
		TrainingParticipant tp = new TrainingParticipant();
		tp.setTraining_participant_id(result.getInt("training_participant_id"));
		tp.setEmpId(result.getInt("participant_employee_id"));
		TrainingRequest tr = new TrainingRequestMapper().mapRow(result, arg1);
		tp.setTraining_session_attended(result.getInt("training_session_attended"));
		return tp;
	}
}
