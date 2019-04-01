package trm.it.dao.trainingRequestLog;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingRequestLogMapper implements RowMapper<TrainingRequestLog>{
	/*
	  request_log_id varchar(10) primary key,
	  training_request_id number(5) CONSTRAINT tlg_tr_fk references training_request(training_request_id) not null,
	  status_changed_to number(5),
	  status_change_time TIMESTAMP(0) not null,
	  description varchar(200)
	*/

	public TrainingRequestLog mapRow(ResultSet result, int arg1)
			throws SQLException {
		TrainingRequestLog trl = new TrainingRequestLog();
		trl.setRequest_log_id(result.getInt("request_log_id"));
		trl.setTraining_request(result.getInt("training_request_id"));
		trl.setStatus_changed_to(result.getInt("status_changed_to"));
		trl.setStatus_changed_time(result.getString("status_change_time"));
		trl.setDescription(result.getString("description"));
		
		return trl;
	}
}