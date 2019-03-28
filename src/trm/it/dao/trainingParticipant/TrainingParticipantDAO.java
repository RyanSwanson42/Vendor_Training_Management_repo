package trm.it.dao.trainingParticipant;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.it.dao.spocMaster.SpocMaster;
import trm.it.dao.spocMaster.SpocMasterMapper;

public class TrainingParticipantDAO {
	/*
	training_participant_id number(5) primary key,
	participant_employee_id number(7) CONSTRAINT tp_participant_fk references employee(employee_id) not null,
	training_session_attended number(5) CONSTRAINT tp_tr_fk references training_request(training_request_id) not null
*/
	ApplicationContext context;
	JdbcTemplate temp;
	
	public TrainingParticipantDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<TrainingParticipant> getAllTrainingParticipants(){
		String sql = "SELECT * FROM training_participants";
		
		List<TrainingParticipant> TrainingParticipantList = temp.query(sql, new TrainingParticipantMapper());
		
		return TrainingParticipantList;
	}
	
	public void insertTrainingParticipants(int participant_employee_id, int training_session_attended){
		String sql = "INSERT INTO training_participants VALUES(training_participant_seq.nextval, ?, ?)";
		temp.update(sql, new Object[]{participant_employee_id, training_session_attended});
	}
	public void deleteTrainingParticipants(int training_participant_id){
		String sql = "DELETE FROM training_participants WHERE training_participant_id = ?";
		temp.update(sql, new Object[]{training_participant_id});
	}
	public void updateTrainingParticipants(int training_participant_id, int participant_employee_id, int training_session_attended){
		String sql = "UPDATE training_participants SET participant_employee_id = ?, training_session_attended = ? WHERE training_participant_id = ?";
		temp.update(sql, new Object[]{participant_employee_id, training_session_attended, training_participant_id});
	}
	
	public TrainingParticipant getTrainingParticipant(int training_participant_id){
		String sql = "SELECT * FROM training_participants WHERE training_participant_id = ?";
		List<TrainingParticipant> tp = temp.query(sql, new Object[]{training_participant_id}, new TrainingParticipantMapper());
		return tp.get(0);
	}
}
