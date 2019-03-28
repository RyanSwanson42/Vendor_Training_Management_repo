package dao.executiveWorkflowStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import dao.employee.Employee;
import dao.employee.EmployeeMapper;
import dao.trainingRequest.TrainingRequest;

public class ExecutiveWorkflowStatusMapper implements RowMapper<ExecutiveWorkflowStatus>{
	/*
	  executive_workflow_status_id number(5) primary key,
	  training_request_id number(5) CONSTRAINT ews_tr_fk references training_request(training_request_id) unique not null,
	  executive_id number(7) CONSTRAINT ews_exec_fk references employee(employee_id),
	  sent_invitations number(2),
	  completed_skillport_enrollment number(2),
	  assessments_recorded number(2),
	  vendor_training_clearance number(2),
	  completed_feedback number(2),
	  training_completed number(2)
	*/
	
	public ExecutiveWorkflowStatus mapRow(ResultSet result, int arg1)
			throws SQLException {
		ExecutiveWorkflowStatus ews = new ExecutiveWorkflowStatus();
		ews.setExecutive_workflow_status_id(result.getInt("executive_workflow_status_id"));
		ews.setTraining_request(result.getInt("training_request_id"));
		ews.setExecutive(result.getInt("executive_id"));
		ews.setSent_invitations(result.getBoolean("sent_invitations"));
		ews.setCompleted_skillport_enrollment(result.getBoolean("completed_skillport_enrollment"));
		ews.setAssessments_recorded(result.getBoolean("assessments_recorded"));
		ews.setVendor_training_clearance(result.getBoolean("vendor_training_clearance")); 
		ews.setCompleted_feedback(result.getBoolean("completed_feedback"));
		ews.setTraining_completed(result.getBoolean("training_completed"));
		return ews;
	}
}
