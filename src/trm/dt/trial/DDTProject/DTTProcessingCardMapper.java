package trm.dt.trial.DDTProject;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class DTTProcessingCardMapper implements RowMapper<DTTProcessingCard> {

	@Override
	public DTTProcessingCard mapRow(ResultSet result, int arg1) throws SQLException {
		DTTProcessingCard card = new DTTProcessingCard();
		
		card.setRequestId(result.getInt("dtt_training_id"));
		card.setLastName(result.getString("last_name"));
		card.setFirstName(result.getString("first_name"));
		card.setTrainingType(result.getString("request_training_mode"));
		card.setTrainingModule(result.getString("request_training_module"));
		card.setTrainingModuleScope(result.getString("request_training_module_scope"));
		card.setStartDate(result.getString("request_start_date"));
		card.setEndDate(result.getString("request_end_date"));
		card.setLocation(result.getString("request_location"));
		card.setApproxParticipants(result.getInt("request_approx_participant"));
		
		return card;
	}

}
