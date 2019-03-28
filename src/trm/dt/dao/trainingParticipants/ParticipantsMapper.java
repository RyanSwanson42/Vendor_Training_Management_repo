package trm.dt.dao.trainingParticipants;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ParticipantsMapper implements RowMapper<Participants> 
{

	public Participants mapRow(ResultSet result, int arg1) throws SQLException {
		
		Participants parts = new Participants();
		parts.setTraining_participant_id(result.getInt("training_participant_id"));
		parts.setParticipant_employee_id(result.getInt("participant_employee_id"));
		parts.setTraining_session_attended(result.getInt("training_session_attended"));
		return parts;
	}

}
