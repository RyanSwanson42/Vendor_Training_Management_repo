package trm.it.dao.getName;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class GetNameDAO {
	ApplicationContext context;
	JdbcTemplate temp;
	
	public GetNameDAO(){
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public int getIdByName(String name){
		String names[] = name.split(" ");
		String lastName = names[0].replace(",", ""); //substring(0, names[0].length() - 1);
		String firstName = names[1];
		System.out.println(lastName);
		System.out.println(firstName);
		String sql = "SELECT employee_id FROM employee WHERE last_name = ? AND first_name = ?";
		int id = temp.queryForInt(sql, new Object[]{lastName, firstName});
		return id;
	}
	public List<GetName> getSpocName(int id){
		String sql = "SELECT DISTINCT last_name, first_name FROM Employee JOIN Spoc_Master ON employee_id = spoc_emp_id WHERE spoc_emp_id = ?";
		List<GetName> name = temp.query(sql, new Object[]{id}, new GetNameMapper());
		return name;
	}
	public List<GetName> getExecutiveName(int id){
		String sql = "SELECT DISTINCT last_name, first_name FROM Employee JOIN Internal_training_request ON employee_id = executive_id WHERE executive_id = ?";
		List<GetName> name = temp.query(sql, new Object[]{id}, new GetNameMapper());
		return name;
	}
	public List<GetName> getTraineeName(int id){
		String sql = "SELECT DISTINCT last_name, first_name FROM Employee JOIN Training_Participants ON employee_id = participant_employee_id WHERE participant_employee_id = ?";
		List<GetName> name = temp.query(sql, new Object[]{id}, new GetNameMapper());
		return name;
	}
	
	public List<GetName> getTrainerName(int id){
		String sql = "SELECT DISTINCT last_name, first_name FROM Employee JOIN Internal_Trainer ON employee_id = it_trainer_id WHERE it_trainer_id = ?";
		List<GetName> name = temp.query(sql, new Object[]{id}, new GetNameMapper());
		return name;
	}
	
	public List<GetName> getAllTrainers(){
		String sql = "SELECT e.last_name, e.first_name, it.it_trainer_id FROM internal_trainer it JOIN employee e ON e.employee_id = it.it_trainer_id";
		List<GetName> trainers = temp.query(sql, new GetNameMapper());
		return trainers;
	}
}
