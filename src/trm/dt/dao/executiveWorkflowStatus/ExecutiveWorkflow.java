package trm.dt.dao.executiveWorkflowStatus;

import trm.dt.dao.employee.Employee;
import trm.dt.dao.employee.EmployeeDAO;
import trm.dt.dao.trainingRequest.TrainingRequest;
import trm.dt.dao.trainingRequest.TrainingRequestDAO;


public class ExecutiveWorkflow {
	private int executive_workflow_status_id;
	private int training_request_id;
	private int executive_id;
	private int sent_invitations;
	private int completed_skillport_enrollment;
	private int assessments_recorded;
	private int vendor_training_clearance;
	private int completed_feedback;
	private int training_completed;
	
	public boolean getTF(int a)
	{
		if(a==1)
			{ return true; }
		return false;
	}
	
	public TrainingRequest getRequest(int training_request_id)
	{
		TrainingRequestDAO trd = new TrainingRequestDAO();
		TrainingRequest tr = trd.getTrainingRequest(training_request_id);
		return tr;		
	}
	
	public Employee getEmployeeDetails(int executive_id)
	{
		EmployeeDAO ed = new EmployeeDAO();
		Employee d = ed.getEmployee(executive_id);
		return d;	
	}
	
	public int getExecutive_workflow_status_id() {
		return executive_workflow_status_id;
	}
	public void setExecutive_workflow_status_id(int executive_workflow_status_id) {
		this.executive_workflow_status_id = executive_workflow_status_id;
	}
	public int getTraining_request_id() {
		return training_request_id;
	}
	public void setTraining_request_id(int training_request_id) {
		this.training_request_id = training_request_id;
	}
	public int getExecutive_id() {
		return executive_id;
	}
	public void setExecutive_id(int executive_id) {
		this.executive_id = executive_id;
	}
	public int getSent_invitations() {
		return sent_invitations;
	}
	public void setSent_invitations(int sent_invitations) {
		this.sent_invitations = sent_invitations;
	}
	public int getCompleted_skillport_enrollment() {
		return completed_skillport_enrollment;
	}
	public void setCompleted_skillport_enrollment(int completed_skillport_enrollment) {
		this.completed_skillport_enrollment = completed_skillport_enrollment;
	}
	public int getAssessments_recorded() {
		return assessments_recorded;
	}
	public void setAssessments_recorded(int assessments_recorded) {
		this.assessments_recorded = assessments_recorded;
	}
	public int getVendor_training_clearance() {
		return vendor_training_clearance;
	}
	public void setVendor_training_clearance(int vendor_training_clearance) {
		this.vendor_training_clearance = vendor_training_clearance;
	}
	public int getCompleted_feedback() {
		return completed_feedback;
	}
	public void setCompleted_feedback(int completed_feedback) {
		this.completed_feedback = completed_feedback;
	}
	public int getTraining_completed() {
		return training_completed;
	}
	public void setTraining_completed(int training_completed) {
		this.training_completed = training_completed;
	}

	@Override
	public String toString() {
		return "\nExecutiveWorkflow [executive_workflow_status_id=" + executive_workflow_status_id
				+ ", training_request_id=" + training_request_id + ", executive_id=" + executive_id
				+ ", sent_invitations=" + sent_invitations + ", completed_skillport_enrollment="
				+ completed_skillport_enrollment + ", assessments_recorded=" + assessments_recorded
				+ ", vendor_training_clearance=" + vendor_training_clearance + ", completed_feedback="
				+ completed_feedback + ", training_completed=" + training_completed + "]";
	}
	
}
