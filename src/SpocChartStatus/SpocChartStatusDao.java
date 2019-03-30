package SpocChartStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;



public class SpocChartStatusDao {
	ApplicationContext context;
	JdbcTemplate temp;

	public SpocChartStatusDao() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<SpocChartStatus> GetStatusLeft(String vertical){
		String sql = "select tms.STATUS, count(tms.status) \"To Be Processed\" from training_management_status tms\r\n" + 
				"inner join TRAINING_REQUEST tr\r\n" + 
				"on tms.TRAINING_REQUEST_ID = tr.TRAINING_REQUEST_ID\r\n" + 
				"inner join spoc_master sm\r\n" + 
				"on tr.VERTICAL = sm.SPOC_VERTICAL\r\n" + 
				"inner join employee e\r\n" + 
				"on e.EMPLOYEE_ID = sm.SPOC_EMP_ID\r\n" + 
				"where tms.status = 100 and tr.VERTICAL = 'BNFS'\r\n" + 
				"group by tms.status";
		
		System.out.println("Got LEft");
		List<SpocChartStatus> sc = temp.query(sql,/*new Object[]{vertical}, */ new SpocChartStatusMapper());
		if(sc.size() == 0){
			System.out.println("Reconfigure");

			sc.add(new SpocChartStatus());
			sc.get(0).setStatus("");
			sc.get(0).setSum(0);
			return sc;
		}


	return sc;
	}
	
public List<SpocChartStatus> GetStatusMiddle(String vertical){
	
	String sql = "select * from (select status, count(tms.status) \"In_Process\" from training_management_status tms\r\n" + 
			"inner join TRAINING_REQUEST tr\r\n" + 
			"on tms.TRAINING_REQUEST_ID = tr.TRAINING_REQUEST_ID\r\n" + 
			"inner join spoc_master sm\r\n" + 
			"on tr.VERTICAL = sm.SPOC_VERTICAL\r\n" + 
			"inner join employee e\r\n" + 
			"on e.EMPLOYEE_ID = sm.SPOC_EMP_ID\r\n" + 
			"where tms.status in (103,104,105,106,110,120,121,122,203,204,205,206,210,220,221,222,303,304,305,310,320,321,322) and tr.VERTICAL = 'MAN'\r\n" + 
			"group by cube(tms.status))\r\n" + 
			"where status is null";
	List<SpocChartStatus> sc = temp.query(sql,/*new Object[]{vertical}, */  new SpocChartStatusMapper());
	if(sc.size() == 0){
		sc.add(new SpocChartStatus());
		sc.get(0).setStatus("");
		sc.get(0).setSum(0);
		return sc;
	}

			return sc;

	}
	public List<SpocChartStatus> GetStatusRight(String vertical){

		String sql = "select * from (select  tms.status, count(tms.status) \"Post Process\" from training_management_status tms\r\n" + 
				"inner join TRAINING_REQUEST tr\r\n" + 
				"on tms.TRAINING_REQUEST_ID = tr.TRAINING_REQUEST_ID\r\n" + 
				"inner join spoc_master sm\r\n" + 
				"on tr.VERTICAL = sm.SPOC_VERTICAL\r\n" + 
				"inner join employee e\r\n" + 
				"on e.EMPLOYEE_ID = sm.SPOC_EMP_ID\r\n" + 
				"where tms.status in (130,131,132,133,134,135,140,230,231,232,233,234,235,240,330,331,332,333,334,335,340) and tr.VERTICAL = 'MAN'\r\n" + 
				"group by cube(tms.status)) \r\n" + 
				"where status is null";
		List<SpocChartStatus> sc = temp.query(sql,/*new Object[]{vertical}, */ new SpocChartStatusMapper());
		if(sc.size() == 0){
			sc.add(new SpocChartStatus());
			sc.get(0).setStatus("");
			sc.get(0).setSum(0);
			return sc;
		}

		return sc;

	}

}
