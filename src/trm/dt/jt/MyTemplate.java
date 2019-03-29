package trm.dt.jt;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class MyTemplate {
	ApplicationContext context;
	JdbcTemplate temp;
	
	public MyTemplate()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}
	public JdbcTemplate getTemplate()
	{
		return temp;
	}

}
