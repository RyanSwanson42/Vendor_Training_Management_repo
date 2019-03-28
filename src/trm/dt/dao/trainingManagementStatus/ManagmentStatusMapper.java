package trm.dt.dao.trainingManagementStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ManagmentStatusMapper implements RowMapper<ManagmentStatus> 
{

	public ManagmentStatus mapRow(ResultSet result, int arg1) throws SQLException {
		
		
		ManagmentStatus ms = new ManagmentStatus();
		ms.setTraining_management_status_id(result.getInt("training_management_status_id"));
		ms.setTraining_request_id(result.getInt("training_request_id"));
		ms.setStatus(result.getInt("status"));
		return ms;
	}

}
