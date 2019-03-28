package trm.vt.dao.trainingRequest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class TrainingRequestDAO {

	ApplicationContext context;
	JdbcTemplate temp;
	
	public TrainingRequestDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<TrainingRequest> getAllTrainerDetail() {
		String sql = "select * from training_request";
		List<TrainingRequest> TrainingRequestList = temp.query(sql, new TrainingRequestMapper());
		return TrainingRequestList; 
	}

	public void insertTrainingRequest(int requester_id, String vertical, String request_training_type, String request_training_module, String request_training_module_scope, String request_training_mode, String request_start_date, String request_end_date, String request_location, String request_time_zone, int request_approx_participant, int request_project_spoc, String time_requested, String justification_of_request){
		
		String sql = "insert into training_request values(training_id_request_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		temp.update(sql, new Object[]{requester_id, vertical, request_training_type,request_training_module, request_training_module_scope, request_training_mode,request_start_date ,request_end_date, request_location,request_time_zone,request_approx_participant,request_project_spoc,time_requested,justification_of_request});
	}
	
	public void deleteTrainingRequest(int training_request_id){
		
		String sql = "delete from training_request where training_request_id = ?";
		
		temp.update(sql, new Object[]{training_request_id});
	}
	
	public void updateTrainingRequest(int training_request_id,int requester_id, String vertical, String request_training_type, String request_training_module, String request_training_module_scope, String request_training_mode, String request_start_date, String request_end_date, String request_location, String request_time_zone, int request_approx_participant, int request_project_spoc, String time_requested, String justification_of_request){
		
		String sql = "update training_request set requester_id = ?, vertical = ?, request_training_type = ?, request_training_module = ?, request_training_module_scope = ?, request_training_mode = ?, request_start_date = ?, request_end_date = ?, request_location = ?, request_time_zone = ?, request_approx_participant = ?, request_project_spoc = ?, time_requested = ?, justification_of_request = ? where training_request_id = ?";
		
		temp.update(sql, new Object[]{requester_id, vertical, request_training_type,request_training_module, request_training_module_scope, request_training_mode,request_start_date ,request_end_date, request_location,request_time_zone,request_approx_participant,request_project_spoc,time_requested,justification_of_request, training_request_id});
	}
	
	public TrainingRequest getTrainingRequest(int training_request_id){
		
		String sql = "select * from training_request where training_request_id = ?";
		
		List<TrainingRequest> tr = temp.query(sql, new Object[]{training_request_id}, new TrainingRequestMapper());
		
		return tr.get(0);
	}
}
