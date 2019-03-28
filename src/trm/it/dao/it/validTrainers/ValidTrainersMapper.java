package dao.it.validTrainers;

import java.sql.ResultSet;
import java.sql.SQLException;

import dao.it.internalTrainer.InternalTrainer;
import dao.trainingSchedule.TrainingSchedule;

public class ValidTrainersMapper {
	public ValidTrainers mapRow(ResultSet result, int arg1) throws SQLException{
		InternalTrainer it = new InternalTrainer();
		it.setInternal_trainer_id(result.getInt("internal_trainer_id"));
		
		TrainingSchedule ts = new TrainingSchedule();
		ts.setTraining_location(result.getString("training_location"));
		
		ValidTrainers vt = new ValidTrainers();
		return vt;
	}
}
