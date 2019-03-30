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


	public List<SpocChartMonth> getChartTrainingRequestInfo() {

		String sql = "select EXTRACT(month from request_start_date) \"Months\", count(itr.INTERNAL_TRAINING_ID) \"IT Requests\", count(dttr.DTT_TRAINING_ID) \"DTT Requests\", count(vtr.VENDOR_TRAINING_REQUEST_ID) \"VT Requests\" from training_request tr\r\n" + 
				"inner join INTERNAL_TRAINING_REQUEST itr\r\n" + 
				"on tr.TRAINING_REQUEST_ID = itr.TRAINING_REQUEST_ID\r\n" + 
				"left join DEVELOP_TEAM_TRAINING_REQUEST dttr\r\n" + 
				"on tr.TRAINING_REQUEST_ID = dttr.TRAINING_REQUEST_ID\r\n" + 
				"inner join VENDOR_TRAINING_REQUEST vtr\r\n" + 
				"on tr.TRAINING_REQUEST_ID = vtr.TRAINING_REQUEST_ID\r\n" + 
				"group by EXTRACT(month from request_start_date)\r\n" + 
				"order by \"Months\"";
		//List<SpocChart> sc = temp.query(sql, new Object[] { name, vertical }, new SpocChartMapper());
		List<SpocChartMonth> scm = temp.query(sql,  new SpocChartMonthMapper());


		return scm;

	}

}
