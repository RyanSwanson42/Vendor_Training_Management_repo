package controllers;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

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
	            req.setSchedule(new DDTTrainingScheduleDAO().getTrainingSchedule(req.getTraining_request_id(), req.getStatus().getStatus()).get(0));
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
	        return "loginpage";
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
			System.out.println(request.getTraining_request_id());

			map.addAttribute("command",request);
			return "updateDetails";
		}
		@RequestMapping(value= "update/date/{trid}")
		public String updateDate(@PathVariable("trid") int trid,ModelMap map)
		{
			TrainingRequest request = new TrainingRequestDAO().getTrainingRequest(trid).get(0);
			System.out.println(request.getTraining_request_id());

			map.addAttribute("command",request);
			return "updateDate";
		}
		@RequestMapping(value="updateNewDetail")
		public String updatewithNewModule(@ModelAttribute("trainingrequest") TrainingRequest request)
		{
			System.out.println(request.getTraining_request_id());
			new TrainingRequestDAO().updateTrainingRequest(request.getTraining_request_id(), request.getRequest_approx_participant(), request.getJustification_of_request());
			return "redirect:/alltraining";
		}
		@RequestMapping(value="updateNewModule")
		public String updatewithNewDate(@ModelAttribute("trainingrequest") TrainingRequest request)
		{
			System.out.println(request.getTraining_request_id());
			if(false==new TrainingRequestDAO().updateTrainingRequest(request.getTraining_request_id(), request.getRequest_training_type(), request.getRequest_training_module(), request.getRequest_training_module_scope(), request.getRequest_training_mode())){
				return "error";
			}
			return "redirect:/alltraining";
		}
		@RequestMapping(value="updateNewDate")
		public String updatewithNewDetail(@ModelAttribute("trainingrequest") TrainingRequest request)
		{
			System.out.println(request.getTraining_request_id());
			if (false==new TrainingRequestDAO().updateTrainingRequest(request.getTraining_request_id(), request.getRequest_start_date(), request.getRequest_end_date(), request.getRequest_location(), request.getRequest_time_zone())){
				return "error";
			}
			return "redirect:/alltraining";
		}
	    
	    
	    
	    
	@RequestMapping(value= "TrainingReq/")
	public String NewTraining(HttpServletRequest request, ModelMap model) {
		return "trainingrequest";
	}
	
	
	@RequestMapping(value= "TrainingReq/trainingrequest")
	public String addNewTraining(HttpServletRequest request, ModelMap model) throws java.text.ParseException{
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
		String trainingType = request.getParameter("trainingType");
		String spoc = request.getParameter("spoc");
		if(spoc.equals("-1") || spoc.equals("0")){
			spoc = "" + emp.getEmployee_id();
		}
		
		String startDate2 = request.getParameter("startDate");
		String endDate2 = request.getParameter("endDate");
		SimpleDateFormat in = new SimpleDateFormat("yyyy-MM-dd");
		Date startDate = in.parse(startDate2);
		Date endDate = in.parse(endDate2);
		
		System.out.println("\n\n\n\n\n" + startDate.toString());
		System.out.println(endDate.toString() + " \n\n\n\n\n\n");
		
		String participants = request.getParameter("participants");
		String justification = request.getParameter("justification");
		
		DatabaseUpdate DU = new DatabaseUpdate();
		
		Timestamp timeNow = new Timestamp(System.currentTimeMillis());
		spocValue sv = new spocValue();
		DU.insertTraining(ID,vertical,trainingType,trainingModule,moduleScope,trainingMode,startDate,endDate,location,
				timeZone,Integer.parseInt(participants),sv.spocVal(spoc),timeNow,justification);
		
		
		//
		TrainingRequestDAO tr = new TrainingRequestDAO();
        int val = tr.getReqID(ID);
        TrainingManagementStatusDAO TMSD = new TrainingManagementStatusDAO();
        TMSD.insertTrainingManagementStatus(val,100);
		//
		//TrainingRequest tempCheckRequestID = new TrainingRequestDAO().getAllTrainingRequest(ID,vertical,"IT",trainingModule,moduleScope,trainingMode,sqlStartDate,sqlEndDate,location,
		//		timeZone,Integer.parseInt(participants),sv.spocVal(spoc),timeNow,justification).get(0);
		//TrainingManagementStatusDAO TMSD = new TrainingManagementStatusDAO();
		//System.out.println(tempCheckRequestID.getTraining_request_id());
		//TMSD.insertTrainingManagementStatus(tempCheckRequestID.getTraining_request_id(), 100);
		//		
		return "redirect:/alltraining";
	}
	
	public class spocValue {
		public int spocVal(String spocString) {
	        if(spocString.equals(null)) {return -1;}
	        return Integer.parseInt(spocString);
	    }
	}

	@RequestMapping(value= "TheChanger") // i need the mapping
	
	public String ChangePassword(HttpServletRequest request, ModelMap model) {
	
	    HttpSession session = request.getSession();
	    
	    String currpass = request.getParameter("currpass");
	    String storedpass = (String) session.getAttribute("password");
	    String pass1 = request.getParameter("password1");
	    String pass2 = request.getParameter("password2");
	
	    if (currpass.equals(storedpass)) {
		    SecurityCheck sc = new SecurityCheck();
		    sc.checkNewPassword((String)session.getAttribute("username"), pass1, pass2);
		
		    session.setAttribute("password", pass1);
		    return "redirect:/alltraining";
	    }
	    else {
	    	return "error";
	    }
	}
}
	
	