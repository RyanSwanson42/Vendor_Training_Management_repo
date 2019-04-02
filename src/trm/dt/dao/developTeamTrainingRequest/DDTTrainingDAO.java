package trm.dt.dao.developTeamTrainingRequest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DDTTrainingDAO {
	ApplicationContext context;
	public JdbcTemplate temp;

	public DDTTrainingDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}

	public List<DDTTraining> getDDTTrainingList() {
		List<DDTTraining> DDTTrainingList = temp.query("select * from Develop_Team_Training_Request", new Object[] {},
				new DDTTrainingMapper());
		return DDTTrainingList;
	}

	public void updateTrainingRequest(int Dtt_training_id, int schedule_id, int executive_id,
			String trainer_approval_mail, String trainer_manager_approval_mail, String description_of_status) {
		temp.update(
				"update Develop_Team_Training_Request set schedule_id=?,executive_id=?,"
						+ "trainer_approval_mail=?,trainer_manager_approval_mail=?,"
						+ "description_of_status=? where Dtt_training_id=?",
				new Object[] { schedule_id, executive_id, trainer_approval_mail, trainer_manager_approval_mail,
						description_of_status, Dtt_training_id });
	}

	public void insertDTTraining(int training_request_id, int trainer_request_id, int schedule_id, int executive_id,
			String trainer_approval_mail, String trainer_manager_approval_mail, String description_of_status) {
		temp.update("insert into Develop_Team_Training_Request values(dtt_training_req_id_seq.nextval,?,?,?,?,?,?,?)",
				new Object[] { training_request_id, trainer_request_id, schedule_id, executive_id,
						trainer_approval_mail, trainer_manager_approval_mail, description_of_status });
	}

	public void deleteDTTraining(int training_request_id) {
		temp.update("delete from Develop_Team_Training_Request where training_request_id=?",
				new Object[] { training_request_id });
	}

	public DDTTraining getDDTTraining(int Dtt_training_id) {
		List<DDTTraining> trainingRequest = temp.query(
				"select * from Develop_Team_Training_Request where Dtt_training_id=?", new Object[] { Dtt_training_id },
				new DDTTrainingMapper());
		return trainingRequest.get(0);
	}


	public void insertDDTTrainingWithDTTID(int training_request_id) {

		String sql = "insert into DEVELOP_TEAM_TRAINING_REQUEST(Dtt_training_id, training_request_id) values (dtt_training_req_id_seq.nextval, ?)";

		temp.update(sql, new Object[] { training_request_id });
	}

	public void insertDDTTrainingWithDTTID(int training_request_id, int scheduleId, int trainer_requestId) {

		String sql = "insert into DEVELOP_TEAM_TRAINING_REQUEST(Dtt_training_id, training_request_id, trainer_request_id, schedule_id) values (dtt_training_req_id_seq.nextval, ?, ?, ?)";

		temp.update(sql, new Object[] { training_request_id, trainer_requestId, scheduleId });

	}
}