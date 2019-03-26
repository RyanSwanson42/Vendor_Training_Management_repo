package dao.trainingRequestAndStatus;

import dao.employee.Employee;
import dao.trainingRequest.TrainingRequest;

public class TrainingRequestAndStatus {

	private TrainingRequest trainingRequest;
	private Employee employee;
	
	public TrainingRequest getTrainingRequest() {
		return trainingRequest;
	}
	public void setTrainingRequest(TrainingRequest trainingRequest) {
		this.trainingRequest = trainingRequest;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
}
