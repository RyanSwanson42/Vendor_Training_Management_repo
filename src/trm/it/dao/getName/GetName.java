package trm.it.dao.getName;

import trm.it.dao.employee.Employee;
import trm.it.dao.it.internalTrainer.InternalTrainer;

public class GetName {
	Employee employee;
	InternalTrainer it;
	
	public void display(){
		System.out.println("Name is: " + employee.getLast_name() + ", " + employee.getFirst_name());
	}
	
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public InternalTrainer getIt() {
		return it;
	}
	public void setIt(InternalTrainer it) {
		this.it = it;
	}
	
	
}
