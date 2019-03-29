package trm.dt.dao.inTrainingCard;

import trm.dt.dao.developTeamTrainingRequest.DDTTraining;
import trm.dt.dao.employee.Employee;
import trm.dt.dao.executiveWorkflowStatus.ExecutiveWorkflow;
import trm.dt.dao.trainingManagementStatus.ManagmentStatus;
import trm.dt.dao.trainingRequest.TrainingRequest;
import trm.dt.dao.trainingSchedule.TrainingSchedule;

public class InTrainingCard 
{
	private DDTTraining training = new DDTTraining();
	private TrainingRequest request = new TrainingRequest();
	private TrainingSchedule schedule = new TrainingSchedule();
	private ManagmentStatus status =  new ManagmentStatus();
	private Employee pm = new Employee();
	private Employee ct = new Employee();
	private ExecutiveWorkflow workflow = new ExecutiveWorkflow();

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
	public Employee getPm() {
		return pm;
	}
	public void setPm(Employee pm) {
		this.pm = pm;
	}
	public Employee getCt() {
		return ct;
	}
	public void setCt(Employee ct) {
		this.ct = ct;
	}
	public ExecutiveWorkflow getWorkflow() {
		return workflow;
	}
	public void setWorkflow(ExecutiveWorkflow workflow) {
		this.workflow = workflow;
	}
	@Override
	public String toString() {
		return "\nInTrainingCard [training=" + training + ", request=" + request + ", schedule=" + schedule + ", status="
				+ status + ", pm=" + pm + ", ct=" + ct + ", workflow=" + workflow + "]";
	}
	
}
