package controllers;

import java.util.List;

import dbo.TrainingManagementStatus;
import dbo.TrainingManagementStatusDAO;
import dbo.TrainingRequest;
import dbo.TrainingRequestDAO;
//change status 102 (no longer used) to 100,
//create a status management for all the test data that didn't have one
public class FixAllStatus {

	public static void main(String[] args) {
		List<TrainingRequest> reqList = new TrainingRequestDAO().getAllTrainingRequest();
		TrainingManagementStatusDAO tmsd = new TrainingManagementStatusDAO();
		int x = 0;//WHY?
		//Sloppy code. This loop queries the database over and over quickly.
		//If I had more time, I would write a procedure or something. As it stands, change...
		for(TrainingRequest r : reqList){
			if(x < 50){x++; continue;}//THIS NUMBER if your not cycling through all the requests without an error.
			//If you get through 60 then it crashes, change 
			List<TrainingManagementStatus> tmsl = tmsd.getTrainingManagementStatus(r.getTraining_request_id());
			if(tmsl.isEmpty()){
				tmsd.insertTrainingManagementStatus(r.getTraining_request_id(), 100);
				System.out.println(r.getTraining_request_id() + "now has a status!");
			}
			else if(tmsl.size() == 1){
				System.out.println(r.getTraining_request_id() + "already had a status...");
				if(tmsl.get(0).getStatus() == 102){
					tmsd.updateTrainingManagementStatus(tmsl.get(0).getTraining_management_status_id(), tmsl.get(0).getTraining_request_id(), 100);
				}
			}
			else if(tmsl.size() > 1){
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
				System.out.println("This is a problem.");
			}
		}
	}

}