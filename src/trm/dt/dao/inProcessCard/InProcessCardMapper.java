
package trm.dt.dao.inProcessCard;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import org.springframework.jdbc.core.RowMapper;

import trm.dt.dao.developTeamTrainerRequest.DDTTrainer;
import trm.dt.dao.inProcessCard.InProcessCard;
import trm.dt.dao.trainingSchedule.TrainingScheduleMapper;
import trm.dt.dao.developTeamTrainingRequest.DDTTraining;
import trm.dt.dao.employee.Employee;
import trm.dt.dao.trainingManagementStatus.ManagmentStatus;
import trm.dt.dao.trainingRequest.TrainingRequest;
import trm.dt.dao.trainingRequestLog.RequestLog;
import trm.dt.dao.trainingSchedule.TrainingSchedule;

public class InProcessCardMapper implements RowMapper<InProcessCard> 
{

	@Override
	public InProcessCard mapRow(ResultSet result, int arg1) throws SQLException {
		InProcessCard sl = new InProcessCard();
		
		DDTTraining training = new DDTTraining();
		training.setDtt_training_id(result.getInt("dtt_training_id"));
		training.setSchedule_id(result.getInt("schedule_id"));
		sl.setTraining(training);
		
		TrainingRequest request = new TrainingRequest();
		request.setTraining_request_id(result.getInt("training_request_id"));
		request.setRequest_training_type(result.getString("request_training_type"));
		request.setRequest_training_module(result.getString("request_training_module"));
		request.setRequest_training_module_scope(result.getString("request_training_module_scope"));
		request.setRequest_training_mode(result.getString("request_training_mode"));
		
		String startdate = result.getString("request_start_date");
		String[] start_date = startdate.split(" ");
		request.setRequest_start_date(start_date[0]);
		
		String enddate = result.getString("request_end_date");
		String[] end_date = enddate.split(" ");
		request.setRequest_end_date(end_date[0]);
		
		request.setRequest_location(result.getString("request_location"));
		request.setRequest_approx_participant(result.getInt("request_approx_participant"));		
		sl.setRequest(request);
		
		TrainingSchedule schedule = new TrainingSchedule();
		schedule = new TrainingScheduleMapper().mapRow(result, arg1);
		sl.setSchedule(schedule);
		
		Employee projectManager = new Employee();
		projectManager.setFirst_name(result.getString("first_name"));
		projectManager.setLast_name(result.getString("last_name"));
		sl.setProjectManager(projectManager);
		
		DDTTrainer trainer = new DDTTrainer();
		trainer.setDtt_trainer_request_id(result.getInt("dtt_trainer_request_id"));
		trainer.setRequest_sent_date(result.getTimestamp("request_sent_date"));
		trainer.setResponse(result.getString("response"));
		trainer.setActive_status(result.getInt("active_status"));
		sl.setTrainer(trainer);
		
		Employee currentTrainer = new Employee();
		currentTrainer.setFirst_name(result.getString("ctfn"));
		currentTrainer.setLast_name(result.getString("ctln"));
		sl.setCurrentTrainer(currentTrainer);
		
		ManagmentStatus status = new ManagmentStatus();
		status.setStatus(result.getInt("status"));
		sl.setStatus(status);
		
		RequestLog reqLog = new RequestLog();
		reqLog.setDescription(result.getString("DESCRIPTION"));
		sl.setReqLog(reqLog);

		return sl;
	}

}
