package dbo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class Training_ParticipantsMapper implements RowMapper<Training_Participants>{

	@Override
	public Training_Participants mapRow(ResultSet rs, int arg1) throws SQLException {
		Training_Participants tpbuf = new Training_Participants();

		tpbuf.setTraining_participant_id(rs.getInt(1));
		tpbuf.setParticipant_employee_id(rs.getInt(2));
		tpbuf.setTraining_session_attended(rs.getInt(3));
		return tpbuf;
	}
}