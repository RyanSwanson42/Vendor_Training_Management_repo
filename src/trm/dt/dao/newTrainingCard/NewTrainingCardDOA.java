package trm.dt.dao.newTrainingCard;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class NewTrainingCardDOA 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public NewTrainingCardDOA()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}
	public List<NewTrainingCard> getNewTrainingCardList()
	{
		List<NewTrainingCard> NewTrainingCardList =  temp.query("select tr.training_request_id,"
				+ "e.first_name,e.last_name,tr.request_training_module, "
				+ "tr.request_start_date,s.status from TRAINING_REQUEST tr "
				+ "join TRAINING_MANAGEMENT_STATUS s on tr.training_request_id = s.training_request_id "
				+ "join EMPLOYEE e on e.employee_id = tr.requester_id where s.status = 100", 
				new Object[]{},new NewTrainingCardMapper());
		return NewTrainingCardList;
	}
}
