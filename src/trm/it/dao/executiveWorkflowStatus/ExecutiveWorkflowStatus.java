package dao.executiveWorkflowStatus;

import dao.employee.Employee;
import dao.trainingRequest.TrainingRequest;

public class ExecutiveWorkflowStatus
{
	/*
	  executive_workflow_status_id number(5) primary key,
	  training_request_id number(5) CONSTRAINT ews_tr_fk references training_request(training_request_id) unique not null,
	  executive_id number(7) CONSTRAINT ews_exec_fk references employee(employee_id),
	  sent_invitations number(2),
	  completed_skillport_enrollment number(2),
	  assessments_recorded number(2),
	  vendor_training_clearance number(2),
	  completed_feedback number(2),
	  training_completed number(2)
	*/
	
	private int executive_workflow_status_id;
	private int training_request; 				//foreign key training_request
	private int executive; 				//foreign key employee
	private boolean sent_invitations;
	private boolean completed_skillport_enrollment;
	private boolean assessments_recorded;
	private boolean vendor_training_clearance;
	private boolean completed_feedback;
	private boolean training_completed;
	

	public void displayExec(){
		System.out.println("Displaying Executive info: ");
		System.out.println("ID: " + executive_workflow_status_id);
		System.out.println("Training Request: " + training_request);
		System.out.println("Executive: " + executive);
		System.out.println("Sent invitations: " + sent_invitations);
		System.out.println("completed enrollment: " + completed_skillport_enrollment);
		System.out.println("Assessments Recorded: " + assessments_recorded);
		System.out.println("Completed Feedback: " + completed_feedback);
		System.out.println("Training Completed: " + training_completed);
	}
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/
	
	public int getExecutive_workflow_status_id()
	{
		return executive_workflow_status_id;
	}
	public void setExecutive_workflow_status_id(int executive_workflow_status_id)
	{
		this.executive_workflow_status_id = executive_workflow_status_id;
	}
	public int getTraining_request()
	{
		return training_request;
	}
	public void setTraining_request(int training_request)//TrainingRequest training_request)
	{
		this.training_request = training_request;
	}
	public int getExecutive()
	{
		return executive;
	}
	public void setExecutive(int executive) //Employee executive)
	{
		this.executive = executive;
	}
	public boolean isSent_invitations()
	{
		return sent_invitations;
	}
	public void setSent_invitations(boolean sent_invitations)
	{
		this.sent_invitations = sent_invitations;
	}
	public boolean isCompleted_skillport_enrollment()
	{
		return completed_skillport_enrollment;
	}
	public void setCompleted_skillport_enrollment(boolean completed_skillport_enrollment)
	{
		this.completed_skillport_enrollment = completed_skillport_enrollment;
	}
	public boolean isAssessments_recorded()
	{
		return assessments_recorded;
	}
	public void setAssessments_recorded(boolean assessments_recorded)
	{
		this.assessments_recorded = assessments_recorded;
	}
	public boolean isVendor_training_clearance()
	{
		return vendor_training_clearance;
	}
	public void setVendor_training_clearance(boolean vendor_training_clearance)
	{
		this.vendor_training_clearance = vendor_training_clearance;
	}
	public boolean isCompleted_feedback()
	{
		return completed_feedback;
	}
	public void setCompleted_feedback(boolean completed_feedback)
	{
		this.completed_feedback = completed_feedback;
	}
	public boolean isTraining_completed()
	{
		return training_completed;
	}
	public void setTraining_completed(boolean training_completed)
	{
		this.training_completed = training_completed;
	}	
}
