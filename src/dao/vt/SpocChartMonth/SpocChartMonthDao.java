package dao.vt.SpocChartMonth;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpocChartMonthDao {
	ApplicationContext context;
	JdbcTemplate temp;

	public SpocChartMonthDao() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}


	public List<SpocChartMonth> getItChartTrainingRequestInfo(String vertical) {
		String sql = "select EXTRACT(month from request_start_date) \"Months\", count(itr.INTERNAL_TRAINING_ID) \"IT Requests\" from training_request tr\r\n" + 
				"left join INTERNAL_TRAINING_REQUEST itr\r\n" + 
				"on tr.TRAINING_REQUEST_ID = itr.TRAINING_REQUEST_ID\r\n" + 
				"where tr.VERTICAL = ?\r\n" + 
				"group by EXTRACT(month from request_start_date)\r\n" + 
				"order by \"Months\"";
	
		List<SpocChartMonth> scm = temp.query(sql,new Object[]{vertical},   new SpocChartMonthMapper());


		return scm;

	}


public List<SpocChartMonth> getDttChartTrainingRequestInfo(String vertical) {
	
	String sql  ="select EXTRACT(month from request_start_date) \"Months\", count(dttr.DTT_TRAINING_ID) \"DTT Requests\" from training_request tr\r\n" + 
			"left join DEVELOP_TEAM_TRAINING_REQUEST dttr\r\n" + 
			"on tr.TRAINING_REQUEST_ID = dttr.TRAINING_REQUEST_ID\r\n" + 
			"where tr.VERTICAL = ?\r\n" + 
			"group by EXTRACT(month from request_start_date)\r\n" + 
			"order by \"Months\"";
	List<SpocChartMonth> scm = temp.query(sql, new Object[]{vertical},   new SpocChartMonthMapper());


	return scm;


}

	public List<SpocChartMonth> getVtChartTrainingRequestInfo(String vertical) {
		String sql = "select EXTRACT(month from request_start_date) \"Months\", count(vtr.VENDOR_TRAINING_REQUEST_ID) \"VT Requests\" from training_request tr\r\n" + 
				"left join VENDOR_TRAINING_REQUEST vtr\r\n" + 
				"on tr.TRAINING_REQUEST_ID = vtr.TRAINING_REQUEST_ID\r\n" + 
				"where tr.VERTICAL = ?\r\n" + 
				"group by EXTRACT(month from request_start_date)\r\n" + 
				"order by \"Months\"";
	
		List<SpocChartMonth> scm = temp.query(sql, new Object[]{vertical},   new SpocChartMonthMapper());


		return scm;

	}

}
