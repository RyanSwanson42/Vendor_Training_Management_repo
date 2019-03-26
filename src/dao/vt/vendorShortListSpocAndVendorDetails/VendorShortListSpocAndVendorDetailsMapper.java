package dao.vt.vendorShortListSpocAndVendorDetails;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.vt.vendorDetail.VendorDetail;
import dao.vt.vendorShortListSpoc.VendorShortListSpoc;

public class VendorShortListSpocAndVendorDetailsMapper implements RowMapper<VendorShortListSpocAndVendorDetails>{

	public VendorShortListSpocAndVendorDetails mapRow(ResultSet result, int arg1)
			throws SQLException {
		
		VendorDetail vd = new VendorDetail();
		
		vd.setVendor_name(result.getString(1));
		vd.setVendor_phone(result.getString(2));
		vd.setVendor_email(result.getString(3));
		vd.setVendor_city(result.getString(4));
		vd.setVendor_state(result.getString(5));
		
		//VendorShortListSpoc vsls = new VendorShortListSpoc();
		
		//vsls.setVendor_training_request_id(result.getInt(6));
		
		VendorShortListSpocAndVendorDetails v = new VendorShortListSpocAndVendorDetails();
		
		v.setVd(vd);
		//v.setVsls(vsls);
		
		return v;
	}
	
	

}
