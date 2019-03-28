package dao.dtt.developTeamTrainingRequest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DDTTrainingDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public DDTTrainingDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("jtemp");
	}
	public List<DDTTraining> getDDTTrainingList()
	{
		List<DDTTraining> DDTTrainingList =  temp.query("select * from Develop_Team_Training_Request", 
				new Object[]{},new DDTTrainingMapper());
		return DDTTrainingList;
	}
	public void updateTrainingRequest(int Dtt_training_id,int schedule_id,int executive_id,
			String trainer_approval_mail,String trainer_manager_approval_mail,String description_of_status)
	{
		temp.update("update Develop_Team_Training_Request set schedule_id=?,executive_id=?,"
				+ "trainer_approval_mail=?,trainer_manager_approval_mail=?,"
				+ "description_of_status=? where Dtt_training_id=?", 
				new Object[]{schedule_id,executive_id,trainer_approval_mail,
					trainer_manager_approval_mail,description_of_status,Dtt_training_id});
	}
	public void insertDTTraining(int training_request_id,int trainer_request_id,
			int schedule_id,int executive_id,String trainer_approval_mail,
			String trainer_manager_approval_mail,String description_of_status)
	{
		temp.update("insert into Develop_Team_Training_Request values(dtt_training_req_id_seq.nextval,?,?,?,?,?,?,?)",
				new Object[]{training_request_id,trainer_request_id,schedule_id,executive_id,
				trainer_approval_mail,trainer_manager_approval_mail,description_of_status});
	}
	public void deleteDTTraining(int Dtt_training_id)
	{
		temp.update("delete from Develop_Team_Training_Request where Dtt_training_id=?",
				new Object[]{Dtt_training_id});
	}
	public DDTTraining getDDTTraining(int Dtt_training_id)
	{
		List<DDTTraining> trainingRequest =  temp.query
				("select * from Develop_Team_Training_Request where Dtt_training_id=?", 
				new Object[]{Dtt_training_id},new DDTTrainingMapper());
		return trainingRequest.get(0);
	}
}
