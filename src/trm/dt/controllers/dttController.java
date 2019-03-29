package trm.dt.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import trm.dt.trial.DDTProject.DTTNewRequestCard;
import trm.dt.trial.DDTProject.DTTProcessingCard;
import trm.dt.trial.DDTProject.DTTdaoServices;
import trm.dt.trial.DDTProject.TrainingSchedule;
import trm.dt.trial.DDTProject.DTTProcessingCard;


import trm.dt.bl.SecurityCheck;
import trm.dt.dao.inTrainingCard.InTrainingCard;
import trm.dt.dao.inTrainingCard.InTrainingCardDAO;
import trm.dt.dao.executiveWorkflowStatus.ExecutiveWorkflow;
import trm.dt.dao.executiveWorkflowStatus.ExecutiveWorkflowDAO;
import trm.dt.dao.trainingManagementStatus.ManagmentStatusDAO;
import trm.dt.jt.MyTemplate;

@Controller
public class dttController {

//	@RequestMapping(value="/")
//	public String login_view()
//	{
//		System.out.println("login_view");
//		return "TRM_DTT_Homepage";
//	}

	@RequestMapping(value = "/")
	public String showall_view(ModelMap map) {
		List<DTTProcessingCard> cards;
		List<DTTNewRequestCard> newReqCards;

		List<ExecutiveWorkflow> wfCards;
		List<InTrainingCard> itc;

		cards = new DTTdaoServices().getRequestsProcessing();
		newReqCards = new DTTdaoServices().getNewRequests();
		wfCards = new ExecutiveWorkflowDAO().getExecutiveWorkflows();
		itc = new InTrainingCardDAO().getInTrainingCardList();

		map.addAttribute("TRM_DTT_Homepage", cards);
		map.addAttribute("TRM_DTT_Homepage1", newReqCards);
		map.addAttribute("TRM_DTT_Homepage2", wfCards);
		map.addAttribute("TRM_DTT_Homepage3", itc);

		return "TRM_DTT_Homepage";
	}

	@RequestMapping(value = "updateWorkflowStatus/{executive_workflow_status_id}")
	public String updateStatus(@PathVariable("executive_workflow_status_id") int wfid,
			@ModelAttribute("ewf") ExecutiveWorkflow ewf) {
		new ExecutiveWorkflowDAO().updateExecutiveWorkflow(ewf.getExecutive_workflow_status_id(),
				ewf.getSent_invitations(), ewf.getCompleted_skillport_enrollment(), ewf.getAssessments_recorded(),
				ewf.getVendor_training_clearance(), ewf.getCompleted_feedback(), ewf.getTraining_completed());

		return "redirect:/";
	}

	@RequestMapping(value = "/login")
	public String login_service(HttpServletRequest request, ModelMap model) {
		boolean result = SecurityCheck.isUserValid(request.getParameter("un"), request.getParameter("pw"));

		if (result) {
			model.addAttribute("result", result);
			return "TRM_DTT_Homepage";
		} else
			model.addAttribute("result", false);
		return "login";
	}

	@RequestMapping(value = "toProcess/{requestId}")
	public String changeStat(@PathVariable("requestId") int requestId) {
		System.out.println("got called");
		String stat = "203";
		ManagmentStatusDAO update = new ManagmentStatusDAO();
		System.out.println("got Management Status");
		update.updateManagmentStatus(requestId, stat);
		System.out.println("updated status");
		return "redirect:/";
	}

}
