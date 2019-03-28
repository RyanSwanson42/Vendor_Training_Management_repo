package trm.dt.trial.DDTProject;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingScheduleMapper implements RowMapper<TrainingSchedule>
{
	public TrainingSchedule mapRow(ResultSet result, int arg1)
			throws SQLException {
		TrainingSchedule ts = new TrainingSchedule();
		ts.setTrainingScheduleId(result.getInt("training_schedule_id"));
		ts.setTrainingCity(result.getString("training_city"));
		ts.setTrainingState(result.getString("training_state"));
		ts.setTrainingCountry(result.getString("training_country"));
		ts.setTrainingZipcode(result.getInt("training_zipcode"));
		ts.setTrainingTimeZone(result.getString("training_time_zone"));
		ts.setTrainingLocation(result.getString("training_location"));
		ts.setTrainingRoomNumber(result.getString("training_room_number"));
		ts.setTrainingStartDate(result.getString("training_start_date"));
		ts.setTrainingEndDate(result.getString("training_end_date"));
		ts.setTrainingBreakDown(result.getString("training_break_down"));
		ts.setTrainingUrl(result.getString("training_url"));
		ts.setTrainingPhone(result.getString("training_phone"));
		return ts;
	}
}
