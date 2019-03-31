package trm.vt.dao.SpocChartMonth;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpocChartMonthMapper implements RowMapper<SpocChartMonth> {

	public SpocChartMonth mapRow(ResultSet result, int arg1) throws SQLException {
		
		SpocChartMonth scm = new SpocChartMonth();
		scm.setMonth(result.getInt(1));
		scm.setAmount(result.getInt(2));
	
			
		return scm;
	}
	

}
