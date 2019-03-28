package trm.vt.dao.trainingSchedule;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingScheduleMapper implements RowMapper<TrainingSchedule>{

	public TrainingSchedule mapRow(ResultSet result, int arg1)
			throws SQLException {
		
		TrainingSchedule ts = new TrainingSchedule();
		
		ts.setTraining_schedule_id(result.getInt(1));
		ts.setTraining_city(result.getString(2));
		ts.setTraining_state(result.getString(3));
		ts.setTraining_country(result.getString(4));
		ts.setTraining_zipcode(result.getString(5));
		ts.setTraining_time_zone(result.getString(6));
		ts.setTraining_location(result.getString(7));
		ts.setTraining_room_number(result.getString(8));
		ts.setTraining_start_date(result.getString(9));
		ts.setTraining_end_date(result.getString(10));
		ts.setTraining_break_down(result.getString(11));
		ts.setTraining_url(result.getString(12));
		ts.setTraining_phone(result.getString(13));
		
		return ts;
	}	
}
