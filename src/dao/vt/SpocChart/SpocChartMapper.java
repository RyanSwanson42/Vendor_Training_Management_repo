package dao.vt.SpocChart;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SpocChartMapper implements RowMapper<SpocChart> {

	public SpocChart mapRow(ResultSet result, int arg1) throws SQLException {

		SpocChart sc = new SpocChart();
		sc.setName(result.getString(1));
		sc.setAmount(result.getInt(2));

		return sc;
	}
}
