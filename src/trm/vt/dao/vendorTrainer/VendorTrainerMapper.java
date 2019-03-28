package trm.vt.dao.vendorTrainer;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorTrainerMapper implements RowMapper<VendorTrainer> {

	public VendorTrainer mapRow(ResultSet result, int arg1) throws SQLException {
		
		VendorTrainer vt = new VendorTrainer();
		
		vt.setVendor_trainer_id(result.getInt(1));
		vt.setVendor_details_id(result.getInt(2));
		vt.setVendor_trainer_name(result.getString(3));
		vt.setPhone(result.getString(4));
		vt.setEmail(result.getString(5));
		vt.setProfile(result.getString(6));
		vt.setEvaluation_status(result.getString(7));
		vt.setVendor_trainer_log(result.getString(8));
		
		return vt;
	}

}

