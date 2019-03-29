package trm.dt.dao.spocMaster;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpocMasterDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public SpocMasterDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}
	public List<SpocMaster> getSpocMasters()
	{
		List<SpocMaster> spocMasterList =  temp.query("select * from Spoc_Master", 
				new Object[]{},new SpocMasterMapper());
		return spocMasterList;
	}
	public void updateSpocMasterValue(int spoc_master_id,String spoc_vertical)
	{
		temp.update("update Spoc_Master set spoc_vertical=? where spoc_master_id=?", new Object[]
				{spoc_vertical,spoc_master_id});
	}
	public void insertSpocMaster(int spoc_master_id, int spoc_emp_id, String spoc_vertical)
	{
		temp.update("insert into Spoc_Master values(spoc_master_id_seq.nextval,?,?)",
				new Object[]{spoc_emp_id,spoc_vertical});
	}
	public void deleteSpocMaster(int spoc_master_id)
	{
		temp.update("delete from Spoc_Master where Spoc_Master=?",new Object[]{spoc_master_id});
	}
	public SpocMaster getSpocMaster(int spoc_master_id)
	{
		List<SpocMaster> spocMaster =  temp.query("select * from Spoc_Master where spoc_master_id=?", 
				new Object[]{spoc_master_id},new SpocMasterMapper());
		return spocMaster.get(0);
	}
}
