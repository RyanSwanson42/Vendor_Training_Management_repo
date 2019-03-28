package trm.dt.dao.newTrainingCard;

import java.sql.Timestamp;

public class NewTrainingCard 
{
	private int training_request_id;
	private String first_name;
	private String last_name;
	private String request_training_module;
	private Timestamp request_start_date;
	private int status;
	
	public int getTraining_request_id() {
		return training_request_id;
	}
	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getRequest_training_module() {
		return request_training_module;
	}
	public void setRequest_training_module(String request_training_module) {
		this.request_training_module = request_training_module;
	}
	public Timestamp getRequest_start_date() {
		
		return request_start_date;
	}
	public void setRequest_start_date(Timestamp request_start_date) {
		this.request_start_date = request_start_date;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
}
