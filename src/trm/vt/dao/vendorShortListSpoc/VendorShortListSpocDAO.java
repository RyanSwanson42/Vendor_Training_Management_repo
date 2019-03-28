package trm.vt.dao.vendorShortListSpoc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorShortListSpocDAO {

	ApplicationContext context;
	JdbcTemplate temp;
	
	public VendorShortListSpocDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<VendorShortListSpoc> getAllVendorShortListSpocDetails(){
		
		String sql = "select * from vendor_short_list_spoc";
		List<VendorShortListSpoc> VendorSpocList = temp.query(sql, new VendorShortListSpocMapper());
		return VendorSpocList; 
	}
	
	public void insertVendorShortListSpoc(int vendor_training_request_id, int vendor_id){
		
		String sql = "insert into vendor_short_list_spoc values(vendor_short_list_spoc_id_seq.nextval, ?,?)";
		
		temp.update(sql, new Object[]{vendor_training_request_id, vendor_id});
	}
	
	public void deleteVendorShortListSpoc(int vendor_short_list_spoc_id){
		
		String sql = "delete from vendor_short_list_spoc where vendor_short_list_spoc_id = ?";
		
		temp.update(sql, new Object[]{vendor_short_list_spoc_id});
	}
	
	public void updateVendorShortListSpoc(int vendor_short_list_spoc_id, int vendor_training_request_id, int vendor_id){
		
		String sql = "update vendor_short_list_spoc set vendor_training_request_id = ?, vendor_id = ? where vendor_short_list_spoc_id = ?";
		
		temp.update(sql, new Object[]{vendor_training_request_id, vendor_id, vendor_short_list_spoc_id});
	}
	
	public VendorShortListSpoc getVendorShortListSpoc(int vendor_short_list_spoc_id){
		
		String sql = "select * from vendor_short_list_spoc where vendor_short_list_spoc_id = ?";
		
		List<VendorShortListSpoc> vsls = temp.query(sql, new Object[]{vendor_short_list_spoc_id}, new VendorShortListSpocMapper());
		
		return vsls.get(0);
	}
	
}


