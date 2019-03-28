package trm.dt.dao.spocMaster;

import trm.dt.dao.employee.Employee;
import trm.dt.dao.employee.EmployeeDAO;

public class SpocMaster 
{
	private int spoc_master_id;
	private int spoc_emp_id;
	private String spoc_vertical;
	
	public Employee getEmployeeDetails(int employee_id)
	{
		EmployeeDAO ed = new EmployeeDAO();
		Employee e = ed.getEmployee(employee_id);
		return e;	
	}

	public int getSpoc_master_id() {
		return spoc_master_id;
	}
	public void setSpoc_master_id(int spoc_master_id) {
		this.spoc_master_id = spoc_master_id;
	}
	public int getSpoc_emp_id() {
		return spoc_emp_id;
	}
	public void setSpoc_emp_id(int spoc_emp_id) {
		this.spoc_emp_id = spoc_emp_id;
	}
	public String getSpoc_vertical() {
		return spoc_vertical;
	}
	public void setSpoc_vertical(String spoc_vertical) {
		this.spoc_vertical = spoc_vertical;
	}
}
