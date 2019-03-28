package trm.dt.dao.trainingRequestLog;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class RequestLogMapper implements RowMapper<RequestLog> 
{

	public RequestLog mapRow(ResultSet result, int arg1) throws SQLException {
		
		RequestLog rl = new RequestLog();
		rl.setRequest_log_id(result.getInt("request_log_id"));
		rl.setTraining_request_id(result.getInt("training_request_id"));
		rl.setStatus_changed_to(result.getInt("status_changed_to"));
		rl.setStatus_change_time(result.getTimestamp("status_change_time"));
		rl.setDescription(result.getString("description"));
		return rl;
	}

}
