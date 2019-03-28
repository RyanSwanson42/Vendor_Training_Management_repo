package trm.vt.dao.vendorShortListSpoc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorShortListSpocMapper implements RowMapper<VendorShortListSpoc>{

	public VendorShortListSpoc mapRow(ResultSet result, int arg1)
			throws SQLException {
		
		VendorShortListSpoc vsls = new VendorShortListSpoc();
		
		vsls.setVendor_short_list_spoc_id(result.getInt(1));
		vsls.setVendor_training_request_id(result.getInt(2));
		vsls.setVendor_id(result.getInt(3));
		
		return vsls;
	}
	
	

}
