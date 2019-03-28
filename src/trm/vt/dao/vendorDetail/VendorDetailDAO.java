package trm.vt.dao.vendorDetail;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class VendorDetailDAO {

	ApplicationContext context;
	JdbcTemplate temp;
	
	public VendorDetailDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<VendorDetail> getAllVendorDetail() {
		String sql = "select * from vendor_details";
		List<VendorDetail> VendorDetailList = temp.query(sql, new VendorDetailMapper());
		return VendorDetailList; 
	}
	
	public void insertVendorDetail(String vendor_name, String vendor_phone, String vendor_email, String vendor_city, String vendor_state, String vendor_country, String vendor_zipcode, String vendor_time_zone){
		
		String sql = "insert into vendor_details values(vendor_id_seq.nextval, ?,?,?,?,?,?,?,?)";
		
		temp.update(sql, new Object[]{vendor_name,vendor_phone,vendor_email,vendor_city,vendor_state,vendor_country,vendor_zipcode,vendor_time_zone});
	}
	
	public void deleteVendorDetail(int vendor_id){
		
		String sql = "delete from vendor_details where vendor_id = ?";
		
		temp.update(sql, new Object[]{vendor_id});
	}
	
	public void updateVendorDetail(int vendor_id, String vendor_name, String vendor_phone, String vendor_email, String vendor_city, String vendor_state, String vendor_country, String vendor_zipcode, String vendor_time_zone){
		
		String sql = "update vendor_details set vendor_name = ?, vendor_phone = ?, vendor_email = ?, vendor_city = ?, vendor_state = ?, vendor_country = ?, vendor_zipcode = ?, vendor_time_zone = ? where vendor_id = ?";
		
		temp.update(sql, new Object[]{vendor_name,vendor_phone,vendor_email,vendor_city,vendor_state,vendor_country,vendor_zipcode,vendor_time_zone, vendor_id});
	}
	
	
	public List<VendorDetail> getVendorDetail(String vendorName) {
		
		String sql = "select * from vendor_details where vendor_name = ?";
		
		List <VendorDetail> vd = temp.query(sql, new Object[]{vendorName}, new VendorDetailMapper());
		
		return vd;
	}
}
