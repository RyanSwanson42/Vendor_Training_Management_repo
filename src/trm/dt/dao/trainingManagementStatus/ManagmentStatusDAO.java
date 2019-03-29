package trm.dt.dao.trainingManagementStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ManagmentStatusDAO {
	ApplicationContext context;
	public JdbcTemplate temp;

	public ManagmentStatusDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}

	public List<ManagmentStatus> getAllManagmentStatus() {
		List<ManagmentStatus> managmentStatusList = temp.query("select * from Training_Management_Status",
				new Object[] {}, new ManagmentStatusMapper());
		return managmentStatusList;
	}

	public void updateManagmentStatus(int training_request_id, String status) {
		temp.update("update Training_Management_Status set status=? where training_request_id=?",
				new Object[] { status, training_request_id, });
	}

	public void insertManagementStatus(int training_request_id, String status) {
		temp.update("insert into Training_Management_Status values" + "(trng_management_status_id_seq.nextval,?,?)",
				new Object[] { training_request_id, status });
	}

	public void deleteManagementStatus(int training_management_status_id) {
		temp.update("delete from Training_Management_Status where training_management_status_id=?",
				new Object[] { training_management_status_id });
	}

	public ManagmentStatus getManagmentStatus(int training_management_status_id) {
		List<ManagmentStatus> status = temp.query(
				"select * from Training_Management_Status where training_management_status_id=?",
				new Object[] { training_management_status_id }, new ManagmentStatusMapper());
		return status.get(0);
	}
}
