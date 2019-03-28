package trm.vt.dao.vendorShortListSpocAndVendorDetails;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorShortListSpocAndVendorDetailsDAO {

		ApplicationContext context;
		JdbcTemplate temp;

		public VendorShortListSpocAndVendorDetailsDAO() {
			context = new ClassPathXmlApplicationContext("spring-config.xml");
			temp = (JdbcTemplate) context.getBean("db");
		}
		
		
		public List<VendorShortListSpocAndVendorDetails> getShortListSpocForSpoc(int vendor_training_request_id){
			
			String sql = "select vd.VENDOR_NAME, vd.VENDOR_PHONE,vd.VENDOR_EMAIL,vd.VENDOR_CITY,vd.VENDOR_STATE from vendor_short_list_spoc vsls\r\n" +
							"inner join vendor_details vd on vsls.VENDOR_ID = vd.VENDOR_ID \r\n" + 
							"inner join vendor_training_request vtr on vsls.VENDOR_TRAINING_REQUEST_ID = vtr.VENDOR_TRAINING_REQUEST_ID \r\n" +
							"inner join training_request tr on vtr.TRAINING_REQUEST_ID = tr.TRAINING_REQUEST_ID \r\n" +
							"inner join employee e  on tr.REQUESTER_ID = e.EMPLOYEE_ID \r\n" +
							"inner join spoc_master sm on e.VERTICAL = sm.SPOC_VERTICAL \r\n" +
							"where vsls.VENDOR_TRAINING_REQUEST_ID = ?";
			
			List<VendorShortListSpocAndVendorDetails> ShortListAndVendorDetails = temp.query(sql, new Object[]{vendor_training_request_id}, new VendorShortListSpocAndVendorDetailsMapper());
			
			return ShortListAndVendorDetails;
			
		}
}
