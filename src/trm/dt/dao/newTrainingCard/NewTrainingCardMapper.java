package trm.dt.dao.newTrainingCard;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class NewTrainingCardMapper implements RowMapper<NewTrainingCard>
 {

	@Override
	public NewTrainingCard mapRow(ResultSet result, int arg1) throws SQLException {

		NewTrainingCard ntc = new NewTrainingCard();
		ntc.setTraining_request_id(result.getInt("training_request_id"));
		ntc.setFirst_name(result.getString("first_name"));
		ntc.setLast_name(result.getString("last_name"));
		ntc.setRequest_training_module(result.getString("request_training_module"));
		ntc.setRequest_start_date(result.getTimestamp("request_start_date"));
		ntc.setStatus((result.getInt("Status")));
		return ntc;
	}

}
