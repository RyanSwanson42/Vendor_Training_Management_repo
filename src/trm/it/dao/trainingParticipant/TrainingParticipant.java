package dao.trainingParticipant;

import dao.employee.Employee;

public class TrainingParticipant extends Employee
{
	/*
		training_participant_id number(5) primary key,
		participant_employee_id number(7) CONSTRAINT tp_participant_fk references employee(employee_id) not null,
		training_session_attended number(5) CONSTRAINT tp_tr_fk references training_request(training_request_id) not null
	*/
	
	private int training_participant_id;
	private int empId;
	private int training_session_attended;
	
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/

	public int getTraining_participant_id()
	{
		return training_participant_id;
	}
	public void setTraining_participant_id(int training_participant_id)
	{
		this.training_participant_id = training_participant_id;
	}
	public int getTraining_session_attended()
	{
		return training_session_attended;
	}
	public void setTraining_session_attended(int training_session_attended)
	{
		this.training_session_attended = training_session_attended;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
}
