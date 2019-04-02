package trm.dt.dao.trainingRequest;

import java.sql.Timestamp;

import trm.dt.dao.employee.Employee;
import trm.dt.dao.employee.EmployeeDAO;

public class TrainingRequest {
	private int training_request_id;
	private int requester_id;
	private String vertical;
	private String request_training_type;
	private String request_training_module;
	private String request_training_module_scope;
	private String request_training_mode;
	private String request_start_date;
	private String request_end_date;
	private String request_location;
	private String request_time_zone;
	private int request_approx_participant;
	private int request_project_spoc;
	private Timestamp time_requested;
	private String justification_of_request;
	
	public Employee getEmployeeDetails(int employee_id)
	{
		EmployeeDAO ed = new EmployeeDAO();
		Employee e = ed.getEmployee(employee_id);
		return e;	
	}
	 
	@Override
	public String toString() {
		return "TrainingRequest [training_request_id=" + training_request_id + ", requester_id=" + requester_id
				+ ", vertical=" + vertical + ", request_training_type=" + request_training_type
				+ ", request_training_module=" + request_training_module + ", request_training_module_scope="
				+ request_training_module_scope + ", request_training_mode=" + request_training_mode
				+ ", request_start_date=" + request_start_date + ", request_end_date=" + request_end_date
				+ ", request_location=" + request_location + ", request_time_zone=" + request_time_zone
				+ ", request_approx_participant=" + request_approx_participant + ", request_project_spoc="
				+ request_project_spoc + ", time_requested=" + time_requested + ", justification_of_request="
				+ justification_of_request + "]";
	}

	public int getTraining_request_id() {
		return training_request_id;
	}
	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}
	public int getRequester_id() {
		return requester_id;
	}
	public void setRequester_id(int requester_id) {
		this.requester_id = requester_id;
	}
	public String getVertical() {
		return vertical;
	}
	public void setVertical(String vertical) {
		this.vertical = vertical;
	}
	public String getRequest_training_type() {
		return request_training_type;
	}
	public void setRequest_training_type(String request_training_type) {
		this.request_training_type = request_training_type;
	}
	public String getRequest_training_module() {
		return request_training_module;
	}
	public void setRequest_training_module(String request_training_module) {
		this.request_training_module = request_training_module;
	}
	public String getRequest_training_module_scope() {
		return request_training_module_scope;
	}
	public void setRequest_training_module_scope(
			String request_training_module_scope) {
		this.request_training_module_scope = request_training_module_scope;
	}
	public String getRequest_training_mode() {
		return request_training_mode;
	}
	public void setRequest_training_mode(String request_training_mode) {
		this.request_training_mode = request_training_mode;
	}
	public String getRequest_start_date() {
		return request_start_date;
	}
	public void setRequest_start_date(String start_date) {
		this.request_start_date = start_date;
	}
	public String getRequest_end_date() {
		return request_end_date;
	}
	public void setRequest_end_date(String request_end_date) {
		this.request_end_date = request_end_date;
	}
	public String getRequest_location() {
		return request_location;
	}
	public void setRequest_location(String request_location) {
		this.request_location = request_location;
	}
	public String getRequest_time_zone() {
		return request_time_zone;
	}
	public void setRequest_time_zone(String request_time_zone) {
		this.request_time_zone = request_time_zone;
	}
	public int getRequest_approx_participant() {
		return request_approx_participant;
	}
	public void setRequest_approx_participant(int request_approx_participant) {
		this.request_approx_participant = request_approx_participant;
	}
	public int getRequest_project_spoc() {
		return request_project_spoc;
	}
	public void setRequest_project_spoc(int request_project_spoc) {
		this.request_project_spoc = request_project_spoc;
	}
	public Timestamp getTime_requested() {
		return time_requested;
	}
	public void setTime_requested(Timestamp time_requested) {
		this.time_requested = time_requested;
	}
	public String getJustification_of_request() {
		return justification_of_request;
	}
	public void setJustification_of_request(String justification_of_request) {
		this.justification_of_request = justification_of_request;
	}
	 
}
