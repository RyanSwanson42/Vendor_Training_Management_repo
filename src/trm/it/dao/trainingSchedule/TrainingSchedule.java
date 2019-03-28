package trm.it.dao.trainingSchedule;

import java.sql.Date;

public class TrainingSchedule
{
	/*
	  training_schedule_id number(5) primary key,
	  training_city varchar(30),
	  training_state varchar(20),
	  training_country varchar(20),
	  training_zipcode varchar(20),
	  training_time_zone varchar(6),
	  training_location varchar(20),
	  training_room_number varchar(20),
	  training_start_date TIMESTAMP(0),
	  training_end_date TIMESTAMP(0),
	  training_break_down varchar(200),
	  training_url varchar(300),
	  training_phone number(10)
	*/
	
	private int training_schedule_id;
	private String training_city;
	private String training_state;
	private String training_country;
	private String training_zipcode;
	private String training_time_zone;
	private String training_location;
	private String training_room_number;
	private String training_start_date; 
	private String training_end_date; 
	private String training_break_down;
	private String training_url;
	private String training_phone;
	
	/***********************
	 * GETTERS AND SETTERS * 
	 ***********************/
	public void display(){
		System.out.println("ID: " + training_schedule_id);
		System.out.println("City: " + training_city);
		System.out.println("State: " + training_state);
		System.out.println("Country: " + training_country);
		System.out.println("Zip Code: " +  training_zipcode);
		System.out.println("Time Zone: " +  training_time_zone);
		System.out.println("Location: " +  training_location);
		System.out.println("Room Number: " + training_room_number);
		System.out.println("Start Date: " +  training_start_date); 
		System.out.println("End Date: " +  training_end_date); 
		System.out.println("Breakdown: " +  training_break_down);
		System.out.println("URL: " +  training_url);
		System.out.println("Phone: " +  training_phone);
	}
	public int getTraining_schedule_id()
	{
		return training_schedule_id;
	}
	public void setTraining_schedule_id(int training_schedule_id)
	{
		this.training_schedule_id = training_schedule_id;
	}
	public String getTraining_city()
	{
		return training_city;
	}
	public void setTraining_city(String training_city)
	{
		this.training_city = training_city;
	}
	public String getTraining_state()
	{
		return training_state;
	}
	public void setTraining_state(String training_state)
	{
		this.training_state = training_state;
	}
	public String getTraining_country()
	{
		return training_country;
	}
	public void setTraining_country(String training_country)
	{
		this.training_country = training_country;
	}
	public String getTraining_zipcode()
	{
		return training_zipcode;
	}
	public void setTraining_zipcode(String training_zipcode)
	{
		this.training_zipcode = training_zipcode;
	}
	public String getTraining_time_zone()
	{
		return training_time_zone;
	}
	public void setTraining_time_zone(String training_time_zone)
	{
		this.training_time_zone = training_time_zone;
	}
	public String getTraining_location()
	{
		return training_location;
	}
	public void setTraining_location(String training_location)
	{
		this.training_location = training_location;
	}
	public String getTraining_room_number()
	{
		return training_room_number;
	}
	public void setTraining_room_number(String training_room_number)
	{
		this.training_room_number = training_room_number;
	}
	public String getTraining_start_date()
	{
		return training_start_date;
	}
	public void setTraining_start_date(String training_start_date)
	{
		this.training_start_date = training_start_date;
	}
	public String getTraining_end_date()
	{
		return training_end_date;
	}
	public void setTraining_end_date(String training_end_date)
	{
		this.training_end_date = training_end_date;
	}
	public String getTraining_break_down()
	{
		return training_break_down;
	}
	public void setTraining_break_down(String training_break_down)
	{
		this.training_break_down = training_break_down;
	}
	public String getTraining_url()
	{
		return training_url;
	}
	public void setTraining_url(String training_url)
	{
		this.training_url = training_url;
	}
	public String getTraining_phone()
	{
		return training_phone;
	}
	public void setTraining_phone(String training_phone)
	{
		this.training_phone = training_phone;
	}
}
