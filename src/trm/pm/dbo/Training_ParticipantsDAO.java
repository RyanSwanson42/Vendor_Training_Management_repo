package dbo;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class Training_ParticipantsDAO {

	ApplicationContext context;
	JdbcTemplate temp;

	public Training_ParticipantsDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}

	public boolean insertTraining_Participants(int participant_employee_id, int training_session_attended) {
		String sql = "insert into training_participants values(training_participant_seq.nextval,?,?)";
		int num = temp.update(sql, new Object[]{participant_employee_id, training_session_attended});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteTraining_Participants(int training_participant_id) {
		String sql = "delete from training_participants where training_participant_id=?";
		int num = temp.update(sql, new Object[]{training_participant_id});
		
		if(num == 1) {
			return true;
		}
		return false;
	}

	public boolean updateTraining_Participants(int training_participant_id, int participant_employee_id, int training_session_attended) {
		String sql = "update training_participants set participant_employee_id=?, training_session_attended=? where training_participant_id=?";
		int num = temp.update(sql, new Object[]{participant_employee_id, training_session_attended, training_participant_id});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public List<Training_Participants> getAllTraining_Participants() {
		String sql = "select * from training_participants";
		return temp.query(sql,new Training_ParticipantsMapper());
	}
	
	public List<Training_Participants> getAllTraining_ParticipantsBySession(int training_session_attended) {
		String sql = "select * from training_participants where training_session_attended=?";
		return temp.query(sql,new Object[]{training_session_attended},new Training_ParticipantsMapper());
	}

	public Training_Participants getTraining_Participants(int training_participant_id) {
		String sql = "select * from training_participants where training_participant_id=?";
		List<Training_Participants> tp = temp.query(sql, new Object[]{training_participant_id},new Training_ParticipantsMapper());
		return tp.get(0);
	}
}