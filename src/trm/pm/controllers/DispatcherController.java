package controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.sun.jmx.snmp.Timestamp;

import bl.SecurityCheck;
import dbo.*;

@Controller
//@SessionAttributes ({"command", "Cards"})
public class DispatcherController {
	@RequestMapping(value="/")
	public String login_view() {
		return "loginpage";
	}
	@RequestMapping(value="loginpage")
	public String check_user(HttpServletRequest request, ModelMap model) {
	    HttpSession session = request.getSession();
	    String username = request.getParameter("un");
	    String password = request.getParameter("up");
	    //model.addAttribute("username", username);
	    //model.addAttribute("password", password);
	    session.setAttribute("username", username);
	    session.setAttribute("password", password);
	    boolean res = SecurityCheck.isUserValid(username, password);
	    if (res) {
	         
	        return "redirect:/alltraining";
	    }
	    else {
	        return "error";
	    }
	}
	 @RequestMapping(value="alltraining")
	    public String alltraining_view(HttpServletRequest request, ModelMap model) {
	        HttpSession session = request.getSession();
	        String user = (String) session.getAttribute("username");
	        String pass = (String) session.getAttribute("password");
	        Employee pm = new EmployeeDAO().getEmployee(user, pass);
	        session.setAttribute("manager", pm);
	        List<TrainingRequest> reqList = new TrainingRequestDAO().getAllTrainingRequest(pm.getEmployee_id());
	        for (TrainingRequest req: reqList) {
	            req.setSpoc(new EmployeeDAO().getEmployee(req.getRequest_project_spoc()));
	            req.setStatus(new TrainingManagementStatusDAO().getTrainingManagementStatus(req.getTraining_request_id()).get(0));
	            req.setLog(new TrainingRequestLogDAO().getTrainingRequestLog(req.getTraining_request_id()));
	            req.setSchedule(new TrainingScheduleDAO().getTrainingSchedule(req.getTraining_request_id(), req.getStatus().getStatus()).get(0));
	            req.setParticipantList(new Training_ParticipantsDAO().getAllTraining_ParticipantsBySession(req.getTraining_request_id()));
	        }
	        //request.getSession().setAttribute("command", pm);
	        //request.getSession().setAttribute("Cards", reqList);
	        //System.out.println(reqList.size());
	        model.addAttribute("manager", pm);
	        model.addAttribute("Cards", reqList);
	        //System.out.println(model.get("cards").getClass());
	        return "firstpage";
	    }
	 	@RequestMapping(value="approval/{training_request_id}")
		public String approval_view(@PathVariable("training_request_id") int tid, ModelMap map) {
			map.addAttribute("tid", tid);
			return "approve";
		}
		
		@RequestMapping(value="sendApproval/{tid}")
		public String sendApproval_view(@PathVariable("tid") int tid, HttpServletRequest request) {
			String choice = request.getParameter("selection");
			String just = request.getParameter("justification");
			//System.out.println("\n\n\n\n\n" + tid + "\n\n\n\n\n");
			//System.out.println("test test");
			//System.out.println(choice + "   " + just);
			if (choice.equals("Approve")) {
				new TrainingManagementStatusDAO().updateTrainingManagementStatus(tid);
			}
			else {
				new TrainingManagementStatusDAO().updateTrainingManagementStatus(tid, just);
			}
			return "redirect:/alltraining";
		}
	    
	    @RequestMapping(value="home")
	    public String main_view() {
	        return "redirect:/alltraining";
	    }
	    
	    @RequestMapping(value="report")
	    public String report_view(HttpServletRequest request, ModelMap model) {
	        HttpSession session = request.getSession();
	        Employee emp = (Employee) session.getAttribute("manager");
	        model.addAttribute("manager", emp);
	        return "reportPage";
	    }
	    
	    @RequestMapping(value="signout")
	    public String signout_view() {
	        return "login";
	    }
	

		@RequestMapping(value= "update/module/{trid}")
		public String updateModule(@PathVariable("trid") int trid,ModelMap map)
		{
			TrainingRequest request = new TrainingRequestDAO().getTrainingRequest(trid).get(0);
			map.addAttribute("command",request);
			String[] arr= {"herro","plswork","Java FSD"};
			map.put("trainingmodule",arr);
			return "updateModule";
		}
		@RequestMapping(value= "update/details/{trid}")
		public String updateDetails(@PathVariable("trid") int trid,ModelMap map)
		{
			TrainingRequest request = new TrainingRequestDAO().getTrainingRequest(trid).get(0);
			map.addAttribute("command",request);
			return "updateDetails";
		}
		@RequestMapping(value= "update/date/{trid}")
		public String updateDate(@PathVariable("trid") int trid,ModelMap map)
		{
			TrainingRequest request = new TrainingRequestDAO().getTrainingRequest(trid).get(0);
			map.addAttribute("command",request);
			return "updateDate";
		}
		@RequestMapping(value="updateNewModule")
		public String updatewithNewModule(@ModelAttribute("trainingrequest") TrainingRequest request)
		{
			new TrainingRequestDAO().updateTrainingRequest(request.getTraining_request_id(), request.getRequest_approx_participant(), request.getJustification_of_request());
			return "redirect:/showall";
		}
		@RequestMapping(value="updateNewDate")
		public String updatewithNewDate(@ModelAttribute("trainingrequest") TrainingRequest request)
		{
			new TrainingRequestDAO().updateTrainingRequest(request.getTraining_request_id(), request.getRequest_training_type(), request.getRequest_training_module(), request.getRequest_training_module_scope(), request.getRequest_training_mode());
			return "redirect:/showall";
		}
		@RequestMapping(value="updateNewDetail")
		public String updatewithNewDetail(@ModelAttribute("trainingrequest") TrainingRequest request)
		{
			new TrainingRequestDAO().updateTrainingRequest(request.getTraining_request_id(), request.getRequest_start_date(), request.getRequest_end_date(), request.getRequest_location(), request.getRequest_time_zone());
			return "redirect:/showall";
		}
	    
	    
	    
	    
	@RequestMapping(value= "TrainingReq/")
	public String NewTraining(HttpServletRequest request, ModelMap model) {
		return "trainingrequest";
	}
	@RequestMapping(value= "TrainingReq/trainingrequest")
	public String addNewTraining(HttpServletRequest request, ModelMap model) {
        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("username");
        Employee emp = (Employee) session.getAttribute("manager");
		EmployeeDAO ES = new EmployeeDAO();
		List<Employee> emps = ES.getTRInfo(user); // fix this
		String vertical = null, location = null, state = null; int ID = 0; String timeZone=null;
		for(Employee eemp : emps) {
			vertical = eemp.getVertical();
			location = eemp.getCity();
			state = eemp.getState();
			ID = eemp.getEmployee_id();
		}
		
		timeZone = ES.getTimeZone(state);
	
		String trainingModule = request.getParameter("trainingModule");
		String moduleScope = request.getParameter("trainingModuleScope");
		String trainingMode = request.getParameter("trainingModuleMode");
		String spoc = request.getParameter("spoc");
		if(spoc.equals("-1") || spoc.equals("0")){
			spoc = "" + emp.getEmployee_id();
		}
		java.sql.Date startDate = new java.sql.Date(request.getDateHeader("startDate"));
		java.sql.Date endDate = new java.sql.Date(request.getDateHeader("endDate"));
		
		String participants = request.getParameter("participants");
		String justification = request.getParameter("justification");
		
		DatabaseUpdate DU = new DatabaseUpdate();
		
        java.sql.Date now = new java.sql.Date(new Timestamp(System.currentTimeMillis()).getDateTime());
       
		java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
		java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
		spocValue sv = new spocValue();
		DU.insertTraining(ID,vertical,"IT",trainingModule,moduleScope,trainingMode,sqlStartDate,sqlEndDate,location,
				timeZone,Integer.parseInt(participants),sv.spocVal(spoc),now,justification);
		//
		TrainingRequest tempCheckRequestID = new TrainingRequestDAO().getAllTrainingRequest(ID,vertical,"IT",trainingModule,moduleScope,trainingMode,sqlStartDate,sqlEndDate,location,
				timeZone,Integer.parseInt(participants),sv.spocVal(spoc),now,justification).get(0);
		TrainingManagementStatusDAO TMSD = new TrainingManagementStatusDAO();
		System.out.println(tempCheckRequestID.getTraining_request_id());
		TMSD.insertTrainingManagementStatus(tempCheckRequestID.getTraining_request_id(), 100);
		//
		return "redirect:/alltraining";
	}
	public class spocValue {
		public int spocVal(String spocString) {
	        if(spocString.equals(null)) {return -1;}
	        return Integer.parseInt(spocString);
	    }
	}
}