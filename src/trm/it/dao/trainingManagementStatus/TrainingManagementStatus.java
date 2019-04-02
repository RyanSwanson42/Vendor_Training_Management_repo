package trm.it.dao.trainingManagementStatus;

import trm.it.dao.trainingRequest.TrainingRequest;

public class TrainingManagementStatus
{
	/*
	  training_management_status_id number(5) primary key,
  	  training_request_id number(5) CONSTRAINT tms_tr_fk references training_request(training_request_id) not null,
  	  status number(5) not null
	*/
	
	private int training_management_id;
	private int training_request;
	private int status;
	
	
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/
	public void display(){
		System.out.println("Status info: ");
		System.out.println("ID: " + training_management_id);
		System.out.println("Training Request: " + training_request);
		System.out.println("Status: " + status);
	}
	
	public int getTraining_management_id()
	{
		return training_management_id;
	}
	public void setTraining_management_id(int training_management_status)
	{
		this.training_management_id = training_management_status;
	}
	public int getTraining_request()
	{
		return training_request;
	}
	public void setTraining_request(int training_request)
	{
		this.training_request = training_request;
	}
	public int getStatus()
	{
		return status;
	}
	public void setStatus(int status)
	{
		this.status = status;
	}
}