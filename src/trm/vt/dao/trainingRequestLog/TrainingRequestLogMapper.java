package trm.vt.dao.trainingRequestLog;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingRequestLogMapper implements RowMapper<TrainingRequestLog>{

	public TrainingRequestLog mapRow(ResultSet result, int arg1)
			throws SQLException {
		
		TrainingRequestLog trl = new TrainingRequestLog();
		
		trl.setRequest_log_id(result.getInt(1));
		trl.setTraining_request_id(result.getInt(2));
		trl.setStatus_changed_to(result.getInt(3));
		trl.setStatus_change_time(result.getString(4));
		trl.setDescription(result.getString(5));
		
		return trl;
	}
}
