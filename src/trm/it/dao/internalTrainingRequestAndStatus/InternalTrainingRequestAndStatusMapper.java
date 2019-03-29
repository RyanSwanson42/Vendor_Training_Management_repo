package trm.it.dao.internalTrainingRequestAndStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.it.dao.internalTrainingRequest.InternalTrainingRequest;
import trm.vt.dao.employee.Employee;
import trm.vt.dao.trainingRequest.TrainingRequest;

public class InternalTrainingRequestAndStatusMapper implements RowMapper<InternalTrainingRequestAndStatus>{

	
	public InternalTrainingRequestAndStatus mapRow(ResultSet result, int arg1) throws SQLException {
		
		InternalTrainingRequest itr = new InternalTrainingRequest();
		itr.setInternal_training_id(result.getInt(1));
		
		Employee employee = new Employee();
		employee.setFirst_name(result.getString(2));
		employee.setLast_name(result.getString(3));
		
		TrainingRequest tr = new TrainingRequest();
		tr.setRequest_training_module(result.getString(4));
		tr.setRequest_training_module_scope(result.getString(5));
		tr.setRequest_training_mode(result.getString(6));
		
		String start_date = result.getString(7);
		String[] startdate = start_date.split(" ");
		tr.setRequest_start_date(startdate[0]);
		
		String end_date = (result.getString(8));
		String[] enddate = end_date.split(" ");
		tr.setRequest_end_date(enddate[0]);
		
		tr.setRequest_location(result.getString(9));
		tr.setRequest_approx_participant(result.getInt(10));
		tr.setTime_requested(result.getString(11));
		tr.setJustification_of_request(result.getString(12));
		
		InternalTrainingRequestAndStatus trs = new InternalTrainingRequestAndStatus();
		trs.setEmployee(employee);
		trs.setTrainingRequest(tr);
		 
		trs.setInternalTrainingRequest(itr);
		
		return trs;
	}

}
