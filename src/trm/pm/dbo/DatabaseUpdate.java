package trm.pm.dbo;

import java.sql.Timestamp;
import java.text.ParseException;
import java.util.Date;

//import org.apache.jasper.tagplugins.jstl.core.Catch;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class DatabaseUpdate {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		JdbcTemplate template = (JdbcTemplate)context.getBean("db");
		
		
		public void insertTraining(int username, String vertical,String trainingType,String trainingModule,String moduleScope,
				String trainingMode,Date startDate,Date endDate,String location, String timeZone,int participants,int spoc,
				Timestamp timestamp, String justification)
		{
		
		template.update("insert into TRAINING_REQUEST values(training_id_request_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[] {username,vertical,trainingType,trainingModule,moduleScope, trainingMode,
						startDate, endDate,location,timeZone, participants, spoc, timestamp,justification});				
		}
		public void changeDate(String date) throws ParseException {
			
		
		}
		
		public void changePassword(String userName, String newPassword) {
			template.update("update Employee set password = ? where user_name = ?",new Object[] {newPassword,userName});
		}
			
}