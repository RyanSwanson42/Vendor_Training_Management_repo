package trm.it.dao.employee;

public class Employee
{
	/*
  employee_id number(7) primary key,
  last_name varchar(20) not null,
  first_name varchar(20) not null,
  user_name varchar(20) unique not null,
  password varchar(20) not null,
  phone_number varchar(20) unique not null,
  email varchar(40) unique not null,
  street varchar(40) not null,
  city varchar(40) not null,
  state varchar(40) not null,
  country varchar(40) not null,
  job_title varchar(20) not null,
  vertical varchar(10),
  project varchar(30),
  pid number(5)
	*/
	
	private int employee_id;
	private String last_name;
	private String first_name;
	private String user_name;
	private String password;
	private String phone_number;
	private String email;
	private String street;
	private String city;
	private String state;
	private String country;
	private String job_title;
	private String vertical;
	private String project;
	private int pid;
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/
	
	public void displayEmployee() {
		System.out.println();
		System.out.println("Displaying Employee: ");
		System.out.println("ID: "+ employee_id);
		System.out.println("Name: " + last_name + ", " + first_name);
		System.out.println("Username: " + user_name);
		System.out.println("Password: " + password);
		System.out.println("Phone: " + phone_number);
		System.out.println("Email: " + email);
		System.out.println("Address: " + street + " " + city + ", " + state + ", " + country);
		System.out.println("Job: " + job_title);
		System.out.println("Vertical: " + vertical);
		System.out.println("Project: " + project);
		System.out.println("PID: " + pid);
	}
	
	public int getEmployee_id()
	{
		return employee_id;
	}
	public void setEmployee_id(int employee_id)
	{
		this.employee_id = employee_id;
	}
	public String getLast_name()
	{
		return last_name;
	}
	public void setLast_name(String last_name)
	{
		this.last_name = last_name;
	}
	public String getFirst_name()
	{
		return first_name;
	}
	public void setFirst_name(String first_name)
	{
		this.first_name = first_name;
	}
	public String getUser_name()
	{
		return user_name;
	}
	public void setUser_name(String user_name)
	{
		this.user_name = user_name;
	}
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	public String getPhone_number()
	{
		return phone_number;
	}
	public void setPhone_number(String phone_number)
	{
		this.phone_number = phone_number;
	}
	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getStreet()
	{
		return street;
	}
	public void setStreet(String street)
	{
		this.street = street;
	}
	public String getCity()
	{
		return city;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getCountry()
	{
		return country;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public String getJob_title()
	{
		return job_title;
	}
	public void setJob_title(String job_title)
	{
		this.job_title = job_title;
	}
	public String getVertical()
	{
		return vertical;
	}
	public void setVertical(String vertical)
	{
		this.vertical = vertical;
	}
	public String getProject()
	{
		return project;
	}
	public void setProject(String project)
	{
		this.project = project;
	}
	public int getPid()
	{
		return pid;
	}
	public void setPid(int pid)
	{
		this.pid = pid;
	}
	
	public String toString() {
		return "\nEmployee [employee_id=" + employee_id + ", last_name=" + last_name + ", first_name=" + first_name
				+ ", user_name=" + user_name + ", password=" + password + ", phone_number=" + phone_number + ", email="
				+ email + ", street=" + street + ", city=" + city + ", state=" + state + ", country=" + country
				+ ", job_title=" + job_title + ", vertical=" + vertical + ", project=" + project + ", pid=" + pid + "]";
	} 	
	public String getNames(){
		String fullname = last_name + ", " + first_name;
		return fullname;
	}	
}
