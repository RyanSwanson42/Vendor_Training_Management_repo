package trm.vt.dao.vendorTrainingRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class VendorTrainingRequestMapper implements RowMapper<VendorTrainingRequest>{

	public VendorTrainingRequest mapRow(ResultSet result, int arg1) throws SQLException {
		VendorTrainingRequest vtr = new VendorTrainingRequest();
		vtr.setVendor_training_request_id(result.getInt(1));
		vtr.setTraining_request_id(result.getInt(2));
		vtr.setConfirmed_vendor_id(result.getInt(3));
		vtr.setVendor_trainer_id(result.getInt(4));
		vtr.setSchedule_id(result.getInt(5));
		vtr.setExecutive_id(result.getInt(6));
		vtr.setPo_status(result.getString(7));
		vtr.setVendor_confirmation_email_path(result.getString(8));
		vtr.setDescription_of_status(result.getString(9));
		return vtr;
	}
	
}
