package dao.dtt.inProcessCard;

import dao.dtt.developTeamTrainingRequest.DDTTraining;
import dao.employee.Employee;
import dao.trainingManagementStatus.ManagmentStatus;
import dao.trainingRequest.TrainingRequest;
import dao.trainingSchedule.TrainingSchedule;

public class InProcessCard 
{
	private DDTTraining training = new DDTTraining();
	private TrainingRequest request = new TrainingRequest(); 
	private TrainingSchedule schedule = new TrainingSchedule();
	private ManagmentStatus status  = new ManagmentStatus();
	private Employee employee = new Employee();
	
	public DDTTraining getTraining() {
		return training;
	}
	public void setTraining(DDTTraining training) {
		this.training = training;
	}
	public TrainingRequest getRequest() {
		return request;
	}
	public void setRequest(TrainingRequest request) {
		this.request = request;
	}
	public TrainingSchedule getSchedule() {
		return schedule;
	}
	public void setSchedule(TrainingSchedule schedule) {
		this.schedule = schedule;
	}
	public ManagmentStatus getStatus() {
		return status;
	}
	public void setStatus(ManagmentStatus status) {
		this.status = status;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
}
