package trm.pm.dbo;

import java.util.HashMap;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO {

	ApplicationContext context;
	JdbcTemplate temp;
	HashMap<String, String> TZ = new HashMap<String, String>();

	public EmployeeDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}
	
	public void updatePassword(String userName, String password) {

        temp.update("update employee set password = ? where user_name = ?", new Object[] {password,userName} );

    }

	public boolean insertEmployee(String last_name, String first_name, String user_name, String password, String phone_number, String email, String street, String city, String state, String country, String job_title, String vertical, String project, int pid) {
		String sql = "insert into employee values(emp_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		int num = temp.update(sql, new Object[]{last_name, first_name, user_name, password, phone_number, email, street, city, state, country, job_title, vertical, project, pid});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public boolean deleteEmployee(int employee_id) {
		String sql = "delete from employee where employee_id=?";
		int num = temp.update(sql, new Object[]{employee_id});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public boolean updateEmployee(int employee_id, String last_name, String first_name, String user_name, String password, String phone_number, String email, String street, String city, String state, String country, String job_title, String vertical, String project, int pid) {
		String sql = "update employee set last_name=?, first_name=?, user_name=?, password=?, phone_number=?, email=?, street=?, city=?, state=?, country=?, job_title=?, vertical=?, project=?, pid=? where employee_id=?";
		int num = temp.update(sql, new Object[]{last_name, first_name, user_name, password, phone_number, email, street, city, state, country, job_title, vertical, project, pid, employee_id});
		if (num == 1) {
			return true;
		}
		return false;
	}

	public List<Employee> getAllEmployee() {
		String sql = "select * from employee";
		return temp.query(sql,new EmployeeMapper());
	}

	public Employee getEmployee(int employee_id) {
		String sql = "select * from employee where employee_id=?";
		List<Employee> employee = temp.query(sql, new Object[]{employee_id},new EmployeeMapper());
		return employee.get(0);
	}
	public Employee getEmployee(String username, String password) {
		String sql = "select * from employee where user_name = ? and password = ?";
		Employee emp = temp.queryForObject(sql, new Object[]{username, password},new EmployeeMapper());
		return emp;
	}
	public List<Employee> getTRInfo(String userName)
    {
        return temp.query("select * from Employee where user_name = ?", new Object[] {userName},new EmployeeMapper());
    }
	public String getTimeZone(String state) {
        TZ.put("MA", "EST");TZ.put("TN","CT");TZ.put("AZ","MST");TZ.put("New York","EST");
        TZ.put("TX","EST");TZ.put("MI","EST");TZ.put("New York","EST");TZ.put("FL","EST");
        TZ.put("CA","EST");TZ.put("Bremen","GMT");
        if(TZ.get(state).equals(null)) {return "UKN";}
        return TZ.get(state);
    }
}