package dbo;

import dbo.TrainingRequestLogDAO;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingManagementStatusDAO {
	ApplicationContext context;
	JdbcTemplate temp;

	public TrainingManagementStatusDAO() {
		context = new ContextTemplate().getContext();
		temp = new ContextTemplate().getJdbctemplate();
	}

	public boolean insertTrainingManagementStatus(int training_request_id, int status) {
		String sql = "insert into training_management_status values(trng_management_status_id_seq.nextval,?,?)";
		int num = temp.update(sql, new Object[]{training_request_id, status});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteTrainingManagementStatus(int training_management_status_id) {
		String sql = "delete from training_management_status where training_management_status_id = ?";
		int num = temp.update(sql, new Object[]{training_management_status_id});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public void updateTrainingManagementStatus(int training_management_request_id, int training_request_id, int status) {
		String sql = "update training_management_status set training_request_id = ?, status = ? where training_management_status_id = ?";
		temp.update(sql, new Object[] {training_request_id, status,training_management_request_id});
	}
	
	public void updateTrainingManagementStatus(int training_management_request_id, int status) {
		String sql = "update training_management_status set status = ? where training_management_status_id = ?";
		temp.update(sql, new Object[] {status,training_management_request_id});
	}
	
	//approve
	public void updateTrainingManagementStatus(int training_request_id) {
		String sql = "update training_management_status set status = ? where training_request_id = ?";
		String sql2 = "select status from training_management_status where training_request_id = ?";
		int status = temp.queryForInt(sql2, new Object[] {training_request_id});
		if (status < 200) {
			temp.update(sql, new Object[] {122, training_request_id});
			new TrainingRequestLogDAO().insertTrainingRequestLog(training_request_id, 122, "approved");
		}
		else if (status < 300) {
			temp.update(sql, new Object[] {222, training_request_id});
			new TrainingRequestLogDAO().insertTrainingRequestLog(training_request_id, 222, "approved");
		}
		else { //vendor
			temp.update(sql, new Object[] {322, training_request_id});
			new TrainingRequestLogDAO().insertTrainingRequestLog(training_request_id, 322, "approved");
		}
	}
	
	//decline
	public void updateTrainingManagementStatus(int training_request_id, String just) {
		String sql = "update training_management_status set status = ? where training_request_id = ?";
		String sql2 = "select status from training_management_status where training_request_id = ?";
		int status = temp.queryForInt(sql2, new Object[] {training_request_id});
		if (status < 200) {
			temp.update(sql, new Object[] {121, training_request_id});
			new TrainingRequestLogDAO().insertTrainingRequestLog(training_request_id, 121, just);
		}
		else if (status < 300) {
			temp.update(sql, new Object[] {221, training_request_id});
			new TrainingRequestLogDAO().insertTrainingRequestLog(training_request_id, 221, just);
		}
		else { //vendor
			temp.update(sql, new Object[] {321, training_request_id});
			new TrainingRequestLogDAO().insertTrainingRequestLog(training_request_id, 321, just);
		}
	}

	public List<TrainingManagementStatus> getAllTrainingManagementStatus() {
		String sql = "select * from training_management_status";
		return temp.query(sql, new TrainingManagementStatusMapper());
	}
	
	public List<TrainingManagementStatus> getTrainingManagementStatus(int training_request_id) {
		String sql = "select * from training_management_status where training_request_id=?";
		List<TrainingManagementStatus> trainingManagementStatus = temp.query(sql, new Object[]{training_request_id},new TrainingManagementStatusMapper());
		return trainingManagementStatus;
	}
}
