package trm.vt.dao.SpocChartStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpocChartStatusMapper implements RowMapper<SpocChartStatus> {

	public SpocChartStatus mapRow(ResultSet result, int arg1) throws SQLException {
		System.out.println("Inside Mapper");

		SpocChartStatus sc = new SpocChartStatus();
		sc.setStatus("");
		sc.setSum(result.getInt(2));
		System.out.println("Object Set");
		return sc;
	}
	
}
