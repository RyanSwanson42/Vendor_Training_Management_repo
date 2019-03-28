package dao.dtt.inTrainingCard;

import dao.dtt.developTeamTrainingRequest.DDTTraining;
import dao.employee.Employee;
import dao.executiveWorkflowStatus.ExecutiveWorkflow;
import dao.trainingManagementStatus.ManagmentStatus;
import dao.trainingRequest.TrainingRequest;
import dao.trainingSchedule.TrainingSchedule;

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
}
