package trm.dt.trial.DDTProject;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import trm.dt.jt.MyTemplate;


public class DTTdaoServices {
	MyTemplate objTemplate = new MyTemplate();
	JdbcTemplate temp = objTemplate.getTemplate();
	
	public List<DTTProcessingCard> getRequestsProcessing(String vertical)
	{
		String query = "select dtt.dtt_training_id, e.first_name, e.last_name,t.request_training_module, t.request_training_module_scope, t.request_training_mode, t.request_start_date, t.request_end_date, t.request_location, t.request_approx_participant, t.time_requested,t.justification_of_request from employee e inner join training_request t on e.employee_id = t.requester_id inner join develop_team_training_request dtt on t.training_request_id = dtt.training_request_id inner join training_management_status tms on t.training_request_id = tms.training_request_id where tms.status = 203 and t.vertical = ?";
		
		return temp.query(query,new Object[] {vertical}, new DTTProcessingCardMapper());
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
