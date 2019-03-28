package dbo;

import java.util.Date;

public class TrainingRequestLog {
	private int request_log_id;
	private int training_request_id;
	private int status_changed_to;
	private Date status_change_time;
	private String description;
	
	public String testTrainingRequestLog() {
		return "" + request_log_id + " | " + training_request_id + " | " + status_changed_to + " | " + status_change_time + " | " + description;
	}

	//getters and setters
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

	public Date getStatus_change_time() {
		return status_change_time;
	}

	public void setStatus_change_time(Date status_change_time) {
		this.status_change_time = status_change_time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
