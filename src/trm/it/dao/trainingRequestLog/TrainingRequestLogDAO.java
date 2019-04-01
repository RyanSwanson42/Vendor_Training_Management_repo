package trm.it.dao.trainingRequestLog;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

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
	
	public void insertTrainingRequestLog(int training_request_id, int status_changed_to){
		String description = "";
		switch(status_changed_to){
			case 100:
				description = "Training Request Created.";
				break;
			case 103:
				description = "In Process";
				break;
			case 105:
				description = "Information saved, but still in process";
				break;
			case 110:
				description = "Sent for approval";
				break;
			case 120:
				description = "Response from PM";
			case 121:
				description = "Request denied.";
				break;
			case 122:
				description = "Request Approved.";
				break;
			case 130:
				description = "Sent to Executive";
				break;
			case 131:
				description = "Executive Workflow saved but not finalized";
			case 199:
				description = "Training Finished";
			default:
				description = "Error";
		}
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy/MM/dd HH:mm:ss", Locale.US);
		LocalDateTime datetime = LocalDateTime.now();
		
		String now = formatter.format(datetime);
		System.out.println(now);
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
	
	public TrainingRequestLog getTrainingRequestLogByTrainingRequestId(int id){
        String sql = "SELECT * FROM training_request_log WHERE training_request_id = ?";
        TrainingRequestLog trl = temp.query(sql, new Object[]{id}, new TrainingRequestLogMapper()).get(0);
        return trl;
    }
}
