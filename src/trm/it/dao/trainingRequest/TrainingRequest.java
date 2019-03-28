package dao.trainingRequest;

import java.sql.Date;
import java.sql.Time;

import dao.employee.Employee;

public class TrainingRequest
{
	/*
  training_request_id number(5) primary key,
  requester_id number(7) CONSTRAINT tr_requester_fk references employee(employee_id) not null,
  vertical varchar(10),
  request_training_type varchar(20),
  request_training_module varchar(20) not null,
  request_training_module_scope varchar(300) not null,
  request_training_mode varchar(20),
  request_start_date TIMESTAMP(0),
  request_end_date TIMESTAMP(0),
  request_location varchar(20) not null,
  request_time_zone varchar(6),
  request_approx_participant number(2),
  request_project_spoc number(7)CONSTRAINT tr_spoc_fk references employee(employee_id),
  time_requested TIMESTAMP(0),
  justification_of_request varchar(200) not null
	*/
	
	private int training_request_id;
	private int requester; //employee join
	private String vertical;
	private String request_training_type;
	private String request_training_module;
	private String request_training_module_scope;
	private String request_training_mode;
	private String request_start_date; //Possibly turn into string
	private String request_end_date; //Possibly turn into string
	private String request_location;
	private String request_time_zone;
	private int request_approx_participant;
	private int request_project_spoc;
	private String time_requested; 
	private String justification_of_request;
	
	public void displayMain(){
		System.out.println("Retrieving Training Request info:");
		
		System.out.println("ID: " + training_request_id);
		//requester.getNames();
		System.out.println("Vertical: " + vertical);
		System.out.println("Type: " + request_training_type);
		System.out.println("Module: " + request_training_module);
		System.out.println("Module Scope: " + request_training_module_scope);
		System.out.println("Mode: " + request_training_mode);
		System.out.println("Start Date: " + request_start_date);
		System.out.println("End Date: " + request_end_date);
		System.out.println("Location: " + request_location);
		System.out.println("Time Zone: " + request_time_zone);
		//System.out.println("Spoc: " + request_project_spoc.getEmployee_id());
		System.out.println("Time requested: " + time_requested);
		System.out.println("Justification: " + justification_of_request);
	}
	public void displayAll(){
		System.out.println("Retrieving Training Request info:");
		System.out.println("ID: " + training_request_id);
		//System.out.println("Name: " + requester.getLast_name() + ", " + requester.getFirst_name());
		System.out.println("Module: " + request_training_module);
		System.out.println("Start Date: " + request_start_date);
		System.out.println("Location: " + request_location);
	}
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/
	
	public int getTraining_request_id()
	{
		return training_request_id;
	}
	public void setTraining_request_id(int training_request_id)
	{
		this.training_request_id = training_request_id;
	}
	public int getRequester()
	{
		return requester;
	}
	public void setRequester(int requester)
	{
		this.requester = requester;
	}
	public String getVertical()
	{
		return vertical;
	}
	public void setVertical(String vertical)
	{
		this.vertical = vertical;
	}
	public String getRequest_training_type()
	{
		return request_training_type;
	}
	public void setRequest_training_type(String request_training_type)
	{
		this.request_training_type = request_training_type;
	}
	public String getRequest_training_module()
	{
		return request_training_module;
	}
	public void setRequest_training_module(String request_training_module)
	{
		this.request_training_module = request_training_module;
	}
	public String getRequest_training_module_scope()
	{
		return request_training_module_scope;
	}
	public void setRequest_training_module_scope(String request_training_module_scope)
	{
		this.request_training_module_scope = request_training_module_scope;
	}
	public String getRequest_training_mode()
	{
		return request_training_mode;
	}
	public void setRequest_training_mode(String request_training_mode)
	{
		this.request_training_mode = request_training_mode;
	}
	public String getRequest_start_date()
	{
		return request_start_date;
	}
	public void setRequest_start_date(String request_start_date)
	{
		this.request_start_date = request_start_date;
	}
	public String getRequest_end_date()
	{
		return request_end_date;
	}
	public void setRequest_end_date(String request_end_date)
	{
		this.request_end_date = request_end_date;
	}
	public String getRequest_location()
	{
		return request_location;
	}
	public void setRequest_location(String request_location)
	{
		this.request_location = request_location;
	}
	public String getRequest_time_zone()
	{
		return request_time_zone;
	}
	public void setRequest_time_zone(String request_time_zone)
	{
		this.request_time_zone = request_time_zone;
	}
	public int getRequest_approx_participant()
	{
		return request_approx_participant;
	}
	public void setRequest_approx_participant(int request_approx_participant)
	{
		this.request_approx_participant = request_approx_participant;
	}
	public int getRequest_project_spoc()
	{
		return request_project_spoc;
	}
	public void setRequest_project_spoc(int request_project_spoc)
	{
		this.request_project_spoc = request_project_spoc;
	}
	public String getTime_requested()
	{
		return time_requested;
	}
	public void setTime_requested(String time_requested)
	{
		this.time_requested = time_requested;
	}
	public String getJustification_of_request()
	{
		return justification_of_request;
	}
	public void setJustification_of_request(String justification_of_request)
	{
		this.justification_of_request = justification_of_request;
	}	
	public String toString() {
		return "\nTrainingRequest [training_request_id=" + training_request_id + ", requester_id=" + requester
				+ ", vertical=" + vertical + ", request_training_type=" + request_training_type
				+ ", request_training_module=" + request_training_module + ", request_training_module_scope="
				+ request_training_module_scope + ", request_training_mode=" + request_training_mode
				+ ", request_start_date=" + request_start_date + ", request_end_date=" + request_end_date
				+ ", request_location=" + request_location + ", request_time_zone=" + request_time_zone
				+ ", request_approx_participant=" + request_approx_participant + ", request_project_spoc="
				+ request_project_spoc + ", time_requested=" + time_requested + ", justification_of_request="
				+ justification_of_request + "]";
	}
}
