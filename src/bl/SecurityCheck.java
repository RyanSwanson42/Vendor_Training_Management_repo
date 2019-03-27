package bl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SecurityCheck {
	
	ApplicationContext context;
	JdbcTemplate temp;

	public SecurityCheck() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public boolean isUserValid(String username,String userpassword)
	{
		int result = temp.queryForInt("select count(*) from employee where user_name=? "
				+ "and password=?",
				new Object[]{username,userpassword});
		
		if(result==1)
			return true;
		else
			return false;
	}
	
}