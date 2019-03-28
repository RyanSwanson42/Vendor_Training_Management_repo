package dao.employee;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import dao.employee.Employee;
import dao.employee.EmployeeMapper;

public class EmployeeDAO {
	ApplicationContext context;
	JdbcTemplate temp;
	
	public EmployeeDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<Employee> getAllEmployee() {
		String sql = "select * from employee";
		List<Employee> employeeList = temp.query(sql, new EmployeeMapper());
		return employeeList; 
	}
	
	public void insertEmployee(String last_name, String first_name, String user_name, String password, String phone_number, String email, String street, String city, String state, String country, String job_title, String vertical, String project, int pid){
		
		String sql = "insert into employee values(emp_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		
		temp.update(sql, new Object[]{last_name,first_name,user_name,password,phone_number,email,street,city,state, country,job_title,vertical,project,pid});
	}
	
	public void deleteEmployee(int employee_id){
		
		String sql = "delete from employee where employee_id = ?";
		
		temp.update(sql, new Object[]{employee_id});
	}
	
	public void updateEmployee(int employee_id, String last_name, String first_name, String user_name, String password, String phone_number, String email, String street, String city, String state, String country, String job_title, String vertical, String project, int pid){
		
		String sql = "update employee set last_name = ?, first_name = ?, user_name = ?, password = ?, phone_number = ?, email = ?, street = ?, city = ?, state = ?, country = ?, job_title = ?, vertical = ?, project = ?, pid = ? where employee_id = ?";
		
		temp.update(sql, new Object[]{last_name,first_name,user_name,password,phone_number,email,street,city,state, country,job_title,vertical,project,pid,employee_id});
	}
	
	public Employee getEmployee(int employee_id){
		
		String sql = "select * from employee where employee_id = ?";
		
		List<Employee> e = temp.query(sql, new Object[]{employee_id}, new EmployeeMapper());
		
		return e.get(0);
	}
	
	public Employee getSpocDetails(String user_name){
		
		String sql = "select e.employee_id, e.first_name, e.last_name, e.vertical from employee e inner join spoc_master sm on e.employee_id = sm.spoc_emp_id where sm.spoc_vertical = e.vertical and e.user_name = ?";
		
		List<Employee> e = temp.query(sql, new Object[]{user_name}, new EmployeeMapper());
		
		return e.get(0);
	}
	
	public int getEmployeeUserNameAndPassword(String user_name, String password){
		
		String sql = "select count(*) from employee where user_name = ? and password = ?";
		
		return temp.queryForInt(sql, new Object[]{user_name,password});
	}
}
