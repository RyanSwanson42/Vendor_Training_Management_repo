package trm.vt.dao.trainingSchedule;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingScheduleDAO {

	ApplicationContext context;
	JdbcTemplate temp;

	public TrainingScheduleDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<TrainingSchedule> getAllTrainingSchedules(){
		
		String sql = "select * from training_schedule";
		
		List<TrainingSchedule> TrainingScheduleList = temp.query(sql, new TrainingScheduleMapper());
		
		return TrainingScheduleList;
	}
	
	public void insertTrainingSchedule(String training_city, String training_state, String training_country, String training_zipcode, String training_time_zone, String training_location, String training_room_number, String training_start_date, String training_end_date, String training_break_down, String training_url, String training_phone){
		
		String sql = "insert into training_schedule values(training_schedule_id_seq.nextval, ?,?,?,?,?,?,?,?,?,?,?,?)";
		
		temp.update(sql, new Object[]{training_city,training_state,training_country, training_zipcode,training_time_zone,training_location,training_room_number, training_start_date, training_end_date, training_break_down, training_url, training_phone});
	}
	
	public void deleteTrainingSchedule(int training_schedule_id){
		
		String sql = "delete from training_schedule where training_schedule_id = ?";
		
		temp.update(sql, new Object[]{training_schedule_id});
	}
	
	public void updateTrainingSchedule(int training_schedule_id, String training_city, String training_state, String training_country, String training_zipcode, String training_time_zone, String training_location, String training_room_number, String training_start_date, String training_end_date, String training_break_down, String training_url, String training_phone){
		
		String sql = "update training_schedule set training_city = ?, training_state = ?, training_country = ?, training_zipcode = ?, training_time_zone = ?, training_location = ?, training_room_number = ?, training_start_date = ?, training_end_date = ?, training_break_down = ?, training_url = ?, training_phone = ? where training_schedule_id = ?";
		
		temp.update(sql, new Object[]{training_city,training_state,training_country, training_zipcode,training_time_zone,training_location,training_room_number, training_start_date, training_end_date, training_break_down, training_url, training_phone,training_schedule_id});
	}
	
	public TrainingSchedule getTrainingSchedule(int training_schedule_id){
		
		String sql = "select * from training_schedule where training_schedule_id = ?";
		
		List<TrainingSchedule> ts = temp.query(sql, new Object[]{training_schedule_id}, new TrainingScheduleMapper());
		
		return ts.get(0);
	}
	
	public int insertStartDateAndEndDate(Timestamp startDate, Timestamp endDate) {
		
		String sql  = "insert into training_schedule(training_schedule_id, training_start_date, training_end_date) values (training_schedule_id_seq.nextval, ?, ?)";
		
		temp.update(sql, new Object[] {startDate,endDate});
		
		int scheduleId = temp.queryForInt("select max(training_schedule_id) from training_schedule");
		
		return scheduleId;
	}
	
	// Initial insert into training schedule -> Returning int of the schedule_id to store properly
	public int insertStartDateAndEndDate(String startDate, String endDate) {
		
		String sql  = "insert into training_schedule(training_schedule_id, training_start_date, training_end_date) values (training_schedule_id_seq.nextval, ?, ?)";
	
		
		temp.update(sql, new Object[] {startDate,endDate});
		
		int scheduleId = temp.queryForInt("select max(training_schedule_id) from training_schedule;");
		
		return scheduleId;
	}
	// Get Only Start date and End date
	public TrainingSchedule getStartDateAndEndDate(int vendor_training_request_id) {
		
		String sql = "select * from training_schedule where training_schedule_id = ?";
		
		List<TrainingSchedule> dates = temp.query(sql, new Object[] {getTrainingScheduleID(vendor_training_request_id)}, new TrainingScheduleMapper());
		
		return dates.get(0);
	}
	// Get the schedule ID -> To be used by all functions that require training_schedule_id
	public int getTrainingScheduleID(int vendor_training_request_id) {
		
		String sql = "select training_schedule_id from training_schedule ts\r\n" + 
				"inner join vendor_training_request vtr\r\n" + 
				"on ts.TRAINING_SCHEDULE_ID = vtr.SCHEDULE_ID\r\n" + 
				"where vtr.VENDOR_TRAINING_REQUEST_ID = ?";
		
		int scheduleId = temp.queryForInt(sql, new Object[] {vendor_training_request_id});
		
		return scheduleId;
	}
	
	public void updateTrainingUrlAndPhone(String training_url, String training_phone, int vendor_training_request_id) {
		
		String sql = "update training_schedule set training_url = ?, training_phone = ? where training_schedule_id = ?";
		
		temp.update(sql, new Object[] {training_url, training_phone,getTrainingScheduleID(vendor_training_request_id)});
		
	}
	
	public void getTrainingURLandPhone(int vendor_training_request_id) {
		
		String sql = "select training_url, training_phone from training_schedule where training_schedule_id = ?";
		
		temp.update(sql, new Object[] {getTrainingScheduleID(vendor_training_request_id)});
	}
	
	
	public void updateAllOtherFields(String training_city, String training_state, String training_country, String training_zipcode, String training_time_zone, String training_location, String training_room_number, String training_break_down, int vendor_training_request_id) {
		
		String sql = "update training_schedule set training_city = ?, training_state = ?, training_country = ?, training_zipcode = ?, training_time_zone = ?, training_location = ?, training_room_number = ?, training_break_down = ? where training_schedule_id = ?";
		
		temp.update(sql, new Object[] {training_city, training_state, training_country, training_zipcode, training_time_zone, training_location, training_room_number, training_break_down, getTrainingScheduleID(vendor_training_request_id)});
	}
	
	public void getAllOtherFields(int vendor_training_request_id) {
		
		String sql = "select training_city, training_state, training_country, training_zipcode, training_time_zone, training_location, training_room_number, training_break_down from training_schedule where training_schedule_id = ?";
		
		temp.update(sql, new Object[] {getTrainingScheduleID(vendor_training_request_id)});
	}
}
