package trm.pm.dbo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import org.springframework.jdbc.core.RowMapper;

public class TrainingRequestMapper implements RowMapper<TrainingRequest> {

	@Override
	public TrainingRequest mapRow(ResultSet rs, int arg1) throws SQLException {
		TrainingRequest tbuf = new TrainingRequest();

		tbuf.setTraining_request_id(rs.getInt(1));
		tbuf.setRequester_id(rs.getInt(2));
		tbuf.setVertical(rs.getString(3));
		tbuf.setRequest_training_type(rs.getString(4));
		tbuf.setRequest_training_module(rs.getString(5));
		tbuf.setRequest_training_module_scope(rs.getString(6));
		tbuf.setRequest_training_mode(rs.getString(7));
		tbuf.setRequest_start_date(rs.getTimestamp(8));
		tbuf.setRequest_end_date(rs.getTimestamp(9));
		tbuf.setRequest_location(rs.getString(10));
		tbuf.setRequest_time_zone(rs.getString(11));
		tbuf.setRequest_approx_participant(rs.getInt(12));
		tbuf.setRequest_project_spoc(rs.getInt(13));
		tbuf.setTime_requested(rs.getTimestamp(14));
		tbuf.setJustification_of_request(rs.getString(15));
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		tbuf.setStart_date(sdf.format(tbuf.getRequest_start_date()));
		tbuf.setEnd_date(sdf.format(tbuf.getRequest_end_date()));
		tbuf.setDate_requested(sdf.format(tbuf.getTime_requested()));
		
		return tbuf;
	}
}