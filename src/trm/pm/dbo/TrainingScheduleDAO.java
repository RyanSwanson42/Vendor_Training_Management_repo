package trm.pm.dbo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingScheduleDAO {
	ApplicationContext context;
	JdbcTemplate temp;

	public TrainingScheduleDAO() {
		context = new ContextTemplate().getContext();
		temp = new ContextTemplate().getJdbctemplate();
	}

	public boolean insertTrainingSchedule(String city, String state, String country, String zipcode, String time_zone, String location, String room_number, Timestamp start_date, Timestamp end_date, String break_down, String url, int phone) {
		String sql = "insert into training_schedule values(training_schedule_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?)";
		int num = temp.update(sql, new Object[]{city, state, country, zipcode, time_zone, location, room_number, start_date, end_date, break_down, url, phone});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteTrainingSchedule(int training_schedule_id) {
		String sql = "delete from training_schedule where training_schedule_id = ?";
		int num = temp.update(sql, new Object[]{training_schedule_id});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public boolean updateTrainingSchedule(int request_log_id, int training_request_id, int status_change, Timestamp status_time, String desc) {
		String sql = "update training_request_log set training_request_id = ?, status_change_to = ? statue_changed_time = ?, description = ? where request_log_id = ?";
		int num = temp.update(sql, new Object[] {training_request_id, status_change, status_time, desc, request_log_id});
		if (num == 1) {
			return true;
		}
		return false;
	}
	

	public List<TrainingSchedule> getAllTrainingSchedule() {
		String sql = "select * from training_schedule";
		return temp.query(sql, new TrainingScheduleMapper());
	}
	
	public List<TrainingSchedule> getTrainingSchedule(int training_schedule_id) {
		String sql = "select * from training_schedule where training_schedule_id= ?";
		List<TrainingSchedule> schedule = temp.query(sql, new Object[]{training_schedule_id}, new TrainingScheduleMapper());
		return schedule;
	}
	
	public List<TrainingSchedule> getTrainingSchedule(int training_request_id, int status) {
		String sql = null;
		if (status < 200) { //internal
			sql = "select s.* from internal_training_request t join training_schedule s on s.training_schedule_id = t.schedule_id where training_request_id= ?";
		}
		else if (status < 300) { //develop
			sql = "select s.* from develop_team_training_request t join training_schedule s on s.training_schedule_id = t.schedule_id where training_request_id= ?";
		}
		else { //vendor group
			sql = "select s.* from vendor_training_request t join training_schedule s on s.training_schedule_id = t.schedule_id where training_request_id= ?";
		}
		List<TrainingSchedule> schedule = temp.query(sql, new Object[]{training_request_id}, new TrainingScheduleMapper());
		if (schedule.isEmpty()){
			schedule.add(new TrainingSchedule());
		}
		return schedule;
	}
}