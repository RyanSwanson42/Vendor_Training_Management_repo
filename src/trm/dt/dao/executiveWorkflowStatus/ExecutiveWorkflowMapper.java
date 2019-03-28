package trm.dt.dao.executiveWorkflowStatus;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ExecutiveWorkflowMapper implements RowMapper<ExecutiveWorkflow>
{

	@Override
	public ExecutiveWorkflow mapRow(ResultSet result, int arg1)
			throws SQLException {
		
		
		ExecutiveWorkflow ew = new ExecutiveWorkflow();
		ew.setExecutive_workflow_status_id(result.getInt("executive_workflow_status_id"));
		ew.setTraining_request_id(result.getInt("training_request_id"));
		ew.setExecutive_id(result.getInt("executive_id"));
		ew.setSent_invitations(result.getInt("sent_invitations"));
		ew.setCompleted_skillport_enrollment(result.getInt("completed_skillport_enrollment"));
		ew.setAssessments_recorded(result.getInt("assessments_recorded"));
		ew.setVendor_training_clearance(result.getInt("vendor_training_clearance"));
		ew.setCompleted_feedback(result.getInt("completed_feedback"));
		ew.setTraining_completed(result.getInt("training_completed"));
		return ew;
	}

}
