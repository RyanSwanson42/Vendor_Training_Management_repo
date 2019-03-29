package trm.it.dao.internalTrainingRequestAndStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InternalTrainingRequestAndStatusDAO {

	ApplicationContext context;
	JdbcTemplate temp;

	public InternalTrainingRequestAndStatusDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	
	public List<InternalTrainingRequestAndStatus> getTrainingRequestDetail103(String vertical) {
		String sql = "select distinct i.internal_training_id, e.first_name, e.last_name, \r\n" + 
				"        t.request_training_module, t.request_training_module_scope, \r\n" + 
				"        t.request_training_mode, t.request_start_date, t.request_end_date, \r\n" + 
				"        t.request_location, t.request_approx_participant, t.time_requested,\r\n" + 
				"        t.justification_of_request \r\n" + 
				"from employee e inner join training_request t on e.employee_id = t.requester_id\r\n" + 
				"inner join internal_training_request i on t.training_request_id = i.training_request_id\r\n" + 
				"inner join training_management_status tms on t.training_request_id = tms.training_request_id\r\n" + 
				"where tms.status = 103 and t.vertical = ?";
		List<InternalTrainingRequestAndStatus> TrainingRequestAndStatus = temp.query(sql, new Object[] {vertical}, new InternalTrainingRequestAndStatusMapper());
		return TrainingRequestAndStatus;
	}
	
	public List<InternalTrainingRequestAndStatus> getTrainingRequestDetail130(String vertical) {
		String sql = "select distinct i.internal_training_id, e.first_name, e.last_name, \r\n" + 
				"        t.request_training_module, t.request_training_module_scope, \r\n" + 
				"        t.request_training_mode, t.request_start_date, t.request_end_date, \r\n" + 
				"        t.request_location, t.request_approx_participant, t.time_requested,\r\n" + 
				"        t.justification_of_request \r\n" + 
				"from employee e inner join training_request t on e.employee_id = t.requester_id\r\n" + 
				"inner join internal_training_request i on t.training_request_id = i.training_request_id\r\n" + 
				"inner join training_management_status tms on t.training_request_id = tms.training_request_id\r\n" + 
				"where tms.status = 130 and t.vertical = ?";
		List<InternalTrainingRequestAndStatus> TrainingRequestAndStatus = temp.query(sql, new Object[] {vertical}, new InternalTrainingRequestAndStatusMapper());
		return TrainingRequestAndStatus;
	}
	
	
}