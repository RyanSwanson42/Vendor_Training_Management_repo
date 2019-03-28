package trm.pm.dbo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingManagementStatusMapper implements RowMapper<TrainingManagementStatus>{

	@Override
	public TrainingManagementStatus mapRow(ResultSet rs, int arg1) throws SQLException {
		TrainingManagementStatus tbuf = new TrainingManagementStatus();
		tbuf.setTraining_management_status_id(rs.getInt(1));
		tbuf.setTraining_request_id(rs.getInt(2));
		tbuf.setStatus(rs.getInt(3));
		return tbuf;
	}

}
