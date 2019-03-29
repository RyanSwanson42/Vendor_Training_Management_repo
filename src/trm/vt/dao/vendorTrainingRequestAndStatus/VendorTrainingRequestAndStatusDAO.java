package trm.vt.dao.vendorTrainingRequestAndStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorTrainingRequestAndStatusDAO {

	ApplicationContext context;
	JdbcTemplate temp;

	public VendorTrainingRequestAndStatusDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	
	public List<VendorTrainingRequestAndStatus> getTrainingRequestDetail303(String vertical) {
		String sql = "select distinct v.vendor_training_request_id, e.first_name, e.last_name, \r\n" + 
				"        t.request_training_module, t.request_training_module_scope, \r\n" + 
				"        t.request_training_mode, t.request_start_date, t.request_end_date, \r\n" + 
				"        t.request_location, t.request_approx_participant, t.time_requested,\r\n" + 
				"        t.justification_of_request \r\n" + 
				"from employee e inner join training_request t on e.employee_id = t.requester_id\r\n" + 
				"inner join vendor_training_request v on t.training_request_id = v.training_request_id\r\n" + 
				"inner join training_management_status tms on t.training_request_id = tms.training_request_id\r\n" + 
				"where tms.status = 303 and t.vertical = ?";
		List<VendorTrainingRequestAndStatus> TrainingRequestAndStatus = temp.query(sql, new Object[] {vertical}, new VendorTrainingRequestAndStatusMapper());
		return TrainingRequestAndStatus;
	}
	
	public List<VendorTrainingRequestAndStatus> getTrainingRequestDetail330(String vertical) {
		String sql = "select distinct v.vendor_training_request_id, e.first_name, e.last_name, \r\n" + 
				"        t.request_training_module, t.request_training_module_scope, \r\n" + 
				"        t.request_training_mode, t.request_start_date, t.request_end_date, \r\n" + 
				"        t.request_location, t.request_approx_participant, t.time_requested,\r\n" + 
				"        t.justification_of_request \r\n" + 
				"from employee e inner join training_request t on e.employee_id = t.requester_id\r\n" + 
				"inner join vendor_training_request v on t.training_request_id = v.training_request_id\r\n" + 
				"inner join training_management_status tms on t.training_request_id = tms.training_request_id\r\n" + 
				"where tms.status = 330 and t.vertical = ?";
		List<VendorTrainingRequestAndStatus> TrainingRequestAndStatus = temp.query(sql, new Object[] {vertical}, new VendorTrainingRequestAndStatusMapper());
		return TrainingRequestAndStatus;
	}
	
	
}