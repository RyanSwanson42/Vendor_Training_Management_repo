package trm.vt.dao.trainingRequestAndStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingRequestAndStatusDAO {
	
	ApplicationContext context;
	JdbcTemplate temp;

	public TrainingRequestAndStatusDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<TrainingRequestAndStatus> getTrainingRequestDetail100() {
		
		String sql = "select t.TRAINING_REQUEST_ID, e.first_name, e.last_name, t.request_training_module, t.request_training_module_scope, \r\n" + 
				"t.request_training_mode, t.request_start_date, t.request_end_date, \r\n" + 
				"t.request_location, t.request_approx_participant, t.time_requested,\r\n" + 
				"t.justification_of_request from employee e \r\n" + 
				"inner join spoc_master sm\r\n" + 
				"on e.VERTICAL = sm.SPOC_VERTICAL\r\n" + 
				"inner join training_request t \r\n" + 
				"on e.employee_id = t.requester_id\r\n" + 
				"inner join training_management_status tms \r\n" + 
				"on t.training_request_id = tms.training_request_id\r\n" + 
				"where tms.status = 100";
		
		List<TrainingRequestAndStatus> trs = temp.query(sql, new TrainingRequestAndStatusMapper());
		
		return trs;
	}
	
}
