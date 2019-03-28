package dao.executiveWorkflowStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class ExecutiveWorkflowDAO 
{
	ApplicationContext context;
	public JdbcTemplate temp;
	public ExecutiveWorkflowDAO()
	{
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate)context.getBean("jtemp");
	}
	public List<ExecutiveWorkflow> getExecutiveWorkflows()
	{
		List<ExecutiveWorkflow> executiveWorkflowList =  temp.query("select * from Executive_Workflow_Status", 
				new Object[]{},new ExecutiveWorkflowMapper());
		return executiveWorkflowList;
	}
	public void updateExecutiveWorkflow(int executive_workflow_status_id,
			int sent_invitations,int completed_skillport_enrollment,
			int assessments_recorded,int vendor_training_clearance,int completed_feedback,
			int training_completed)
	{
		temp.update("update Executive_Workflow_Status set sent_invitations=?"
				+ ",completed_skillport_enrollment=?,assessments_recorded=?,vendor_training_clearance=?"
				+ ",completed_feedback=?,training_completed=? where executive_workflow_status_id=?", 
				new Object[]{sent_invitations,completed_skillport_enrollment,
						assessments_recorded,vendor_training_clearance,completed_feedback,
						training_completed,executive_workflow_status_id});
	}
	public void insertExecutiveWorkflow(int training_request_id,int executive_id,int sent_invitations,
			int completed_skillport_enrollment,int assessments_recorded,int vendor_training_clearance,
			int completed_feedback,int training_completed)
	{
		temp.update("insert into Executive_Workflow_Status values"
				+ "(executive_workflow_status_seq.nextval,?,?,?,?,?,?,?,?)",new Object[]
				{training_request_id,executive_id,sent_invitations,completed_skillport_enrollment,
				assessments_recorded,vendor_training_clearance,completed_feedback,training_completed});
	}
	public void deleteExecutiveWorkflow(int executive_workflow_status_id)
	{
		temp.update("delete from Executive_Workflow_Status where executive_workflow_status_id=?",
				new Object[]{executive_workflow_status_id});
	}
	public ExecutiveWorkflow getExecutiveWorkflow(int executive_workflow_status_id)
	{
		List<ExecutiveWorkflow> trainingRequest =  temp.query
				("select * from Executive_Workflow_Status where executive_workflow_status_id=?", 
				new Object[]{executive_workflow_status_id},new ExecutiveWorkflowMapper());
		return trainingRequest.get(0);
	}	
}
