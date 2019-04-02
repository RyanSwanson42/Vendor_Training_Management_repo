package trm.dt.dao.inTrainingCard;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InTrainingCardDAO {
	ApplicationContext context;
	public JdbcTemplate temp;
	public InTrainingCardDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}
	public List<InTrainingCard> getInTrainingCardList(String vertical)
	{
		List<InTrainingCard> InTrainingCardList =  temp.query("select distinct tr.training_request_id,"
				+ "tr.request_training_module,pm.first_name,pm.last_name,"
				+ "ct.first_name as fn1,ct.last_name as ln1,ts.training_start_date,ts.training_end_date,"
				+ "ex.*,s.status,dtr.dtt_training_id "
				+ "from DEVELOP_TEAM_TRAINING_REQUEST dtr "
				+ "join TRAINING_REQUEST tr on dtr.training_request_id = tr.training_request_id "
				+ "join TRAINING_SCHEDULE ts on dtr.schedule_id = ts.training_schedule_id "
				+ "join TRAINING_MANAGEMENT_STATUS s on tr.training_request_id = s.training_request_id "
				+ "join EMPLOYEE pm on pm.employee_id = tr.requester_id "
				+ "join DEVELOP_TEAM_TRAINER_REQUEST dttr on "
					+ "dtr.trainer_request_id = dttr.dtt_trainer_request_id "
					+ "join EMPLOYEE ct on ct.employee_id = dttr.trainer_id "
					+ "join EXECUTIVE_WORKFLOW_STATUS  ex on ex.training_request_id = tr.training_request_id"
					+ " where tr.vertical = ? and s.status = 130 or s.status =  230 or s.status = 330", 
				new Object[]{vertical},new InTrainingCardMapper());
		return InTrainingCardList;
	}
	
	
	

}
