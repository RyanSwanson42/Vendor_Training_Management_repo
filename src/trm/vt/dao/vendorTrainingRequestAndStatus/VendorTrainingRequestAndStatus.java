package trm.vt.dao.vendorTrainingRequestAndStatus;

import trm.vt.dao.employee.Employee;
import trm.vt.dao.trainingRequest.TrainingRequest;
import trm.vt.dao.vendorTrainingRequest.VendorTrainingRequest;

public class VendorTrainingRequestAndStatus {

	private TrainingRequest trainingRequest;
	private VendorTrainingRequest vendorTrainingRequest;
	private Employee employee;
	
	public TrainingRequest getTrainingRequest() {
		return trainingRequest;
	}
	public void setTrainingRequest(TrainingRequest trainingRequest) {
		this.trainingRequest = trainingRequest;
	}
	public VendorTrainingRequest getVendorTrainingRequest() {
		return vendorTrainingRequest;
	}
	public void setVendorTrainingRequest(VendorTrainingRequest vendorTrainingRequest) {
		this.vendorTrainingRequest = vendorTrainingRequest;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	@Override
	public String toString() {
		return "\n\nTrainingRequestAndStatus [trainingRequest=" + trainingRequest + ", vendorTrainingRequest="
				+ vendorTrainingRequest + ", employee=" + employee + "]";
	}

}
