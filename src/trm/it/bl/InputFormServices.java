package trm.it.bl;

import java.text.SimpleDateFormat;
import java.util.Date;

import trm.it.dao.getName.GetNameDAO;
import trm.it.dao.internalTrainingRequest.InternalTrainingRequest;
import trm.it.dao.internalTrainingRequest.InternalTrainingRequestDAO;
import trm.it.dao.trainingSchedule.TrainingSchedule;
import trm.it.dao.trainingSchedule.TrainingScheduleDAO;

public class InputFormServices
{
	private InternalTrainingRequestDAO itrDao;
	private TrainingScheduleDAO tsDao;
	private TrainingSchedule sched;
	private InternalTrainingRequest itr;
	private InputForm iForm;
	
	
	public InputFormServices()
	{
		itrDao = new InternalTrainingRequestDAO();
		tsDao = new TrainingScheduleDAO();
		iForm =  new InputForm();
	}
	
	public void saveForm(int trainingID, int trainerID, String trainerName, String mode, String address, String city,
			String roomNum, String url, String phoneNum, String startDate, String endDate, String startTime,
			String endTime, String description, String state, String country, String zipCode, String timeZone,
			String schedBreakdown)
	{
		itr = itrDao.getInternalTrainingRequestByTrainingRequestId(trainingID);
		sched = tsDao.getTrainingSchedule(trainingID);
		int sID;
			
		String startDateTime = startDate + " " + startTime;
		String endDateTime = endDate + " " + endTime;

		//convert calander insert date type to database format
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		if (!(startDateTime.indexOf("-") == 4)) {
			Date dateStart = new Date(startDateTime);
			startDateTime = sdf.format(dateStart);
		}
		if (!(endDateTime.indexOf("-") == 4)) {
			Date dateEnd = new Date(endDateTime);
			endDateTime = sdf.format(dateEnd);
		}
		

		
		if (sched == null)
		{
			sID = tsDao.insertTrainingSchedule(city, state, country, zipCode, timeZone, address, roomNum, startDateTime,
					endDateTime, schedBreakdown, url, phoneNum);
			itr.setSchedule(sID);
			itrDao.updateInternalTrainingRequest(trainingID, sID, mode, trainerID, description);
		} else
		{
			sched.setTraining_city(city);
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
			itrDao.updateInternalTrainingRequest(trainingID, sID, mode, trainerID, description);
			tsDao.updateTrainingSchedule(trainingID, city, state, country, zipCode, timeZone, address, roomNum,
					startDateTime, endDateTime, schedBreakdown, url, phoneNum);
		}
	}
	public InputForm loadForm(int trainingID)
	{
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
			start = startDateTime.split(" ");
			end = endDateTime.split(" ");
		}
		
		iForm.setTrainingID(trainingID);
		iForm.setTrainerID(itr.getConfirmed_trainer());
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

		return iForm;
	}

//	public static void main(String[] args)
//	{
//		InputFormServices ifs = new InputFormServices();
//		InputForm temp = ifs.loadForm(10005);
//		
//		System.out.println(temp.getAddress());
//		System.out.println(temp.getCity());
//		System.out.println(temp.getTrainerName());
//	}

}
