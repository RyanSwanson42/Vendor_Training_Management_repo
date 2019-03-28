package bl;

import dao.getName.GetNameDAO;
import dao.getStatus.GetStatus;
import dao.getStatus.GetStatusDAO;
import dao.it.internalTrainer.InternalTrainer;
import dao.it.internalTrainer.InternalTrainerDAO;
import dao.it.internalTrainingRequest.InternalTrainingRequest;
import dao.it.internalTrainingRequest.InternalTrainingRequestDAO;
import dao.trainingManagementStatus.TrainingManagementStatusDAO;
import dao.trainingSchedule.TrainingSchedule;
import dao.trainingSchedule.TrainingScheduleDAO;

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
		if (sched == null)
		{
			sID = tsDao.insertTrainingSchedule(city, state, country, zipCode, timeZone, address, roomNum, startDate,
					endDate, schedBreakdown, url, phoneNum);
			itr.setSchedule(sID);
			itrDao.updateInternalTrainingRequest(trainingID, sID, mode, itr.getConfirmed_trainer(), itr.getExecutive(),
					description);
		} else
		{
			sched.setTraining_city(city);
			sched.setTraining_state(state);
			sched.setTraining_country(country);
			sched.setTraining_zipcode(zipCode);
			sched.setTraining_time_zone(timeZone);
			sched.setTraining_location(address);
			sched.setTraining_room_number(roomNum);
			sched.setTraining_start_date(startDate);
			sched.setTraining_end_date(endDate);
			sched.setTraining_break_down(schedBreakdown);
			sched.setTraining_url(url);
			sched.setTraining_phone(phoneNum);

			sID = sched.getTraining_schedule_id();
			tsDao.updateTrainingSchedule(trainingID, city, state, country, zipCode, timeZone, address, roomNum,
					startDate, endDate, schedBreakdown, url, phoneNum);
		}
	}

	public InputForm loadForm(int trainingID)
	{
		itr = itrDao.getInternalTrainingRequestByTrainingRequestId(trainingID);
		sched = tsDao.getTrainingSchedule(trainingID);
		String firstName = new GetNameDAO().getTrainerName(itr.getConfirmed_trainer()).get(0).getEmployee()
				.getFirst_name();
		String lastName = new GetNameDAO().getTrainerName(itr.getConfirmed_trainer()).get(0).getEmployee()
				.getLast_name();
		String startDateTime[] = sched.getTraining_start_date().split(" ");
		String endDateTime[] = sched.getTraining_end_date().split(" ");
		

		iForm.setTrainingID(trainingID);
		iForm.setTrainerID(itr.getConfirmed_trainer());
		iForm.setTrainerName(firstName + " " + lastName);
		iForm.setMode(itr.getTraining_type());
		iForm.setAddress(sched.getTraining_location());
		iForm.setCity(sched.getTraining_city());
		iForm.setRoomNum(sched.getTraining_room_number());
		iForm.setUrl(sched.getTraining_url());
		iForm.setPhoneNum(sched.getTraining_phone());
		iForm.setStartDate(startDateTime[0]);
		iForm.setEndDate(endDateTime[0]);
		iForm.setStartTime(startDateTime[1]);
		iForm.setEndTime(endDateTime[0]);
		iForm.setDescription(itr.getDescription_of_status());
		iForm.setState(sched.getTraining_state());
		iForm.setCountry(sched.getTraining_country());
		iForm.setZipCode(sched.getTraining_zipcode());
		iForm.setTimeZone(sched.getTraining_time_zone());
		iForm.setSchedBreakdown(sched.getTraining_break_down());

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
