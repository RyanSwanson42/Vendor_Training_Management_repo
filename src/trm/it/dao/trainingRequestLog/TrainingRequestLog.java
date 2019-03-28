package dao.trainingRequestLog;

import java.sql.Time;

import dao.trainingRequest.TrainingRequest;

public class TrainingRequestLog
{
	/*
	  request_log_id varchar(10) primary key,
	  training_request_id number(5) CONSTRAINT tlg_tr_fk references training_request(training_request_id) not null,
	  status_changed_to number(5),
	  status_change_time TIMESTAMP(0) not null,
	  description varchar(200)
	*/
	
	private int request_log_id;
	private int training_request; //TrainingRequest join
	private int status_changed_to;
	private String status_changed_time; //possibly changed to string;
	private String description;
	
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/
	public void display(){
		System.out.println("id: " + request_log_id);
		System.out.println("Training Request: " + training_request);
		System.out.println("Status changed to: " + status_changed_to);
		System.out.println("Time: " + status_changed_time);
		System.out.println("Description: " + description);
	}
	
	public int getRequest_log_id()
	{
		return request_log_id;
	}
	public void setRequest_log_id(int request_log_id)
	{
		this.request_log_id = request_log_id;
	}
	public int getTraining_request()
	{
		return training_request;
	}
	public void setTraining_request(int training_request)
	{
		this.training_request = training_request;
	}
	public int getStatus_changed_to()
	{
		return status_changed_to;
	}
	public void setStatus_changed_to(int status_changed_to)
	{
		this.status_changed_to = status_changed_to;
	}
	public String getStatus_changed_time()
	{
		return status_changed_time;
	}
	public void setStatus_changed_time(String status_changed_time)
	{
		this.status_changed_time = status_changed_time;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
}
