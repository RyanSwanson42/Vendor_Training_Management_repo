package dao.dtt.summary;

import dao.dtt.developTeamTrainingRequest.DDTTraining;
import dao.dtt.developTeamTrainerRequest.DDTTrainer;
import dao.employee.Employee;
import dao.trainingManagementStatus.ManagmentStatus;
import dao.trainingRequest.TrainingRequest;
import dao.trainingSchedule.TrainingSchedule;

public class Summary 
{
	private DDTTraining training = new DDTTraining();
	private TrainingRequest request = new TrainingRequest();
	private TrainingSchedule schedule = new TrainingSchedule();
	private	Employee projectManager = new Employee();
	private DDTTrainer trainer = new DDTTrainer();
	private Employee currentTrainer = new Employee();
	private ManagmentStatus status = new ManagmentStatus();
	
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
	public Employee getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(Employee projectManager) {
		this.projectManager = projectManager;
	}
	public DDTTrainer getTrainer() {
		return trainer;
	}
	public void setTrainer(DDTTrainer trainer) {
		this.trainer = trainer;
	}
	public Employee getCurrentTrainer() {
		return currentTrainer;
	}
	public void setCurrentTrainer(Employee currentTrainer) {
		this.currentTrainer = currentTrainer;
	}
	public ManagmentStatus getStatus() {
		return status;
	}
	public void setStatus(ManagmentStatus status) {
		this.status = status;
	}
}
