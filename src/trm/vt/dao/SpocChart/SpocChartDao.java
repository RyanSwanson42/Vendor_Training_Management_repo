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

	public List<SpocChart> getChartInformation(String vertical, String name) {

		String sql = "select e.FIRST_NAME, count(training_request_id) "
				+ "from EMPLOYEE e "
				+ "inner join SPOC_MASTER sm"
				+ " on e.EMPLOYEE_ID = sm.SPOC_EMP_ID "
				+ "inner join TRAINING_REQUEST tr "
				+ "on e.VERTICAL = tr.VERTICAL "
				+ "group by e.FIRST_NAME";
		//List<SpocChart> sc = temp.query(sql, new Object[] { name, vertical }, new SpocChartMapper());
		List<SpocChart> sc = temp.query(sql,  new SpocChartMapper());


		return sc;

	}

}
