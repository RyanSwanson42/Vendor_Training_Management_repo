package trm.vt.dao.vendorTrainingRequest;

public class VendorTrainingRequest {
	private int vendor_training_request_id;
	private int training_request_id;
	private int confirmed_vendor_id;
	private int vendor_trainer_id;
	private int schedule_id;
	private int executive_id;
	private String po_status;
	private String vendor_confirmation_email_path;
	private String description_of_status;
	
	public int getVendor_training_request_id() {
		return vendor_training_request_id;
	}
	
	public void setVendor_training_request_id(int vendor_training_request_id) {
		this.vendor_training_request_id = vendor_training_request_id;
	}
	
	public int getTraining_request_id() {
		return training_request_id;
	}
	
	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}
	
	public int getConfirmed_vendor_id() {
		return confirmed_vendor_id;
	}
	
	public void setConfirmed_vendor_id(int confirmed_vendor_id) {
		this.confirmed_vendor_id = confirmed_vendor_id;
	}
	
	public int getVendor_trainer_id() {
		return vendor_trainer_id;
	}
	
	public void setVendor_trainer_id(int vendor_trainer_id) {
		this.vendor_trainer_id = vendor_trainer_id;
	}
	
	public int getSchedule_id() {
		return schedule_id;
	}
	
	public void setSchedule_id(int schedule_id) {
		this.schedule_id = schedule_id;
	}
	
	public int getExecutive_id() {
		return executive_id;
	}
	
	public void setExecutive_id(int executive_id) {
		this.executive_id = executive_id;
	}
	
	public String getPo_status() {
		return po_status;
	}
	
	public void setPo_status(String po_status) {
		this.po_status = po_status;
	}
	
	public String getVendor_confirmation_email_path() {
		return vendor_confirmation_email_path;
	}
	
	public void setVendor_confirmation_email_path(String vendor_confirmation_email_path) {
		this.vendor_confirmation_email_path = vendor_confirmation_email_path;
	}
	
	public String getDescription_of_status() {
		return description_of_status;
	}
	
	public void setDescription_of_status(String description_of_status) {
		this.description_of_status = description_of_status;
	}

	@Override
	public String toString() {
		return "\nVendorTrainingRequest [vendor_training_request_id=" + vendor_training_request_id
				+ ", training_request_id=" + training_request_id + ", confirmed_vendor_id=" + confirmed_vendor_id
				+ ", vendor_trainer_id=" + vendor_trainer_id + ", schedule_id=" + schedule_id + ", executive_id="
				+ executive_id + ", po_status=" + po_status + ", vendor_confirmation_email_path="
				+ vendor_confirmation_email_path + ", description_of_status=" + description_of_status + "]";
	}
	
}

