package trm.it.dao.internalTrainingRequest;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import trm.it.dao.employee.Employee;
import trm.it.dao.employee.EmployeeMapper;
import trm.it.dao.it.internalTrainer.InternalTrainer;
import trm.it.dao.it.internalTrainer.InternalTrainerMapper;
import trm.it.dao.trainingRequest.TrainingRequest;
import trm.it.dao.trainingRequest.TrainingRequestMapper;
import trm.it.dao.trainingSchedule.TrainingSchedule;
import trm.it.dao.trainingSchedule.TrainingScheduleMapper;

public class InternalTrainingRequestMapper implements RowMapper<InternalTrainingRequest>{
	/*
	  internal_training_id number(5) primary key,
	  training_request_id number(5) CONSTRAINT itr_tr_fk references training_request(training_request_id) unique not null,
	  schedule_id number(5) CONSTRAINT itr_sched_fk references training_schedule(training_schedule_id) unique,
	  confirmed_trainer_id number(7) CONSTRAINT itr_train_fk references internal_trainer(it_trainer_id),
	  executive_id number(7) CONSTRAINT tr_exec_fk references employee(employee_id),
	  description_of_status varchar(30)
	*/
	public InternalTrainingRequest mapRow (ResultSet result, int arg1)
			throws SQLException {
		InternalTrainingRequest itr = new InternalTrainingRequest();
		itr.setInternal_training_id(result.getInt("internal_training_id"));
		itr.setTRI(result.getInt("training_request_id"));
		itr.setSchedule(result.getInt("schedule_id"));
		itr.setConfirmed_trainer(result.getInt("confirmed_trainer_id"));
		itr.setExecutive(result.getInt("executive_id"));
		itr.setDescription_of_status(result.getString("description_of_status"));
		return itr;
	}
}
