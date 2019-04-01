package trm.it.dao.trainingRequestLog;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.it.dao.trainingRequestLog.TrainingRequestLog;
import trm.it.dao.trainingRequestLog.TrainingRequestLogMapper;

public class TrainingRequestLogDAO {

	ApplicationContext context;
	JdbcTemplate temp;

	public TrainingRequestLogDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<TrainingRequestLog> getAllTrainingRequestLogDetails() {
		String sql = "select * from training_request_log";
		List<TrainingRequestLog> TrainingRequestList = temp.query(sql,
				new TrainingRequestLogMapper());
		return TrainingRequestList;
	}
	
	public void insertTrainingRequestLog(int training_request_id, int status_changed_to, String description){
		String sql = "insert into training_request_log values(training_request_log_id_seq.nextval, ?, ?, "
				+ "(select to_date(CONCAT (to_char(sysdate,'MM-DD-YYYY'), to_char(sysdate,'hh:mi:ss')),'MM-DD-YYYY hh:mi:ss')"
					+ " from dual), ?)";
		temp.update(sql, new Object[]{training_request_id, status_changed_to, description});
	}
	
	public void deleteTrainingRequestLog(int request_log_id){
		
		String sql = "delete from training_request_log where request_log_id = ?";
		
		temp.update(sql, new Object[]{request_log_id});
	}
	
	public void updateTrainingRequestLog(int request_log_id, int training_request_id, int status_changed_to, String status_change_time, String description){
		
		String sql = "update training_request_log set training_request_id = ?, status_changed_to = ?, status_change_time = ?, description = ? where request_log_id = ?";
		
		temp.update(sql, new Object[]{training_request_id, status_changed_to, status_change_time, description, request_log_id});
	}
	
	public TrainingRequestLog getTrainingRequestLog(int request_log_id){
		
		String sql = "select * from training_request_log where request_log_id = ?";
		
		List<TrainingRequestLog> trl = temp.query(sql, new Object[]{request_log_id}, new TrainingRequestLogMapper());
		
		return trl.get(0);
	}
	
	public List<TrainingRequestLog> getTrainingRequestLogByTrainingRequestId(int id){
		String sql = "SELECT * FROM training_request_log WHERE training_request_id = ?";
		List<TrainingRequestLog> trl = temp.query(sql, new Object[]{id}, new TrainingRequestLogMapper());
		return trl;
	}	
}