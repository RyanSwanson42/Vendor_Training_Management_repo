package trm.dt.dao.trainingRequestLog;

import java.sql.Timestamp;

import trm.dt.dao.trainingRequest.TrainingRequest;
import trm.dt.dao.trainingRequest.TrainingRequestDAO;

public class RequestLog {
	private int request_log_id;
	private int training_request_id;
	private int status_changed_to;
	private Timestamp status_change_time;
	private String description;
	
	public TrainingRequest getRequest(int training_request_id)
	{
		TrainingRequestDAO trd = new TrainingRequestDAO();
		TrainingRequest tr = trd.getTrainingRequest(training_request_id);
		return tr;		
	}
	
	public int getRequest_log_id() {
		return request_log_id;
	}
	public void setRequest_log_id(int request_log_id) {
		this.request_log_id = request_log_id;
	}
	public int getTraining_request_id() {
		return training_request_id;
	}
	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}
	public int getStatus_changed_to() {
		return status_changed_to;
	}
	public void setStatus_changed_to(int status_changed_to) {
		this.status_changed_to = status_changed_to;
	}
	public Timestamp getStatus_change_time() {
		return status_change_time;
	}
	public void setStatus_change_time(Timestamp status_change_time) {
		this.status_change_time = status_change_time;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
