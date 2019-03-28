package dao.getStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.spocMaster.SpocMaster;
import dao.trainingManagementStatus.TrainingManagementStatus;
import dao.trainingRequest.TrainingRequest;

public class GetStatusMapper implements RowMapper{
	public GetStatus mapRow(ResultSet result, int arg1) throws SQLException {
		SpocMaster spoc = new SpocMaster();
		spoc.setSpoc_vertical(result.getString("spoc_vertical"));

		TrainingManagementStatus tms = new TrainingManagementStatus();
		tms.setStatus(result.getInt("status"));
		tms.setTraining_request(result.getInt("training_request_id"));
		
		TrainingRequest tr = new TrainingRequest();
		tr.setTraining_request_id(result.getInt("training_request_id"));
		tr.setVertical(result.getString("vertical"));
		System.out.println(tr.getTraining_request_id());
		GetStatus gs = new GetStatus();
		gs.setSpoc(spoc);
		gs.setTrequest(tr);
		gs.setTms(tms);
		
		return gs;
	}
}