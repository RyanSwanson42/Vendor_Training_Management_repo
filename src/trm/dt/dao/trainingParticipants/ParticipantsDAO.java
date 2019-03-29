package trm.dt.dao.trainingParticipants;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ParticipantsDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public ParticipantsDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}
	public List<Participants> getParticipants()
	{
		List<Participants> participantsList =  temp.query("select * from Training_Participants", 
				new Object[]{},new ParticipantsMapper());
		return participantsList;
	}
	public void insertParticipants(int participant_employee_id,	int training_session_attended)
	{
		temp.update("insert into Training_Participants values(training_participant_seq.nextval,?,?)",
				new Object[]{participant_employee_id,training_session_attended});
	}
	public void deleteParticipants(int training_participant_id)
	{
		temp.update("delete from Training_Participants where training_participant_id=?",
				new Object[]{training_participant_id});
	}
	public Participants getParticipant(int training_participant_id)
	{
		List<Participants> participant =  temp.query
				("select * from Training_Participants where training_participant_id=?", 
				new Object[]{training_participant_id},new ParticipantsMapper());
		return participant.get(0);
	}
}
