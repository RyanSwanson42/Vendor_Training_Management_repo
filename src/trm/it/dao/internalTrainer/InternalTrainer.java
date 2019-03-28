package trm.it.dao.internalTrainer;

import trm.it.dao.employee.Employee;

public class InternalTrainer
{
	/*
	  it_trainer_id number(7) CONSTRAINT it_trainer_fk references employee(employee_id) unique not null,
	  profile_file_path varchar(100),
	  trainer_location varchar(20)
	*/
	
	private int internal_trainer_id; //make employee if i figure out how to make it work.
	private String profile_file_path;
	private String trainer_location;
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/
	
	public String getProfile_file_path()
	{
		return profile_file_path;
	}
	public void setProfile_file_path(String profile_file_path)
	{
		this.profile_file_path = profile_file_path;
	}
	public String getTrainer_location()
	{
		return trainer_location;
	}
	public void setTrainer_location(String trainer_location)
	{
		this.trainer_location = trainer_location;
	}
	public int getInternal_trainer_id() {
		return internal_trainer_id;
	}
	public void setInternal_trainer_id(int internal_trainer_id) {
		this.internal_trainer_id = internal_trainer_id;
	}
}
