package trm.vt.dao.SpocChart;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpocChartDao {
	ApplicationContext context;
	JdbcTemplate temp;

	public SpocChartDao() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	
	//Vertical and Name  may be used if needed for future use
	public List<SpocChart> getChartTrainingRequestInfo(String vertical) {

		String sql = "select e.FIRST_NAME, count(training_request_id) "
				+ "from EMPLOYEE e "
				+ "inner join SPOC_MASTER sm"
				+ " on e.EMPLOYEE_ID = sm.SPOC_EMP_ID "
				+ "inner join TRAINING_REQUEST tr "
				+ "on e.VERTICAL = ? "
				+ "group by e.FIRST_NAME";
		List<SpocChart> sc = temp.query(sql,new Object[]{vertical},  new SpocChartMapper());


		return sc;

	}
	
	//Vertical and Name  may be used if needed for future use
	public List<SpocChart> GetTotalParticipants(String vertical) {

		String sql = "select tr.REQUEST_TRAINING_TYPE,SUM(tr.REQUEST_APPROX_PARTICIPANT)"
				+ " from SPOC_MASTER sm"
				+ " inner join EMPLOYEE e"
				+ " on sm.SPOC_EMP_ID = e.EMPLOYEE_ID"
				+ " inner join TRAINING_REQUEST tr"
				+ " on sm.SPOC_VERTICAL = ?"
				+ " GROUP BY tr.REQUEST_TRAINING_TYPE";
		List<SpocChart> sc = temp.query(sql,new Object[]{vertical},  new SpocChartMapper());


		return sc;

	}
	


}
