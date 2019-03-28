package dao.getStatus;

import dao.spocMaster.SpocMaster;
import dao.trainingManagementStatus.TrainingManagementStatus;
import dao.trainingRequest.TrainingRequest;

public class GetStatus {
	SpocMaster spoc = new SpocMaster();
	TrainingManagementStatus tms = new TrainingManagementStatus();
	TrainingRequest trequest = new TrainingRequest();
	
	public void displayStatus(){
		System.out.println("Display Status start: ");
		System.out.println("Training Request: " + trequest.getTraining_request_id());
		System.out.println("Vertical: " + trequest.getVertical());
		System.out.println("Status: " + tms.getStatus());
		System.out.println("");
	}
	
	public SpocMaster getSpoc() {
		return spoc;
	}
	public void setSpoc(SpocMaster spoc) {
		this.spoc = spoc;
	}
	public TrainingManagementStatus getTms() {
		return tms;
	}
	public void setTms(TrainingManagementStatus tms) {
		this.tms = tms;
	}
	public TrainingRequest getTrequest() {
		return trequest;
	}
	public void setTrequest(TrainingRequest trequest) {
		this.trequest = trequest;
	}
	
	
	
}
