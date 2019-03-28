package trm.dt.dao.developTeamTrainingRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class DDTTrainingMapper implements RowMapper<DDTTraining> 
{
	public DDTTraining mapRow(ResultSet result, int arg1) throws SQLException {
		DDTTraining ddtrng = new DDTTraining();
		ddtrng.setDtt_training_id(result.getInt("Dtt_training_id"));
		ddtrng.setTraining_request_id(result.getInt("training_request_id"));
		ddtrng.setTrainer_request_id(result.getInt("trainer_request_id"));
		ddtrng.setSchedule_id(result.getInt("schedule_id"));
		ddtrng.setExecutive_id(result.getInt("executive_id"));
		ddtrng.setTrainer_approval_mail(result.getString("trainer_approval_mail"));
		ddtrng.setTrainer_manager_approval_mail(result.getString("trainer_manager_approval_mail"));
		ddtrng.setDescription_of_status(result.getString("description_of_status"));
		return ddtrng;
	}

}
