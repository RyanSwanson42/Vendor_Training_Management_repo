package trm.vt.dao.vendorShortListPtAndVendorDetails;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorShortListPtAndVendorDetailsDAO {
	
	ApplicationContext context;
	JdbcTemplate temp;

	public VendorShortListPtAndVendorDetailsDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	
	public List<VendorShortListPtAndVendorDetails> getShortListPtForSpoc(int vendor_training_request_id){
		
		String sql = "select vd.vendor_id, vd.VENDOR_NAME, vd.VENDOR_PHONE,vd.VENDOR_EMAIL,vd.VENDOR_CITY,vd.VENDOR_STATE from vendor_short_list_pt vslp\r\n" +
						"inner join vendor_details vd on vslp.VENDOR_ID = vd.VENDOR_ID \r\n" + 
						"inner join vendor_training_request vtr on vslp.VENDOR_TRAINING_REQUEST_ID = vtr.VENDOR_TRAINING_REQUEST_ID \r\n" +
						"inner join training_request tr on vtr.TRAINING_REQUEST_ID = tr.TRAINING_REQUEST_ID \r\n" +
						"inner join employee e  on tr.REQUESTER_ID = e.EMPLOYEE_ID \r\n" +
						"inner join spoc_master sm on e.VERTICAL = sm.SPOC_VERTICAL \r\n" +
						"where vslp.VENDOR_TRAINING_REQUEST_ID = ?";
		
		List<VendorShortListPtAndVendorDetails> ShortListAndVendorDetails = temp.query(sql, new Object[]{vendor_training_request_id}, new VendorShortListPtAndVendorDetailsMapper());
		
		return ShortListAndVendorDetails;
	}
}
