package trm.vt.dao.vendorShortListPt;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorShortListPtMapper implements RowMapper<VendorShortListPt>{

	public VendorShortListPt mapRow(ResultSet result, int arg1)
			throws SQLException {
		
		VendorShortListPt vslp = new VendorShortListPt();
		
		vslp.setVendor_short_list_pt(result.getInt(1));
		vslp.setVendor_training_request_id(result.getInt(2));
		vslp.setVendor_id(result.getInt(3));
		
		return vslp;

	}
}
