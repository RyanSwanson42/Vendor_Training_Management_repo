package trm.dt.dao.developTeamTrainerRequest;

import java.sql.Timestamp;

import trm.dt.dao.employee.Employee;
import trm.dt.dao.employee.EmployeeDAO;
import trm.dt.dao.trainingSchedule.TrainingSchedule;
import trm.dt.dao.trainingSchedule.DDTTrainingScheduleDAO;

public class DDTTrainer {
	private int dtt_trainer_request_id;
	private Timestamp request_sent_date;
	private int trainer_id;
	private int schedule_id;
	private String topic;
	private String comments;
	private String response;
	private int active_status;	
	
	public Employee getEmployeeDetails(int employee_id)
	{
		EmployeeDAO ed = new EmployeeDAO();
		Employee e = ed.getEmployee(employee_id);
		return e;	
	}
	
	@Override
	public String toString() {
		return "DDTTrainer [dtt_trainer_request_id=" + dtt_trainer_request_id + ", request_sent_date="
				+ request_sent_date + ", trainer_id=" + trainer_id + ", schedule_id=" + schedule_id + ", topic=" + topic
				+ ", comments=" + comments + ", response=" + response + ", active_status=" + active_status + "]";
	}

	public TrainingSchedule getSchedule(int schedule_id)
	{
		DDTTrainingScheduleDAO tsd = new DDTTrainingScheduleDAO();
		TrainingSchedule ts = tsd.getTrainingSchedule(schedule_id);
		return ts;
	}
	
	public int getDtt_trainer_request_id() {
		return dtt_trainer_request_id;
	}
	public void setDtt_trainer_request_id(int dtt_trainer_request_id) {
		this.dtt_trainer_request_id = dtt_trainer_request_id;
	}
	public Timestamp getRequest_sent_date() {
		return request_sent_date;
	}
	public void setRequest_sent_date(Timestamp request_sent_date) {
		this.request_sent_date = request_sent_date;
	}
	public int getTrainer_id() {
		return trainer_id;
	}
	public void setTrainer_id(int trainer_id) {
		this.trainer_id = trainer_id;
	}
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public String getTopic() {
		return topic;
	}
	public void setTopic(String topic) {
		this.topic = topic;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	public int getActive_status() {
		return active_status;
	}
	public void setActive_status(int active_status) {
		this.active_status = active_status;
	}
}