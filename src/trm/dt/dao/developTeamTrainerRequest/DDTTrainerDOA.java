package dao.dtt.developTeamTrainerRequest;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DDTTrainerDOA 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public DDTTrainerDOA()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("jtemp");
	}
	public List<DDTTrainer> getDDTTrainerList()
	{
		List<DDTTrainer> DDTTrainerList =  temp.query("select * from Develop_Team_Trainier_Request", 
				new Object[]{},new DDTTrainerMapper());
		return DDTTrainerList;
	}
	public void updateTrainerRequest(int dtt_trainer_request_id,int trainer_id,
			int schedule_id,String topic,String comments,String response,int active_status)
	{
		temp.update("update Develop_Team_Trainier_Request set trainer_id=?,schedule_id=?,topic=?,"
				+ "comments=?,response=?,active_status=? where Dtt_training_id=?", 
				new Object[]{trainer_id,schedule_id,topic,comments,response,active_status,dtt_trainer_request_id});
	}
	public void insertDTTrainer(int dtt_trainer_request_id,Timestamp request_sent_date,int trainer_id,
			int schedule_id,String topic,String comments,String response,int active_status)
	{
		temp.update("insert into Develop_Team_Trainier_Request values(dtt_trainer_request_id_seq.nextval,?,?,?,?,?,?,?)",
				new Object[]{request_sent_date,trainer_id,schedule_id,topic,comments,response,active_status});
	}
	public void deleteDTTrainer(int dtt_trainer_request_id)
	{
		temp.update("delete from Develop_Team_Trainier_Request where dtt_trainer_request_id=?",
				new Object[]{dtt_trainer_request_id});
	}
	public DDTTrainer getDDTTrainer(int dtt_trainer_request_id)
	{
		List<DDTTrainer> trainingRequest =  temp.query
				("select * from Develop_Team_Trainier_Request where dtt_trainer_request_id=?", 
				new Object[]{dtt_trainer_request_id},new DDTTrainerMapper());
		return trainingRequest.get(0);
	}
}
