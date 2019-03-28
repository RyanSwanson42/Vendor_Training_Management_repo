package trm.vt.dao.vendorShortListPt;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorShortListPtDAO {

	ApplicationContext context;
	JdbcTemplate temp;

	public VendorShortListPtDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}

	public List<VendorShortListPt> getAllVendorShortListPtDetails() {

		String sql = "select * from vendor_short_list_pt";
		List<VendorShortListPt> VendorPtList = temp.query(sql,
				new VendorShortListPtMapper());
		return VendorPtList;
	}

	public void insertVendorShortListPt(int vendor_training_request_id, int vendor_id){
		
		String sql = "insert into vendor_short_list_pt values(vendor_short_list_pt_id_seq.nextval, ?,?)";
		
		temp.update(sql, new Object[]{vendor_training_request_id, vendor_id});
	}
	
	public void deleteVendorShortListPt(int vendor_short_list_pt_id){
		
		String sql = "delete from vendor_short_list_pt where vendor_short_list_pt_id = ?";
		
		temp.update(sql, new Object[]{vendor_short_list_pt_id});
	}

	public void updateVendorShortListPt(int vendor_short_list_pt_id, int vendor_training_request_id, int vendor_id){
		
		String sql = "update vendor_short_list_pt set vendor_training_request_id = ?, vendor_id = ? where vendor_short_list_pt_id = ?";
		
		temp.update(sql, new Object[]{vendor_training_request_id, vendor_id, vendor_short_list_pt_id});
	}
	
	public VendorShortListPt getVendorShortListPt(int vendor_short_list_pt_id){
		
		String sql = "select * from vendor_short_list_pt where vendor_short_list_pt_id = ?";
		
		List<VendorShortListPt> vslp = temp.query(sql, new Object[]{vendor_short_list_pt_id}, new VendorShortListPtMapper());
		
		return vslp.get(0);
	}
}
