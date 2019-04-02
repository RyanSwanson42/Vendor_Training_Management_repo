package trm.it.bl;

import java.text.SimpleDateFormat;
import java.util.Date;

import trm.it.dao.getName.GetNameDAO;
import trm.it.dao.getStatus.GetStatusDAO;
import trm.it.dao.internalTrainingRequest.InternalTrainingRequest;
import trm.it.dao.internalTrainingRequest.InternalTrainingRequestDAO;
import trm.it.dao.trainingManagementStatus.TrainingManagementStatus;
import trm.it.dao.trainingManagementStatus.TrainingManagementStatusDAO;
import trm.it.dao.trainingRequestLog.TrainingRequestLogDAO;
import trm.it.dao.trainingSchedule.TrainingSchedule;
import trm.it.dao.trainingSchedule.TrainingScheduleDAO;

@SuppressWarnings("deprecation")
public class InputFormServices
{
	private InternalTrainingRequestDAO itrDao;
	private TrainingScheduleDAO tsDao;
	private TrainingSchedule sched;
	private InternalTrainingRequest itr;
	private InputForm iForm;
	private TrainingManagementStatus tms;
	private TrainingManagementStatusDAO tmsdao;
	
	public InputFormServices()
	{
		itrDao = new InternalTrainingRequestDAO();
		tsDao = new TrainingScheduleDAO();
		iForm =  new InputForm();
	}
	
	public void statusChange(int training_id, int status)
	{
		String message = "";
		switch(status)
		{
		case 103:
			message = "Internal Training Request started";
			
			break;
//		case 104:
//			message = "Looking for available internal trainers";
//			break;
		case 105:
			message = "Internal Training Request Information saved.";
			break;
//		case 106:
//			message = "Internal Training Request ";
//			break;
//		case 107:
//			message = "Internal Training Request ";
//			break;
//		case 108:
//			message = "Internal Training Request ";
//			break;
//		case 109:
//			message = "Internal Training Request ";
//			break;
		case 110:
			message = "Internal Training Request at PM for Final Approval";
			//function to ask PM to choose
			break;
		case 121:
			message = "Internal Training Request declined by PM / Awaiting next action";
			//ask spoc if they want to move to next type of training or restart internal process
			//if to decide to move back or continue
			break;
		case 122:
			message = "Internal Training Request approved by PM / Ready for training";
			//move automatically or wait for the start date
			break;
		case 130:
			message = "Internal Training Executive Workflow Started.";
			break;
		case 203:
			message = "Development Training Request started";
			break;
		case 204:
			message = "Confirming details with available development trainers";
			break;
		case 205:
			message = "Confirming details with development trainer's manager";
			break;
		case 206:
			message = "Awaiting PM for development trainer approval";
			break;
		case 207: 
			message = "Confirming logistical details for development training";
			break;
		case 208: 
			message = "";
			break;
		case 209: 
			//DDT
			break;
		case 210:
			message = "Development Training Request at PM for final approval";
			break;
		case 221:
			message = "Development Training Request declined by PM / Awaiting next action";
			break;
		case 222:
			message = "Development Training Request approved by PM / Ready for training";
			break;
		case 230:
			message = "Development Training in progress";
			break;
		case 303:
			message = "Vendor Training Request started";
			break;
		case 304:
			message = "Vendor Training Request ";
			break;
		case 305:
			message = "Vendor Training Request ";
			break;
		case 306:
			message = "Vendor Training Request ";
			break;
		case 307:
			message = "Vendor Training Request ";
			break;
		case 308:
			message = "Vendor Training Request ";
			break;
		case 309:
			message = "Vendor Training Request ";
			break;
		case 310:
			message = "Vendor Training Request at PM for Final Approval";
			break;
		case 321:
			message = "Vendor Training Request declined by PM / awaiting next action";
			break;
		case 322:
			message = "Vendor Training Request approved by PM / ready for training";
			break;
		case 330:
			message = "Vendor Training in progress";
			break;
		case 150:
			message = "Training completed / Archiving request";
			break;
		default:
			break;
		}
		TrainingRequestLogDAO rl = new TrainingRequestLogDAO();
		rl.insertTrainingRequestLog(training_id, status, message);
		TrainingManagementStatusDAO ms = new TrainingManagementStatusDAO();
		ms.updateTrainingManagementStatus(training_id, status);
	}

	public void checkForStatusUpdates(InternalTrainingRequest itr, TrainingSchedule ts){
		//debug
		System.out.println("CheckForStatusUpdates Start");
		
		GetStatusDAO gsdao = new GetStatusDAO();
		TrainingManagementStatusDAO tmsdao = new TrainingManagementStatusDAO();
		int status = gsdao.getStatusByTrainingRequest(itr.getInternal_training_id());
		InputFormServices ifs = new InputFormServices();
		
		switch(status){
			//case 100:
			case 103: //Just moved to In Process
				//debug
				System.out.print("Status is 103. ");
				try{
					System.out.println("Start Date is fine.");
					System.out.println(ts.getTraining_end_date());
					System.out.println("End Date is fine.");
					System.out.println(ts.getTraining_break_down());
					System.out.println("Breakdown is fine.");
					System.out.println(ts.getTraining_url());
					if(itr.getTraining_type().equals("classroom")){
						try{
							System.out.println(ts.getTraining_city());
							System.out.println("City is fine.");
							System.out.println(ts.getTraining_state());
							System.out.println("State is fine.");
							System.out.println(ts.getTraining_country());
							System.out.println("Country is fine.");
							System.out.println(ts.getTraining_zipcode());
							System.out.println("Zip is fine.");
							System.out.println(ts.getTraining_time_zone());
							System.out.println("Time Zone is fine.");
							System.out.println(ts.getTraining_location()); 
							System.out.println("Location is fine.");
							System.out.println(ts.getTraining_room_number());
							System.out.println("Room Number is fine.");
							System.out.println(ts.getTraining_start_date());
							System.out.print("All fields are filled. ");
							tsDao.updateTrainingSchedule(ts.getTraining_schedule_id(), ts.getTraining_city(), ts.getTraining_state(), ts.getTraining_country(), ts.getTraining_zipcode(), ts.getTraining_time_zone(), ts.getTraining_location(), ts.getTraining_room_number(), ts.getTraining_start_date(), ts.getTraining_end_date(), ts.getTraining_break_down(), null, null);
							ifs.statusChange(itr.getTraining_request_id(), 110);
						}
						catch(Exception e){
							System.out.println("There are null classroom fields.");
						}
					} 
					else if(itr.getTraining_type().equals("virtual")){
						try{
							System.out.println("URL is fine.");
							System.out.println(ts.getTraining_phone());
							System.out.println("Phone is fine.");
							//debug
							System.out.print("All fields are filled. ");
							tsDao.updateTrainingSchedule(ts.getTraining_schedule_id(), null, null, null, null, ts.getTraining_time_zone(), null, null, ts.getTraining_start_date(), ts.getTraining_end_date(), ts.getTraining_break_down(), ts.getTraining_url(), ts.getTraining_phone());
							ifs.statusChange(itr.getTraining_request_id(), 110);
						} 
						catch(Exception e){
							System.out.println("There are null virtual fields.");
						}
					} else {
						System.out.println("Invalid mode.");
					}
				}
				catch(Exception e){
					System.out.print("Some fields are null. ");
					ifs.statusChange(itr.getTraining_request_id(), 105);
				}
				break;
			case 105: //In Process partially saved, not ready to go to PM
				String date = ts.getTraining_end_date();
				System.out.println(date);
				try{
					System.out.println("Start Date is fine.");
					System.out.println(ts.getTraining_end_date());
					System.out.println("End Date is fine.");
					System.out.println(ts.getTraining_break_down());
					System.out.println("Breakdown is fine.");
					System.out.println(ts.getTraining_url());
					
					String mode = itr.getTraining_type();
					System.out.println("Mode is [" +mode+"]" );
					System.out.println("Mode equals " + mode.equals("classroom"));
					//if(mode == "classroom"){
					if(mode.equals("classroom")){
						System.out.println("Training Type is classroom.");
						try{
							System.out.println(ts.getTraining_city());
							System.out.println("City is fine.");
							System.out.println(ts.getTraining_state());
							System.out.println("State is fine.");
							System.out.println(ts.getTraining_country());
							System.out.println("Country is fine.");
							System.out.println(ts.getTraining_zipcode());
							System.out.println("Zip is fine.");
							System.out.println(ts.getTraining_time_zone());
							System.out.println("Time Zone is fine.");
							System.out.println(ts.getTraining_location()); 
							System.out.println("Location is fine.");
							System.out.println(ts.getTraining_room_number());
							System.out.println("Room Number is fine.");
							System.out.println(ts.getTraining_start_date());
							System.out.print("All fields are filled. ");
							tsDao.updateTrainingSchedule(ts.getTraining_schedule_id(), ts.getTraining_city(), ts.getTraining_state(), ts.getTraining_country(), ts.getTraining_zipcode(), ts.getTraining_time_zone(), ts.getTraining_location(), ts.getTraining_room_number(), ts.getTraining_start_date(), ts.getTraining_end_date(), ts.getTraining_break_down(), null, null);
							System.out.println("Schedule updated.");
							ifs.statusChange(itr.getTraining_request_id(), 110);
							System.out.println("Status changed.");
						}
						catch(Exception e){
							System.out.println("There are null classroom fields.");
						}
					} 
					else if(mode.equals("virtual")){
						System.out.println("Mode is Virtual.");
						try{
							System.out.println("URL is fine.");
							System.out.println(ts.getTraining_phone());
							System.out.println("Phone is fine.");
							//debug
							System.out.print("All fields are filled. ");
							tsDao.updateTrainingSchedule(ts.getTraining_schedule_id(), null, null, null, null, ts.getTraining_time_zone(), null, null, ts.getTraining_start_date(), ts.getTraining_end_date(), ts.getTraining_break_down(), ts.getTraining_url(), ts.getTraining_phone());
							ifs.statusChange(itr.getTraining_request_id(), 110);
						} 
						catch(Exception e){
							System.out.println("There are null virtual fields.");
						}
					} else {
						System.out.println("Invalid mode.");
					}
				
				}
				catch(Exception e){
					System.out.print("Some fields are null. ");
				}
				break;
			case 121:
				//debug
				System.out.print("Status is 121. ");
				ifs.statusChange(itr.getTraining_request_id(), 105);
				break;
			case 122:
				//debug
				System.out.print("Status is 122. ");
				ifs.statusChange(itr.getTraining_request_id(), 130);
				break;
			case 130:
				//debug
				System.out.print("Status is 130. ");
				//if ews is finished, push to 150 for archival.
				break;
			default:
				System.out.println("Somehting went wrong.");
				break;
		}
		//debug
		System.out.println("End checking for updates.");
		System.out.println();
	}
	
	public void saveForm(int trainingID, int trainerID, String trainerName, String mode, String address, String city,
			String roomNum, String url, String phoneNum, String startDate, String endDate, String startTime,
			String endTime, String description, String state, String country, String zipCode, String timeZone,
			String schedBreakdown)
	{
		itr = itrDao.getInternalTrainingRequestByTrainingRequestId(trainingID);
		int sID;
			
		String startDateTime = startDate + " " + startTime;
		String endDateTime = endDate + " " + endTime;

		//convert calendar insert date type to database format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
//		System.out.println("StartDateTime is [" + startDateTime + "]");
//		System.out.println("EndDateTime is [" + endDateTime + "]");
		
		if(startDateTime.length() > 10){
			if (!(startDateTime.indexOf("-") == 4)) {
				Date dateStart = new Date(startDateTime);
				startDateTime = sdf.format(dateStart);
			}
		}
		if(endDateTime.length() > 10){ //trim() != ""){
			if (!(endDateTime.indexOf("-") == 4)) {
				Date dateEnd = new Date(endDateTime);
				endDateTime = sdf.format(dateEnd);
			}
		}

		
		if(itr.getSchedule() == 0)
		{
			sID = tsDao.insertTrainingSchedule(city, state, country, zipCode, timeZone, address, roomNum, startDateTime,
					endDateTime, schedBreakdown, url, phoneNum);
			itr.setSchedule(sID);
			itrDao.updateInternalTrainingRequest(trainingID, sID, mode, trainerID, description);
		} else
		{
			sched = tsDao.getTrainingScheduleByInternalTrainingRequest(itr.getSchedule());
			if(city == null){
				sched.setTraining_city(null);
			}else{
				sched.setTraining_city(city);
			}
			if(state == null){
				sched.setTraining_state(null);
			}
			sched.setTraining_state(state);
			sched.setTraining_country(country);
			sched.setTraining_zipcode(zipCode);
			sched.setTraining_time_zone(timeZone);
			sched.setTraining_location(address);
			sched.setTraining_room_number(roomNum);
			sched.setTraining_start_date(startDateTime);
			sched.setTraining_end_date(endDateTime);
			sched.setTraining_break_down(schedBreakdown);
			sched.setTraining_url(url);
			sched.setTraining_phone(phoneNum);
			sID = sched.getTraining_schedule_id();
			
			System.out.print(sched.getTraining_end_date());
			
			tsDao.updateTrainingSchedule(trainingID, city, state, country, zipCode, timeZone, address, roomNum,
					startDateTime, endDateTime, schedBreakdown, url, phoneNum);
			itrDao.updateInternalTrainingRequest(trainingID, sID, mode, trainerID, description);
			new InputFormServices().checkForStatusUpdates(itr, sched);
		}
	}
	public InputForm loadForm(int trainingID)
	{
		GetStatusDAO gs = new GetStatusDAO();
		itr = itrDao.getInternalTrainingRequestByTrainingRequestId(trainingID);
		
		if (itr.getSchedule() != 0){
			sched = tsDao.getTrainingSchedule(trainingID);
		}
		
		int trainer = itr.getConfirmed_trainer();
		int scheduleid = itr.getSchedule();
		String startDateTime = "";
		String endDateTime = "";
		String name = "";
		String start[] = new String[2];
		String end[] = new String[2];
		if(trainer == 0){
			name = " ";
		} else {
			name = new GetNameDAO().getTrainerName(itr.getConfirmed_trainer()).get(0).getEmployee().getNames();
		}
		if(scheduleid == 0){
			start[0] = " ";
			start[1] = " ";
			end[0] = " ";
			end[1] = " ";
		} else {
			startDateTime = sched.getTraining_start_date(); //.split(" ");
			endDateTime = sched.getTraining_end_date(); //.split(" ");
			if(startDateTime == null && endDateTime == null){
				start[0] = " ";
				start[1] = " ";
				end[0] = " ";
				end[1] = " ";
			}else{
				start = startDateTime.split(" ");
				end = endDateTime.split(" ");
			}
		}
		
		iForm.setTrainingID(trainingID);
		int trainerid = itr.getConfirmed_trainer();
		if(trainerid > 0){
			iForm.setTrainerID(Integer.toString(trainerid));
		} else{
			iForm.setTrainerID(null);
		}
		
		iForm.setTrainerName(name);
		iForm.setMode(itr.getTraining_type());
		iForm.setStartDate(start[0]);
		iForm.setEndDate(end[0]);
		iForm.setStartTime(start[1]);
		iForm.setEndTime(end[1]);
		iForm.setDescription(itr.getDescription_of_status());		
		if(itr.getSchedule() != 0){
			iForm.setAddress(sched.getTraining_location());
			iForm.setCity(sched.getTraining_city());
			iForm.setRoomNum(sched.getTraining_room_number());
			iForm.setState(sched.getTraining_state());
			iForm.setCountry(sched.getTraining_country());
			iForm.setZipCode(sched.getTraining_zipcode());
			iForm.setTimeZone(sched.getTraining_time_zone());
			iForm.setSchedBreakdown(sched.getTraining_break_down());
			iForm.setUrl(sched.getTraining_url());
			iForm.setPhoneNum(sched.getTraining_phone());
		} else {
			iForm.setAddress(" ");
			iForm.setCity(" ");
			iForm.setRoomNum(" ");
			iForm.setState(" ");
			iForm.setCountry(" ");
			iForm.setZipCode(" ");
			iForm.setTimeZone(" ");
			iForm.setSchedBreakdown(" ");
			iForm.setUrl(" ");
			iForm.setPhoneNum(" ");
		}
		int status = gs.getStatusByTrainingRequest(trainingID);
		String statusdesc = "";
		switch(status){
			case 100:
				statusdesc = "New Request";
				break;
			case 103:
				statusdesc = "In Process";
				break;
			case 105:
				statusdesc = "In Process";
				break;
			case 110:
				statusdesc = "Pending Approval";
				break;
		}
		iForm.setStatusdesc(statusdesc);
		
		return iForm;
	}
}