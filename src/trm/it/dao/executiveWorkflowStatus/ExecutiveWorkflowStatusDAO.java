package trm.it.dao.executiveWorkflowStatus;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import trm.it.dao.employee.Employee;
import trm.it.dao.employee.EmployeeMapper;
import trm.it.dao.it.internalTrainingRequest.InternalTrainingRequestDAO;

public class ExecutiveWorkflowStatusDAO {
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
	ApplicationContext context;
	JdbcTemplate temp;
	
	public ExecutiveWorkflowStatusDAO() {
		context = new ClassPathXmlApplicationContext("spring-config.xml");
		temp = (JdbcTemplate) context.getBean("db");
	}
	
	public List<ExecutiveWorkflowStatus> getAllExecutiveWorkflowStatus(){
		List<ExecutiveWorkflowStatus> ewsList = temp.query("SELECT * FROM executive_workflow_status", new ExecutiveWorkflowStatusMapper());
		return ewsList;	
	}
	
	public void insertExecutiveWorkflowStatus(int trainingRequestId){
		InternalTrainingRequestDAO it = new InternalTrainingRequestDAO();
		int exid = it.getExecutive(trainingRequestId);
		String sql = "INSERT INTO executive_workflow_status VALUES(executive_workflow_status_seq.nextval, ?, ?, 0, 0, 0, 0, 0, 0)";
		temp.update(sql, new Object[]{trainingRequestId, exid});
	}
	
	public void deleteExecutiveWorkflowStatus(int executive_workflow_status_id){
		String sql = "DELETE FROM executive_workflow_status WHERE executive_workflow_status_id = ?";
		temp.update(sql, new Object[]{executive_workflow_status_id});
	}
	
	public void updateExecutiveWorkflowStatus(int executiveWorkflowStatusId, boolean sentInvitations, boolean completedSkillportEnrollment, boolean assessmentsRecorded, boolean vendorTrainingClearance, boolean completedFeedback, boolean trainingCompleted){
		String sql = "UPDATE executive_workflow_status SET sent_invitations = ?, completed_skillport_enrollment = ?, assessments_recorded = ?, vendor_training_clearance = ?, completed_feedback = ?, training_completed = ? WHERE executive_workflow_status_id = ?";
		temp.update(sql, new Object[]{sentInvitations, completedSkillportEnrollment, assessmentsRecorded, vendorTrainingClearance, completedFeedback, trainingCompleted, executiveWorkflowStatusId});
	}
	
	public ExecutiveWorkflowStatus getExecutiveWorkflowStatus(int executive_workflow_status_id){
		String sql = "SELECT * FROM executive_workflow_status WHERE executive_workflow_status_id = ?";
		List<ExecutiveWorkflowStatus> ews = temp.query(sql, new Object[]{executive_workflow_status_id}, new ExecutiveWorkflowStatusMapper());
		return ews.get(0);
	}
}
