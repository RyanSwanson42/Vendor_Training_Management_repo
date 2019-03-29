package trm.it.dao.internalTrainingRequest;

public class InternalTrainingRequest {
	
	private int internal_training_id;
	private int training_request_id;		//Training Request join
	private int schedule_id; 					//Training Schedule join
	private int confirmed_trainer_id;			//Internal Trainer join
	private int executive_id;					//Employee join
	private String description_of_status;
	
	public int getInternal_training_id() {
		return internal_training_id;
	}
	public void setInternal_training_id(int internal_training_id) {
		this.internal_training_id = internal_training_id;
	}
	public int getTraining_request_id() {
		return training_request_id;
	}
	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}
	public int getSchedule_id() {
		return schedule_id;
	}
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	public int getConfirmed_trainer_id() {
		return confirmed_trainer_id;
	}
	public void setConfirmed_trainer_id(int confirmed_trainer_id) {
		this.confirmed_trainer_id = confirmed_trainer_id;
	}
	public int getExecutive_id() {
		return executive_id;
	}
	public void setExecutive_id(int executive_id) {
		this.executive_id = executive_id;
	}
	public String getDescription_of_status() {
		return description_of_status;
	}
	public void setDescription_of_status(String description_of_status) {
		this.description_of_status = description_of_status;
	}
	@Override
	public String toString() {
		return "\nInternalTrainingRequest [internal_training_id=" + internal_training_id + ", training_request_id="
				+ training_request_id + ", schedule_id=" + schedule_id + ", confirmed_trainer_id="
				+ confirmed_trainer_id + ", executive_id=" + executive_id + ", description_of_status="
				+ description_of_status + "]";
	}
	
}
