package trm.it.dao.validTrainers;

import trm.it.dao.employee.Employee;
import trm.it.dao.internalTrainer.InternalTrainer;
import trm.it.dao.trainingManagementStatus.TrainingManagementStatus;

public class ValidTrainers {
	private InternalTrainer internalTrainer;
	private Employee employee;
	private TrainingManagementStatus status;
	
	
	public InternalTrainer getInternalTrainer() {
		return internalTrainer;
	}
	public void setInternalTrainer(InternalTrainer internalTrainer) {
		this.internalTrainer = internalTrainer;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public TrainingManagementStatus getStatus() {
		return status;
	}
	public void setStatus(TrainingManagementStatus status) {
		this.status = status;
	}
	
	
}
