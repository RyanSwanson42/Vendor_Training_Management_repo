package DDTProject;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;


import jt.MyTemplate;

public class DTTdaoServices {
	MyTemplate objTemplate = new MyTemplate();
	JdbcTemplate temp = objTemplate.getTemplate();
	
	public List<DTTProcessingCard> getRequestsProcessing()
	{
		String query = "SELECT tr.training_request_id, e.last_name, e.first_name, tr.request_training_type, tr.request_training_module, tr.request_training_module_scope, tr.request_start_date, tr.request_end_date, tr.request_location, tr.request_approx_participant FROM training_request tr INNER JOIN employee e ON tr.requester_id = e.employee_id";
		return temp.query(query, new DTTProcessingCardMapper());
	}
	
	public List<DTTNewRequestCard> getNewRequests()
	{
		String query = "SELECT tr.training_request_id, e.last_name, e.first_name, tr.request_training_module FROM training_request tr INNER JOIN employee e ON tr.requester_id = e.employee_id INNER JOIN training_management_status tms ON tms.training_request_id = tr.training_request_id where tms.status = 100";
		return temp.query(query, new DTTNewRequestCardMapper());
	}
	public List<TrainingSchedule> getTrainingSchedule()
	{
		String query = "select * from Training_Schedule";
		return temp.query(query, new TrainingScheduleMapper());
	}
	
	public static void main(String[] args) {
		System.out.println(new DTTdaoServices().getTrainingSchedule());
	}
}
