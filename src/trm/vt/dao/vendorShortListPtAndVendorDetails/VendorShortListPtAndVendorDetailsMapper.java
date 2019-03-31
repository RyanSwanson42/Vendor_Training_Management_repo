package trm.vt.dao.vendorShortListPtAndVendorDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.vt.dao.vendorDetail.VendorDetail;

public class VendorShortListPtAndVendorDetailsMapper implements RowMapper<VendorShortListPtAndVendorDetails>{

	public VendorShortListPtAndVendorDetails mapRow(ResultSet result, int arg1)
			throws SQLException {
		
		VendorDetail vd = new VendorDetail();
		
		vd.setVendor_id(result.getInt(1));
		vd.setVendor_name(result.getString(2));
		vd.setVendor_phone(result.getString(3));
		vd.setVendor_email(result.getString(4));
		vd.setVendor_city(result.getString(5));
		vd.setVendor_state(result.getString(6));
	
		
		VendorShortListPtAndVendorDetails v = new VendorShortListPtAndVendorDetails();
		
		v.setVd(vd);
		
		return v;
	}
}