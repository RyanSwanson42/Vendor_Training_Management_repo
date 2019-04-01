package trm.it.bl;

public class InputForm
{
	private int trainingID;
	private String trainerID;
	private String trainerName;	
	private String mode;
	private String address;
	private String city;
	private String roomNum;
	private String url;
	private String phoneNum;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private String description;
	private String state;
	private String country;
	private String zipCode;
	private String timeZone;
	private String schedBreakdown;
	private String statusdesc;
	/*********************
	 * GENERATED GETTERS *
	 *********************/
	public int getTrainingID()
	{
		return trainingID;
	}
	public String getTrainerID()
	{
		return trainerID;
	}
	public String getTrainerName()
	{
		return trainerName;
	}
	public String getMode()
	{
		return mode;
	}
	public String getAddress()
	{
		return address;
	}
	public String getCity()
	{
		return city;
	}
	public String getRoomNum()
	{
		return roomNum;
	}
	public String getUrl()
	{
		return url;
	}
	public String getPhoneNum()
	{
		return phoneNum;
	}
	public String getStartDate()
	{
		return startDate;
	}
	public String getEndDate()
	{
		return endDate;
	}
	public String getStartTime()
	{
		return startTime;
	}
	public String getEndTime()
	{
		return endTime;
	}
	public String getDescription()
	{
		return description;
	}
	public String getState()
	{
		return state;
	}
	public String getCountry()
	{
		return country;
	}
	public String getZipCode()
	{
		return zipCode;
	}
	public String getTimeZone()
	{
		return timeZone;
	}
	public String getSchedBreakdown()
	{
		return schedBreakdown;
	}
	
	/*********************
	 * GENERATED SETTERS *
	 *********************/
	
	public void setTrainingID(int trainingID)
	{
		this.trainingID = trainingID;
	}
	public void setTrainerID(String trainerID)
	{
		this.trainerID = trainerID;
	}
	public void setTrainerName(String trainerName)
	{
		this.trainerName = trainerName;
	}
	public void setMode(String mode)
	{
		this.mode = mode;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public void setCity(String city)
	{
		this.city = city;
	}
	public void setRoomNum(String roomNum)
	{
		this.roomNum = roomNum;
	}
	public void setUrl(String url)
	{
		this.url = url;
	}
	public void setPhoneNum(String phoneNum)
	{
		this.phoneNum = phoneNum;
	}
	public void setStartDate(String startDate)
	{
		this.startDate = startDate;
	}
	public void setEndDate(String endDate)
	{
		this.endDate = endDate;
	}
	public void setStartTime(String startTime)
	{
		this.startTime = startTime;
	}
	public void setEndTime(String endTime)
	{
		this.endTime = endTime;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public void setCountry(String country)
	{
		this.country = country;
	}
	public void setZipCode(String zipCode)
	{
		this.zipCode = zipCode;
	}
	public void setTimeZone(String timeZone)
	{
		this.timeZone = timeZone;
	}
	public void setSchedBreakdown(String schedBreakdown)
	{
		this.schedBreakdown = schedBreakdown;
	}
	public String getStatusdesc() {
		return statusdesc;
	}
	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}
	public void display() {
		System.out.println("Input form display: ");
		System.out.println("Training ID: "+ trainingID);
		System.out.println("Trainer ID: " + trainerID);
		System.out.println("Name: " + trainerName);	
		System.out.println("Mode: " + mode);
		System.out.println("Address: " + address);
		System.out.println("City: " + city);
		System.out.println("Room: " + roomNum);
		System.out.println("url: " + url);
		System.out.println("Phone: " + phoneNum);
		System.out.println("Start date: " + startDate);
		System.out.println("End Date: " + endDate);
		System.out.println("Start time: " + startTime);
		System.out.println("End time: " + endTime);
		System.out.println("Description: " + description);
		System.out.println("State: " + state);
		System.out.println("Country: " + country);
		System.out.println("Zip: " + zipCode);
		System.out.println("Time Zone: " + timeZone);
		System.out.println("Breakdown: " + schedBreakdown);	
	}	
}