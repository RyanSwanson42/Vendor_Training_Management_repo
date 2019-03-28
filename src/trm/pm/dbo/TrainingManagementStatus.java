package trm.pm.dbo;

public class TrainingManagementStatus {
	private int training_management_status_id;
	private int training_request_id;
	private int status;
	
	public String TMSTest() {
		return "" + training_management_status_id + " | " + training_request_id + " | " + status;
	}

	//getters and setters
	public int getTraining_management_status_id() {
		return training_management_status_id;
	}

	public void setTraining_management_status_id(int training_management_status_id) {
		this.training_management_status_id = training_management_status_id;
	}

	public int getTraining_request_id() {
		return training_request_id;
	}

	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
