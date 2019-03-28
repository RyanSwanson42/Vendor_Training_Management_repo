package trm.pm.dbo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TrainingRequestLogMapper implements RowMapper<TrainingRequestLog>{

	@Override
	public TrainingRequestLog mapRow(ResultSet rs, int arg1) throws SQLException {
		TrainingRequestLog tbuf = new TrainingRequestLog();
		tbuf.setRequest_log_id(rs.getInt(1));
		tbuf.setTraining_request_id(rs.getInt(2));
		tbuf.setStatus_changed_to(rs.getInt(3));
		tbuf.setStatus_change_time(rs.getDate(4));
		tbuf.setDescription(rs.getString(5));
		return tbuf;
	}

}
