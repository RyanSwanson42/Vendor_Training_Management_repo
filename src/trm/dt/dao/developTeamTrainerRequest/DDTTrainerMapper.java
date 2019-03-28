package trm.dt.dao.developTeamTrainerRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DDTTrainerMapper implements RowMapper<DDTTrainer>
{
	public DDTTrainer mapRow(ResultSet result, int arg1) throws SQLException {
		
		
		DDTTrainer ddtrnr = new DDTTrainer();
		ddtrnr.setDtt_trainer_request_id(result.getInt("dtt_trainer_request_id"));
		ddtrnr.setRequest_sent_date(result.getTimestamp("request_sent_date"));
		ddtrnr.setTrainer_id(result.getInt("trainer_id"));
		ddtrnr.setSchedule_id(result.getInt("schedule_id"));
		ddtrnr.setTopic(result.getString("topic"));
		ddtrnr.setComments(result.getString("comments"));
		ddtrnr.setResponse(result.getString("response"));
		ddtrnr.setActive_status(result.getInt("active_status"));
		return ddtrnr;
	}

}
