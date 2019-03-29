package trm.dt.dao.trainingRequestLog;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class RequestLogDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public RequestLogDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}
	public List<RequestLog> getRequestLogs()
	{
		List<RequestLog> requestLogList =  temp.query("select * from Training_Request_Log", 
				new Object[]{},new RequestLogMapper());
		return requestLogList;
	}
	public void updateRequestLog(int request_log_id,int status_changed_to,
			Timestamp status_change_time,String description)
	{
		temp.update("update Training_Request_Log set status_changed_to=?,"
				+ "status_change_time=?,description=? where request_log_id=?", 
				new Object[]{status_changed_to,status_change_time,description,request_log_id});
	}
	public void insertRequestLog(int training_request_id,int status_changed_to,
			Timestamp status_change_time,String description)
	{
		temp.update("insert into Training_Request_Log values(training_request_log_id_seq.nextval,?,?,?,?)",
				new Object[]{training_request_id,status_changed_to,status_change_time,description});
	}
	public void deleteRequestLog(int request_log_id)
	{
		temp.update("delete from Training_Request_Log where request_log_id=?",
				new Object[]{request_log_id});
	}

	public RequestLog getRequestLog(int request_log_id)
	{
		List<RequestLog> requestLog =  temp.query("select * from Training_Request_Log where request_log_id=?", 
				new Object[]{request_log_id},new RequestLogMapper());
		return requestLog.get(0);
	}
}
