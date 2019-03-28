package dao.trainingRequest;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import dao.employee.Employee;
import dao.employee.EmployeeDAO;
import dao.employee.EmployeeMapper;
public class TrainingRequestMapper implements RowMapper<TrainingRequest>{
	public TrainingRequest mapRow(ResultSet result, int arg1)
			throws SQLException {
		TrainingRequest tr = new TrainingRequest();
		tr.setTraining_request_id(result.getInt("training_request_id"));
		tr.setRequester(result.getInt("requester_id"));
		tr.setVertical(result.getString("vertical"));
		tr.setRequest_training_type(result.getString("request_training_type"));
		tr.setRequest_training_module(result.getString("request_training_module"));
		tr.setRequest_training_module_scope(result.getString("request_training_module_scope"));
		tr.setRequest_training_mode(result.getString("request_training_module"));
		tr.setRequest_start_date(result.getString("request_start_date"));
		tr.setRequest_end_date(result.getString("request_end_date"));
		tr.setRequest_location(result.getString("request_location"));
		tr.setRequest_time_zone(result.getString("request_time_zone"));
		tr.setRequest_approx_participant(result.getInt("request_approx_participant"));
		tr.setTime_requested(result.getString("time_requested"));
		tr.setJustification_of_request(result.getString("justification_of_request"));
		return tr;
	}
}