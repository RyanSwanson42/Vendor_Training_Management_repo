package trm.vt.dao.vendorDetail;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorDetailMapper implements RowMapper<VendorDetail> {

	public VendorDetail mapRow(ResultSet result, int arg1) throws SQLException {
		VendorDetail vd = new VendorDetail();
		vd.setVendor_id(result.getInt(1));
		vd.setVendor_name(result.getString(2));
		vd.setVendor_phone(result.getString(3));
		vd.setVendor_email(result.getString(4));
		vd.setVendor_city(result.getString(5));
		vd.setVendor_state(result.getString(6));
		vd.setVendor_country(result.getString(7));
		vd.setVendor_zipcode(result.getString(8));
		vd.setVendor_time_zone(result.getString(9));
		
		return vd;
	}
	
}
