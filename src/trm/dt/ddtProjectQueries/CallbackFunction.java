package trm.dt.ddtProjectQueries;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.dt.dao.developTeamTrainingRequest.DDTTrainingDAO;
import trm.it.dao.internalTrainingRequest.InternalTrainingRequestDAO;
import trm.vt.dao.trainingManagementStatus.TrainingManagementStatusDAO;
import trm.vt.dao.trainingRequestLog.TrainingRequestLogDAO;
import trm.vt.dao.vendorTrainingRequest.VendorTrainingRequestDAO;

public class CallbackFunction {
	public boolean compareAgeOfTimestap(Timestamp timestamp, int numOfDays) {
		Timestamp currentTime = new Timestamp(System.currentTimeMillis());
		double difference;
		difference = Math.abs(timestamp.getTime() - currentTime.getTime());
		final double milSecPerDay = 24 * 60 * 60 * 1000L;
		if (difference > (milSecPerDay * numOfDays)) {
			return true;
		}
		return false;
	}

	public static Timestamp dateToTimestamp(Date date) {
		Timestamp ts = new Timestamp(date.getTime());
		return ts;
	}

	public static Date timestampToDate(Timestamp ts) {
		Date date = new Date(ts.getTime());
		return date;
	}

	public void statusChange(int training_id, int status, String firstName, String lastName) {
		String message = "";
		switch (status) {
		case 103:
			message = firstName +" "+lastName+": Internal Training Request started";
			break;
		case 104:
			message = firstName +" "+lastName+": Looking for available internal trainers";
			break;
		case 105:
			message = firstName +" "+lastName+": Internal Training Request ";
			break;
		case 106:
			message = firstName +" "+lastName+": Internal Training Request ";
			break;
		case 107:
			message = firstName +" "+lastName+": Internal Training Request ";
			break;
		case 108:
			message = firstName +" "+lastName+": Internal Training Request ";
			break;
		case 109:
			message = firstName +" "+lastName+": Internal Training Request ";
			break;
		case 110:
			message = firstName +" "+lastName+": Internal Training Request at PM for Final Approval";
			// function to ask PM to choose
			break;
		case 121:
			message = firstName +" "+lastName+": Internal Training Request declined by PM / Awaiting next action";
			// ask spoc if they want to move to next type of training or restart internal
			// process
			// if to decide to move back or continue
			break;
		case 122:
			message = firstName +" "+lastName+": Internal Training Request approved by PM / Ready for training";
			// move automatically or wait for the start date
			break;
		case 130:
			message = firstName +" "+lastName+": Internal Training in progress";
			break;
		case 203:
			message = firstName +" "+lastName+": Development Training Request started";
			break;
		case 204:
			message = firstName +" "+lastName+": Confirming details with available development trainers";
			break;
		case 205:
			message = firstName +" "+lastName+": Confirming details with development trainer's manager";
			break;
		case 206:
			message = firstName +" "+lastName+": Awaiting PM for development trainer approval";
			break;
		case 207:
			message = firstName +" "+lastName+": Confirming logistical details for development training";
			break;
		case 208:
			message = "";
			break;
		case 209:
			// DDT
			break;
		case 210:
			message = firstName +" "+lastName+": Development Training Request at PM for final approval";
			break;
		case 221:
			message = firstName +" "+lastName+": Development Training Request declined by PM / Awaiting next action";
			break;
		case 222:
			message = firstName +" "+lastName+": Development Training Request approved by PM / Ready for training";
			break;
		case 230:
			message = firstName +" "+lastName+": Development Training in progress";
			break;
		case 303:
			message = firstName +" "+lastName+": Vendor Training Request started";
			break;
		case 304:
			message = firstName +" "+lastName+": Vendor Training Request SPOC Shortlist";
			break;
		case 305:
			message = firstName +" "+lastName+": Vendor Training Request PT Shortlist";
			break;
		case 310:
			message = firstName +" "+lastName+": Vendor Training Request sent to PM for Final Approval";
			break;
		case 320:
			message = firstName +" "+lastName+": Vendor Training Request received by PM";
			break;
		case 321:
			message = firstName +" "+lastName+": Vendor Training Request declined by PM / awaiting next action";
			break;
		case 322:
			message = firstName +" "+lastName+": Vendor Training Request approved by PM / ready for training";
			break;
		case 330:
			message = firstName +" "+lastName+": Vendor Training in progress";
			break;
		case 150:
			message = firstName +" "+lastName+": Training completed / Archiving request";
			break;
		default:
			break;
		}
		TrainingRequestLogDAO rl = new TrainingRequestLogDAO();
		rl.insertTrainingRequestLog(training_id, status, Timestamp.from(java.time.Instant.now()), message);
		TrainingManagementStatusDAO ms = new TrainingManagementStatusDAO();
		ms.updateTrainingManagementStatusOnPid(status, training_id);
	}

	public void clearPreviousTrainingRequset(int training_id) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");
		JdbcTemplate temp = (JdbcTemplate) context.getBean("db");
		int status = temp.queryForInt(
				"select s.status from training_management_status s join training_request tr on tr.training_request_id = s.training_request_id where s.training_request_id = ?",
				new Object[] { training_id });
		switch (status) {
		case 103:
		case 104:
		case 105:
		case 106:
		case 107:
		case 108:
		case 109:
			new InternalTrainingRequestDAO().deleteInternalTrainingRequest(training_id);
		case 203:
		case 204:
		case 205:
		case 206:
		case 207:
		case 208:
		case 209:
			new DDTTrainingDAO().deleteDTTraining(training_id);
		case 303:
		case 304:
		case 305:
		case 306:
		case 307:
		case 308:
		case 309:
			new VendorTrainingRequestDAO().deleteVendorTrainingRequest(training_id);
		}
	}
}
