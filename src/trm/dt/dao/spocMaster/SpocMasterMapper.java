package trm.dt.dao.spocMaster;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpocMasterMapper implements RowMapper<SpocMaster>{

	public SpocMaster mapRow(ResultSet result, int arg1) throws SQLException {
		
		SpocMaster sm = new SpocMaster();
		sm.setSpoc_master_id(result.getInt("spoc_master_id"));
		sm.setSpoc_emp_id(result.getInt("spoc_emp_id"));
		sm.setSpoc_vertical(result.getString("spoc_vertical"));
		return sm;
	}

}
