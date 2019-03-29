package trm.dt.dao.employee;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmployeeDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public EmployeeDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("db");
	}
	public List<Employee> getEmployees()
	{
		List<Employee> employeeList =  temp.query("select * from Employee", 
				new Object[]{},new EmployeeMapper());
		return employeeList;
	}
	public void updateEmployeeValue(int employee_id, String last_name, String first_name, 
			String user_name, String phone_number, String email, String street,
			String city, String state, String country, String job_title, String vertical, 
			String project, int pid)
	{
		temp.update("update Employee set last_name=?,first_name=?,phone_number=?,email=?,street=?,"
				+ "city=?,state=?,country=?job_title=?,vertical=?,project=?,pid=? where employee_id=?", 
				new Object[]{last_name,first_name,user_name, phone_number,email,street, 
				city, state, country,job_title, vertical, project,pid, employee_id});
	}
	public void updatePassword(String password, int employee_id)
	{
		temp.update("update Employee set password=? where employee_id=?", 
				new Object[]{password, employee_id});
	}
	public void insertEmployee(String last_name, String first_name, 
			String user_name, String password, String phone_number, String email, String street,
			String city, String state, String country, String job_title, String vertical, 
			String project, int pid)
	{
		temp.update("insert into Employee values(emp_id_seq.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?)",
				new Object[]{last_name,first_name,user_name, password, phone_number, email,
				street, city, state, country, job_title, vertical, project, pid});
	}
	public void deleteEmployee(int employee_id)
	{
		temp.update("delete from Employee where employee_id=?",new Object[]{employee_id});
	}
	public Employee getEmployee(int employee_id)
	{
		List<Employee> employee =  temp.query("select * from Employee where employee_id=?", 
				new Object[]{employee_id},new EmployeeMapper());
		return employee.get(0);
	}
}
