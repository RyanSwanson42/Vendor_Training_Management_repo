package dbo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingScheduleMapper implements RowMapper<TrainingSchedule>{

	@Override
	public TrainingSchedule mapRow(ResultSet rs, int arg1) throws SQLException {
		TrainingSchedule tbuf = new TrainingSchedule();
		tbuf.setTraining_schedule_id(rs.getInt(1));
		tbuf.setTraining_city(rs.getString(2));
		tbuf.setTraining_state(rs.getString(3));
		tbuf.setTraining_country(rs.getString(4));
		tbuf.setTraining_zipcode(rs.getString(5));
		tbuf.setTraining_time_zone(rs.getString(6));
		tbuf.setTraining_location(rs.getString(7));
		tbuf.setTraining_room_number(rs.getString(8));
		tbuf.setTraining_start_date(rs.getDate(9));
		tbuf.setTraining_end_date(rs.getDate(10));
		tbuf.setTraining_break_down(rs.getString(11));
		tbuf.setTraining_url(rs.getString(12));
		tbuf.setTraining_phone(rs.getString(13));
		return tbuf;
	}

}
