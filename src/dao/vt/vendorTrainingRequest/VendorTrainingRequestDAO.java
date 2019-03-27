package dao.vt.vendorTrainingRequest;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorTrainingRequestDAO {
	
	ApplicationContext context;
	JdbcTemplate temp;
	
	public VendorTrainingRequestDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<VendorTrainingRequest> getAllVendorTrainingRequests() {
		String sql = "select * from vendor_training_request";
		List<VendorTrainingRequest> VendorTrainingRequestList = temp.query(sql, new VendorTrainingRequestMapper());
		return VendorTrainingRequestList;
	}	

	public void insertVendorTrainingRequest(int training_request_id, int confirmed_vendor_id, int vendor_trainer_id, int schedule_id, int executive_id, String po_status, String vendor_confimation_email_path, String description_of_status){
		
		String sql = "insert into vendor_training_request values(vendor_traininer_request_id_seq.nextval, ?,?,?,?,?,?,?,?)";
		
		temp.update(sql, new Object[]{training_request_id,confirmed_vendor_id,vendor_trainer_id,schedule_id,executive_id,po_status,vendor_confimation_email_path,description_of_status});
	}
	
	public void deleteVendorTrainingRequest(int vendor_training_request_id){
		
		String sql = "delete from vendor_training_request where vendor_training_request_id = ?";
		
		temp.update(sql, new Object[]{vendor_training_request_id});
	}
	
	public void updateVendorTrainingRequest(int vendor_training_request_id,int training_request_id, int confirmed_vendor_id, int vendor_trainer_id, int schedule_id, int executive_id, String po_status, String vendor_confimation_email_path, String description_of_status){
		
		String sql = "update vendor_training_request set training_request_id = ?, confirmed_vendor_id = ?, vendor_trainer_id = ?, schedule_id = ?, executive_id = ?, po_status = ?, vendor_confirmation_email_path = ?, description_of_status = ? where vendor_training_request_id = ?";
		
		temp.update(sql, new Object[]{training_request_id,confirmed_vendor_id,vendor_trainer_id,schedule_id,executive_id,po_status,vendor_confimation_email_path,description_of_status, vendor_training_request_id});
	}
	
	public VendorTrainingRequest getVendorTrainingRequest(int vendor_training_request_id){
		
		String sql = "select * from vendor_training_request where vendor_training_request_id = ?";
		
		List<VendorTrainingRequest> vtr = temp.query(sql, new Object[]{vendor_training_request_id}, new VendorTrainingRequestMapper());
		
		return vtr.get(0);
	}
	
	public void insertVendorTrainingRequestWithTRID(int training_request_id) {
		
		String sql = "insert into vendor_training_request(vendor_training_request_id, training_request_id) values (vendor_training_request_id_seq.nextval, ?)";
		
		temp.update(sql, new Object[] {training_request_id});
	}
}
