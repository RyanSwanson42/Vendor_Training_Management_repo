package trm.it.dao.internalTrainer;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class InternalTrainerDAO {
	ApplicationContext context;
	JdbcTemplate temp;
	
	/*
	  it_trainer_id number(7) CONSTRAINT it_trainer_fk references employee(employee_id) unique not null,
	  profile_file_path varchar(100),
	  trainer_location varchar(20)
	*/
	
	public InternalTrainerDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<InternalTrainer> getAllInternalTrainers(){
		String sql = "SELECT * FROM internal_trainer";
		List<InternalTrainer> it = temp.query(sql, new InternalTrainerMapper());
		return it;
	}
	
	public void insertInternalTrainer(int it_trainer_id, String profile_path, String location){
		String sql = "INSERT INTO internal_trainer VALUES(?, ?, ?)";
		temp.update(sql, new Object[]{it_trainer_id, profile_path, location});
	}
	
	public void deleteInternalTrainer(int it_trainer_id){
		String sql = "DELETE FROM internal_trainer WHERE it_trainer_id = ?";
		temp.update(sql, new Object[]{it_trainer_id});
	}
	
	public void updateInternalTrainer(int it_trainer_id, String profile_path, String location){
		String sql = "UPDATE internal_trainer SET profile_path = ?, trainer_location = ? WHERE it_trainer_id = ?";
		temp.update(sql, new Object[]{profile_path, location, it_trainer_id});
	}
	
	public InternalTrainer getInternalTrainer(int it_trainer_id){
		String sql = "SELECT * FROM internal_trainer WHERE it_trainer_id = ?";
		List<InternalTrainer> it = temp.query(sql, new Object[]{it_trainer_id}, new InternalTrainerMapper());
		return it.get(0);
	}
}