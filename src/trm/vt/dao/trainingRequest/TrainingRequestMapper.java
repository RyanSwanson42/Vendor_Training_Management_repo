package trm.vt.dao.trainingRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingRequestMapper implements RowMapper<TrainingRequest> {

	
	public TrainingRequest mapRow(ResultSet result, int arg1) throws SQLException {
		TrainingRequest tr = new TrainingRequest();
		tr.setTraining_request_id(result.getInt(1));
		tr.setRequester_id(result.getInt(2));
		tr.setVertical(result.getString(3));
		tr.setRequest_training_type(result.getString(4));
		tr.setRequest_training_module(result.getString(5));
		tr.setRequest_training_module_scope(result.getString(6));
		tr.setRequest_training_mode(result.getString(7));
		tr.setRequest_start_date(result.getString(8));
		tr.setRequest_end_date(result.getString(9));
		tr.setRequest_location(result.getString(10));
		tr.setRequest_time_zone(result.getString(11));
		tr.setRequest_approx_participant(result.getShort(12));
		tr.setRequest_project_spoc(result.getInt(13));
		tr.setTime_requested(result.getString(14));
		tr.setJustification_of_request(result.getString(15));	
		return tr;
	}
}
