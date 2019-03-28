package trm.pm.dbo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ContextTemplate {
	private ApplicationContext context;
	private JdbcTemplate jdbctemplate;
	
	public ContextTemplate( ) {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		jdbctemplate = context.getBean("db", JdbcTemplate.class);
	}
	
	public ApplicationContext getContext() {
		return context;
	}

	public void setContext(ApplicationContext context) {
		this.context = context;
	}

	public JdbcTemplate getJdbctemplate() {
		return jdbctemplate;
	}

	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}

	public void closeContext() {
		//if (context instanceof FileSystemXmlApplicationContext) {
		//((FileSystemXmlApplicationContext) context).close();
		//}
		//else { //ClassPathXmlApplicationContext
		((ClassPathXmlApplicationContext)context).close();
		//}
	}
}
