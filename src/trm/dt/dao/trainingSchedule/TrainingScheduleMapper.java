package trm.dt.dao.trainingSchedule;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingScheduleMapper implements RowMapper<TrainingSchedule>
{
	public TrainingSchedule mapRow(ResultSet result, int arg1)
			throws SQLException {
		TrainingSchedule ts = new TrainingSchedule();
		ts.setTraining_schedule_id(result.getInt("training_schedule_id"));
		ts.setTraining_city(result.getString("training_city"));
		ts.setTraining_state(result.getString("training_state"));
		ts.setTraining_country(result.getString("training_country"));
		ts.setTraining_zipcode(result.getInt("training_zipcode"));
		ts.setTraining_time_zone(result.getString("training_time_zone"));
		ts.setTraining_location(result.getString("training_location"));
		ts.setTraining_room_number(result.getString("training_room_number"));
		ts.setTraining_start_date(result.getString("training_start_date"));
		ts.setTraining_end_date(result.getString("training_end_date"));
		ts.setTraining_break_down(result.getString("training_break_down"));
		ts.setTraining_url(result.getString("training_url"));
		ts.setTraining_phone(result.getString("training_phone"));
		return ts;
	}
}
