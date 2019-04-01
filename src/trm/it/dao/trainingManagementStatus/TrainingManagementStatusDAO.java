package trm.it.dao.trainingManagementStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.it.dao.trainingManagementStatus.TrainingManagementStatus;
import trm.it.dao.trainingManagementStatus.TrainingManagementStatusMapper;
import trm.it.dao.trainingRequestLog.TrainingRequestLogDAO;

public class TrainingManagementStatusDAO {

	ApplicationContext context;
	JdbcTemplate temp;

	public TrainingManagementStatusDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}

	public List<TrainingManagementStatus> getAllTrainingManagementStatusDetails() {

		String sql = "select * from training_management_status";
		List<TrainingManagementStatus> TrainingStatusList = temp.query(sql, new TrainingManagementStatusMapper());
		return TrainingStatusList;
	}

	public void insertTrainingManagementStatus(int training_request_id) {

		String sql = "insert into training_management_status values(trng_management_status_id_seq.nextval, ?, 100)";

		temp.update(sql, new Object[] { training_request_id });
	}

	public void deleteTrainingManagementStatus(int training_management_stauts_id) {

		String sql = "delete from training_management_status where training_management_status_id = ?";

		temp.update(sql, new Object[] { training_management_stauts_id });
	}

	public void updateTrainingManagementStatus(int training_request) {

		String sql = "update training_management_status set status = ? where training_request_id = ?";
		int status = getStatus(training_request);
		temp.update(sql, new Object[] { status, training_request });
		int newStatus = status;
		switch (status) {
		case 100:
			status = 103;
			break;
		case 103:
			status = 105;
			break;
		case 105:
			status = 110;
			break;
		case 110:
			status = 120;
			break;
		case 120:
			status = 122;
		case 121:
			status = 103;
			break;
		case 122:
			status = 130;
			break;
		case 130:
			status = 131;
			break;
		case 131:
			status = 199;
		default:
			status = 100;
		}
		TrainingRequestLogDAO trl = new TrainingRequestLogDAO();
		trl.insertTrainingRequestLog(training_request, status);
		;

	}

	public int getStatus(int training_request) {
		String sql = "SELECT status FROM training_management_status WHERE training_request_id = ?";
		int status = temp.queryForInt(sql, new Object[] { training_request });
		return status;
	}

	public TrainingManagementStatus getTrainingManagementStatus(int training_request_id) {

		String sql = "select * from training_management_status where training_request_id = ?";

		List<TrainingManagementStatus> tms = temp.query(sql, new Object[] { training_request_id },
				new TrainingManagementStatusMapper());

		return tms.get(0);
	}

	public int getCount() {
		String sql = "SELECT count(*) FROM training_management_status";
		int count = temp.queryForInt(sql);
		return count;
	}
}
