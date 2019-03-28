package dao.trainingSchedule;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.trainingSchedule.TrainingSchedule;
import dao.trainingSchedule.TrainingScheduleMapper;

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
	
	public int insertTrainingSchedule(String training_city, String training_state, String training_country, String training_zipcode, String training_time_zone, String training_location, String training_room_number, String training_start_date, String training_end_date, String training_break_down, String training_url, String training_phone) {		
		int schedule_id = temp.queryForInt("SELECT accseq.nextval from dual");
		String date = "2020/02/07 21:02:44";
		String sql = "insert into TRAINING_SCHEDULE values(training_schedule_id_seq.nextval, 'Boston', 'MA', 'US', '02101', 'EST', '542 Main St', 'R210', TO_DATE(?, 'yyyy/mm/dd hh24:mi:ss'), TO_DATE('2019/03/31 21:02:44', 'yyyy/mm/dd hh24:mi:ss'),'BreakDown', 'URL', '1234567890')";
		//temp.update(sql, new Object[]{schedule_id, training_city,training_state,training_country, training_zipcode,training_time_zone,training_location,training_room_number, training_start_date, training_end_date, training_break_down, training_url, training_phone});
		int ret = temp.update(sql, new Object[]{date});
		System.out.println(ret + "String");
		return schedule_id;
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
	public TrainingSchedule getTrainingScheduleByInternalTrainingRequest(int training_schedule_id){
		
		String sql = "SELECT s.* FROM training_schedule s JOIN internal_training_request it ON it.schedule_id = s.training_schedule_id WHERE it.schedule_id = ?";
		List<TrainingSchedule> ts = temp.query(sql, new Object[]{training_schedule_id}, new TrainingScheduleMapper());
		
		return ts.get(0);
	}

}
