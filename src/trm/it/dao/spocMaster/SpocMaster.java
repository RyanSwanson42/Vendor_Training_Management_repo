package trm.it.dao.spocMaster;

import trm.it.dao.employee.Employee;

public class SpocMaster extends Employee
{
	/*
	  spoc_master_id number(5) primary key,
	  spoc_emp_id number(7) CONSTRAINT spoc_emp_fk references employee(employee_id) not null,
	  spoc_vertical varchar(10)
	*/
	
	private int spoc_master_id;
	private int spoc_emp_id;
	private String spoc_vertical;
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/	
	
	public int getSpoc_master_id()
	{
		return spoc_master_id;
	}
	public void setSpoc_master_id(int spoc_master_id)
	{
		this.spoc_master_id = spoc_master_id;
	}
	public String getSpoc_vertical()
	{
		return spoc_vertical;
	}
	public void setSpoc_vertical(String spoc_vertical)
	{
		this.spoc_vertical = spoc_vertical;
	}
	public int getSpoc_emp_id() {
		return spoc_emp_id;
	}
	public void setSpoc_emp_id(int spoc_emp_id) {
		this.spoc_emp_id = spoc_emp_id;
	}
	
	
}
