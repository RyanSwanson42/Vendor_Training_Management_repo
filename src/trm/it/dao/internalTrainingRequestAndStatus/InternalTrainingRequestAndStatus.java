package trm.it.dao.internalTrainingRequestAndStatus;

import trm.it.dao.internalTrainingRequest.InternalTrainingRequest;
import trm.vt.dao.employee.Employee;
import trm.vt.dao.trainingRequest.TrainingRequest;

public class InternalTrainingRequestAndStatus {

	private TrainingRequest trainingRequest;
	private InternalTrainingRequest internalTrainingRequest;
	private Employee employee;
	
	public TrainingRequest getTrainingRequest() {
		return trainingRequest;
	}
	public void setTrainingRequest(TrainingRequest trainingRequest) {
		this.trainingRequest = trainingRequest;
	}
	public InternalTrainingRequest getInternalTrainingRequest() {
		return internalTrainingRequest;
	}
	public void setInternalTrainingRequest(InternalTrainingRequest internalTrainingRequest) {
		this.internalTrainingRequest = internalTrainingRequest;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "\nInternalTrainingRequestAndStatus [trainingRequest=" + trainingRequest + ", internalTrainingRequest="
				+ internalTrainingRequest + ", employee=" + employee + "]";
	}
	
	
}
