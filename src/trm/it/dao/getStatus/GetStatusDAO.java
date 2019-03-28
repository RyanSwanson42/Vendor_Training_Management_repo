package dao.getStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class GetStatusDAO {
	ApplicationContext context;
	JdbcTemplate temp;
	
	public GetStatusDAO(){
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	public List<GetStatus> getNew(){
		System.out.println("getNew Start");
		String sql = "SELECT s.spoc_vertical, tm.status, tm.training_request_id, tr.training_request_id, tr.vertical "
				+ "FROM spoc_master s, training_management_status tm, training_request tr WHERE (tr.vertical = s.spoc_vertical AND tm.training_request_id = tr.training_request_id) AND tm.status = 100";
		List<GetStatus> getStatus = temp.query(sql, new GetStatusMapper());
		return getStatus;
	}
	
	public List<GetStatus> getInProcess(){
		String sql = "SELECT s.spoc_vertical, tm.status, tm.training_request_id, tr.training_request_id, tr.vertical "
				+ "FROM spoc_master s, training_management_status tm, training_request tr WHERE (tr.vertical = s.spoc_vertical AND tm.training_request_id = tr.training_request_id) AND (tm.status > 100 AND tm.status <= 112)";
		List<GetStatus> getStatus = temp.query(sql, new GetStatusMapper());
		return getStatus;
	}
	public List<GetStatus> getFinal(){
		String sql = "SELECT s.spoc_vertical, tm.status, tm.training_request_id, tr.training_request_id, tr.vertical "
				+ "FROM spoc_master s, training_management_status tm, training_request tr WHERE (tr.vertical = s.spoc_vertical AND tm.training_request_id = tr.training_request_id) AND (tm.status >= 113 AND tm.status < 199)";
		List<GetStatus> getStatus = temp.query(sql, new GetStatusMapper());
		return getStatus;
	}
}
