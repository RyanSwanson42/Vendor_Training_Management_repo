package trm.vt.dao.spocMaster;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpocMasterMapper implements RowMapper<SpocMaster>{

	public SpocMaster mapRow(ResultSet result, int arg1) throws SQLException {
		
		SpocMaster sm = new SpocMaster();
		
		sm.setSpoc_master_id(result.getInt(1));
		sm.setSpoc_emp_id(result.getInt(2));
		sm.setSpoc_vertical(result.getString(3));
		
		return sm;
	}

	
	
}
