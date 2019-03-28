package trm.pm.dbo;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingRequestLogDAO {
	ApplicationContext context;
	JdbcTemplate temp;

	public TrainingRequestLogDAO() {
		context = new ContextTemplate().getContext();
		temp = new ContextTemplate().getJdbctemplate();
	}

	public boolean insertTrainingRequestLog(int training_request_id, int status_change, Timestamp status_change_time, String desc) {
		String sql = "insert into training_request_log values(training_request_log_id_seq.nextval,?,?,?,?)";
		int num = temp.update(sql, new Object[]{training_request_id, status_change, status_change_time, desc});
		if (num == 1) {
			return true;
		}
		return false;
	}
	
	//approve dao
	public boolean insertTrainingRequestLog(int training_request_id, int status_change, String desc) {
		String sql = "insert into training_request_log values(training_request_log_id_seq.nextval,?,?,?,?)";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		int num = temp.update(sql, new Object[]{training_request_id, status_change, timestamp, desc});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteTrainingRequestLog(int training_request_log_id) {
		String sql = "delete from training_request_log where request_log_id = ?";
		int num = temp.update(sql, new Object[]{training_request_log_id});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public boolean updateTrainingRequestLog(int request_log_id, int training_request_id, int status_change, Timestamp status_time, String desc) {
		String sql = "update training_request_log set training_request_id = ?, status_change_to = ? statue_changed_time = ?, description = ? where request_log_id = ?";
		int num = temp.update(sql, new Object[] {training_request_id, status_change, status_time, desc, request_log_id});
		if (num == 1) {
			return true;
		}
		return false;
	}
	

	public List<TrainingRequestLog> getAllTrainingRequestLog() {
		String sql = "select * from training_request_log";
		return temp.query(sql, new TrainingRequestLogMapper());
	}
	
	public List<TrainingRequestLog> getTrainingRequestLog(int training_request_id) {
		String sql = "select * from training_request_log where training_request_id= ?";
		List<TrainingRequestLog> logList = temp.query(sql, new Object[]{training_request_id}, new TrainingRequestLogMapper());
		return logList;
	}
}
