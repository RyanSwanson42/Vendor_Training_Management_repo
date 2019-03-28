package trm.dt.trial.DDTProject;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DTTNewRequestCardMapper implements RowMapper<DTTNewRequestCard> {

	@Override
	public DTTNewRequestCard mapRow(ResultSet result, int arg1) throws SQLException {
		DTTNewRequestCard card = new DTTNewRequestCard();
		
		card.setRequestId(result.getInt("training_request_id"));
		card.setFirstName(result.getString("first_name"));
		card.setLastName(result.getString("last_name"));
		card.setTrainingModule(result.getString("request_training_module"));
		
		return card;
	}

}
