package dbo;

public class Training_Participants {
	private int training_participant_id;
	private int participant_employee_id;
	private int training_session_attended;

	public String testTraining_Participants(){
		return "" + training_participant_id + " | " + participant_employee_id + " | " + training_session_attended;
	}
	public int getTraining_participant_id() {
		return training_participant_id;
	}
	public void setTraining_participant_id(int training_participant_id) {
		this.training_participant_id = training_participant_id;
	}
	public int getParticipant_employee_id() {
		return participant_employee_id;
	}
	public void setParticipant_employee_id(int participant_employee_id) {
		this.participant_employee_id = participant_employee_id;
	}
	public int getTraining_session_attended() {
		return training_session_attended;
	}
	public void setTraining_session_attended(int training_session_attended) {
		this.training_session_attended = training_session_attended;
	}
}