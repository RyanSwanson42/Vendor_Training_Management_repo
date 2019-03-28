package trm.vt.dao.spocMaster;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpocMasterDAO {

	ApplicationContext context;
	JdbcTemplate temp;
	
	public SpocMasterDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}

	public List<SpocMaster> getAllSpocs() {
		
		String sql = "select * from spoc_master";
		
		List<SpocMaster> SpocMasterList = temp.query(sql, new SpocMasterMapper());
		
		return SpocMasterList;
	}
	
	public void insertSpoc(int spoc_emp_id, String spoc_vertical){
		
		String sql = "insert into spoc_master values(spoc_master_id_seq.nextval,?,?)";
		
		temp.update(sql, new Object[]{spoc_emp_id,spoc_vertical});
	}
	
	public void deleteSpoc(int spoc_master_id){
		
		String sql = "delete from spoc_master where spoc_master_id = ?";
		
		temp.update(sql, new Object[]{spoc_master_id});
	}

	public void updateSpoc(int spoc_master_id, int spoc_emp_id, String spoc_vertical){
		
		String sql = "update spoc_master set spoc_emp_id = ?, spoc_vertical = ? where spoc_master_id = ?";
		
		temp.update(sql, new Object[]{spoc_emp_id, spoc_vertical, spoc_master_id});
	}
	
	public SpocMaster getSpoc(int spoc_master_id){
		
		String sql = "select * from spoc_master where spoc_master_id = ?";
		
		List<SpocMaster> sm = temp.query(sql, new Object[]{spoc_master_id}, new SpocMasterMapper());
		
		return sm.get(0);
	}
}
