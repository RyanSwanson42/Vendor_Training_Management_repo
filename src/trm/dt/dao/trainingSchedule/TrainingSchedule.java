package trm.dt.dao.trainingSchedule;

import java.net.URL;
import java.sql.Timestamp;

public class TrainingSchedule {
	private int training_schedule_id;
	private String training_city;
	private String training_state;
	private String training_country;
	private int training_zipcode;
	private String training_time_zone;
	private String training_location;
	private String training_room_number;
	private String training_start_date;
	private String training_end_date;
	private String training_break_down;
	private String training_url;
	private String training_phone;
	
	@Override
	public String toString() {
		return "TrainingSchedule [training_schedule_id=" + training_schedule_id + ", training_city=" + training_city
				+ ", training_state=" + training_state + ", training_country=" + training_country
				+ ", training_zipcode=" + training_zipcode + ", training_time_zone=" + training_time_zone
				+ ", training_location=" + training_location + ", training_room_number=" + training_room_number
				+ ", training_start_date=" + training_start_date + ", training_end_date=" + training_end_date
				+ ", training_break_down=" + training_break_down + ", training_url=" + training_url
				+ ", training_phone=" + training_phone + "]";
	}
	public int getTraining_schedule_id() {
		return training_schedule_id;
	}
	public void setTraining_schedule_id(int training_schedule_id) {
		this.training_schedule_id = training_schedule_id;
	}
	public String getTraining_city() {
		return training_city;
	}
	public void setTraining_city(String training_city) {
		this.training_city = training_city;
	}
	public String getTraining_state() {
		return training_state;
	}
	public void setTraining_state(String training_state) {
		this.training_state = training_state;
	}
	public String getTraining_country() {
		return training_country;
	}
	public void setTraining_country(String training_country) {
		this.training_country = training_country;
	}
	public int getTraining_zipcode() {
		return training_zipcode;
	}
	public void setTraining_zipcode(int training_zipcode) {
		this.training_zipcode = training_zipcode;
	}
	public String getTraining_time_zone() {
		return training_time_zone;
	}
	public void setTraining_time_zone(String training_time_zone) {
		this.training_time_zone = training_time_zone;
	}
	public String getTraining_location() {
		return training_location;
	}
	public void setTraining_location(String training_location) {
		this.training_location = training_location;
	}
	public String getTraining_room_number() {
		return training_room_number;
	}
	public void setTraining_room_number(String training_room_number) {
		this.training_room_number = training_room_number;
	}
	public String getTraining_start_date() {
		return training_start_date;
	}
	public void setTraining_start_date(String training_start_date) {
		this.training_start_date = training_start_date;
	}
	public String getTraining_end_date() {
		return training_end_date;
	}
	public void setTraining_end_date(String training_end_date) {
		this.training_end_date = training_end_date;
	}
	public String getTraining_break_down() {
		return training_break_down;
	}
	public void setTraining_break_down(String training_break_down) {
		this.training_break_down = training_break_down;
	}
	public String getTraining_url() {
		return training_url;
	}
	public void setTraining_url(String training_url) {
		this.training_url = training_url;
	}
	public String getTraining_phone() {
		return training_phone;
	}
	public void setTraining_phone(String training_phone) {
		this.training_phone = training_phone;
	}
	
	
}
