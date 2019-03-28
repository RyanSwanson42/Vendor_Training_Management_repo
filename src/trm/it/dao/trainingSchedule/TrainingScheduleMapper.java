package dao.trainingSchedule;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingScheduleMapper implements RowMapper<TrainingSchedule>{
	/*
	  training_schedule_id number(5) primary key,
	  training_city varchar(30),
	  training_state varchar(20),
	  training_country varchar(20),
	  training_zipcode varchar(20),
	  training_time_zone varchar(6),
	  training_location varchar(20),
	  training_room_number varchar(20),
	  training_start_date TIMESTAMP(0),
	  training_end_date TIMESTAMP(0),
	  training_break_down varchar(200),
	  training_url varchar(300),
	  training_phone number(10)
	*/
	public TrainingSchedule mapRow(ResultSet result, int arg1)
			throws SQLException {
		TrainingSchedule ts = new TrainingSchedule();
		ts.setTraining_schedule_id(result.getInt("training_schedule_id"));
		ts.setTraining_city(result.getString("training_city"));
		ts.setTraining_state(result.getString("training_state"));
		ts.setTraining_country(result.getString("training_country"));
		ts.setTraining_zipcode(result.getString("training_zipcode"));
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
