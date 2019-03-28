package trm.vt.dao.trainingRequestAndStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.vt.dao.employee.Employee;
import trm.vt.dao.trainingRequest.TrainingRequest;

public class TrainingRequestAndStatusMapper implements RowMapper<TrainingRequestAndStatus>{

    
    public TrainingRequestAndStatus mapRow(ResultSet result, int arg1) throws SQLException {
        
        TrainingRequest tr = new TrainingRequest();
        tr.setTraining_request_id(result.getInt(1));
        
        Employee employee = new Employee();
        employee.setFirst_name(result.getString(2));
        employee.setLast_name(result.getString(3));
        
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
        
        TrainingRequestAndStatus trs = new TrainingRequestAndStatus();
        
        trs.setTrainingRequest(tr);
        trs.setEmployee(employee);
        
        return trs;
    }
}