package trm.vt.dao.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import trm.dt.dao.developTeamTrainingRequest.DDTTrainingDAO;
import trm.dt.dao.executiveWorkflowStatus.ExecutiveWorkflow;
import trm.dt.dao.executiveWorkflowStatus.ExecutiveWorkflowDAO;
import trm.dt.dao.inTrainingCard.InTrainingCard;
import trm.dt.dao.inTrainingCard.InTrainingCardDAO;
import trm.dt.ddtProjectQueries.CallbackFunction;
import trm.dt.trial.DDTProject.DTTProcessingCard;
import trm.dt.trial.DDTProject.DTTdaoServices;
import trm.it.bl.InputForm;
import trm.it.bl.InputFormServices;
import trm.it.dao.getName.GetName;
import trm.it.dao.getName.GetNameDAO;
import trm.it.dao.getStatus.GetStatusDAO;
import trm.it.dao.internalTrainingRequest.InternalTrainingRequestDAO;
import trm.it.dao.internalTrainingRequestAndStatus.InternalTrainingRequestAndStatus;
import trm.it.dao.internalTrainingRequestAndStatus.InternalTrainingRequestAndStatusDAO;
import trm.it.dao.trainingManagementStatus.TrainingManagementStatusDAO;
import trm.vt.bl.SecurityCheck;
import trm.vt.dao.SpocChart.SpocChart;
import trm.vt.dao.SpocChart.SpocChartDao;
import trm.vt.dao.employee.Employee;
import trm.vt.dao.employee.EmployeeDAO;
import trm.vt.dao.trainingRequestAndStatus.TrainingRequestAndStatus;
import trm.vt.dao.trainingRequestAndStatus.TrainingRequestAndStatusDAO;
import trm.vt.dao.trainingSchedule.TrainingSchedule;
import trm.vt.dao.trainingSchedule.TrainingScheduleDAO;
import trm.vt.dao.vendorDetail.VendorDetail;
import trm.vt.dao.vendorDetail.VendorDetailDAO;
import trm.vt.dao.vendorShortListPtAndVendorDetails.VendorShortListPtAndVendorDetails;
import trm.vt.dao.vendorShortListPtAndVendorDetails.VendorShortListPtAndVendorDetailsDAO;
import trm.vt.dao.vendorShortListSpocAndVendorDetails.VendorShortListSpocAndVendorDetails;
import trm.vt.dao.vendorShortListSpocAndVendorDetails.VendorShortListSpocAndVendorDetailsDAO;
import trm.vt.dao.vendorTrainingRequest.VendorTrainingRequestDAO;
import trm.vt.dao.vendorTrainingRequestAndStatus.VendorTrainingRequestAndStatus;
import trm.vt.dao.vendorTrainingRequestAndStatus.VendorTrainingRequestAndStatusDAO;

@Controller
public class VendorController {
	
	/*------------------ Vendor Training Management Services -------------------*/
	
	@RequestMapping(value = "/")
	public String loginView() {
		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout(ModelMap map) {
		System.out.println("Logout Controller");
		return "login";
	}

	@RequestMapping(value = "/loginerror")
	public String logingerror(ModelMap map) {
		System.out.println("Login Error Controller");
		return "login";
	}
	@RequestMapping(value = "/restricted")
	public String invailduser(ModelMap map) {
		System.out.println("Login Error Controller");
		return "login";
	}

	@RequestMapping(value = "/report")
	public String ChartJs(ModelMap map) {
		System.out.println("Report Login");
		List<SpocChart> sc = new SpocChartDao().getChartInformation("", "");
		map.addAttribute("SpocChartList", sc);
		return "report";
	}

	@RequestMapping(value = "/vendormanagement/{id}")
	public String vendorManagementView(ModelMap map) {
		List<VendorDetail> vendorDetails = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetails", vendorDetails);
		return "vendormanagement";
	}

	@RequestMapping(value = "/login")
	public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
		trm.vt.bl.SecurityCheck ob = new SecurityCheck();
		boolean result = ob.isUserValid(request.getParameter("un"), request.getParameter("up"));
		if (!result)
			return "redirect:/loginerror";
		else {
			request.getSession().setAttribute("username", request.getParameter("un"));
			request.getSession().setAttribute("password", request.getParameter("up"));
			Employee user = new EmployeeDAO().getEmployeeByUsername(request.getParameter("un"));
			String jobTitle = user.getJob_title();
			if(jobTitle.equals("SPOC"))
				return "redirect:/dashboard";
			else if(jobTitle.equals("Project Manager"))
				return "redirect:/pm/alltraining";
			else
				return "redirect:/restricted";
		}
	}
	
	@RequestMapping(value = "/firstpage")
	public String PMView() {
		return "firstpage";
	}
	@RequestMapping(value = "/dashboard")
	public String dashboardView(ModelMap map, HttpServletRequest request) {
		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String uservertical = user.getVertical();
		String userfname = user.getFirst_name();
		String userlname = user.getLast_name();
		map.addAttribute("username", username);
		map.addAttribute("uservert", uservertical);
		map.addAttribute("fname", userfname);
		map.addAttribute("lname", userlname);

		// Get new training request list (common for all types of training)
		List<TrainingRequestAndStatus> list100 = new TrainingRequestAndStatusDAO().getTrainingRequestDetail100(uservertical);
		map.addAttribute("trainingRequestList", list100);
		
		// Get vendor training requests 
		List<VendorTrainingRequestAndStatus> list303 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail303(uservertical);
		map.addAttribute("vendorTrainingRequestList2", list303);
		List<VendorTrainingRequestAndStatus> list330 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail330(uservertical);
		map.addAttribute("vendorTrainingRequestList3", list330);
		
		// Get list of all vendors in the system
		List<VendorDetail> vendorDetails = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetails", vendorDetails);

		// ----------------------------  DT Team -------------------------------//
		List<DTTProcessingCard> cards;	
		List<InTrainingCard> itc;
		
		cards = new DTTdaoServices().getRequestsProcessing(uservertical);
		itc = new InTrainingCardDAO().getInTrainingCardList(uservertical);
		
		map.addAttribute("TRM_DTT_Homepage", cards);
		map.addAttribute("TRM_DTT_Homepage3", itc);		
		
		// ----------------------------  IT Team -------------------------------//
		List<InternalTrainingRequestAndStatus> list103 = new InternalTrainingRequestAndStatusDAO().getTrainingRequestDetail103(uservertical);
		map.addAttribute("internalTrainingRequestList2", list103);
		List<InternalTrainingRequestAndStatus> list130 = new InternalTrainingRequestAndStatusDAO().getTrainingRequestDetail130(uservertical);
		map.addAttribute("internalTrainingRequestList3", list130);
		
		System.out.println(list103.toString());
		
		return "index";
	}
	
	// DT Team update executive workflow status
	@RequestMapping(value = "updateWorkflowStatus/{executive_workflow_status_id}")
	public String updateStatus(@PathVariable("executive_workflow_status_id") int wfid,
			@ModelAttribute("ewf") ExecutiveWorkflow ewf) {
		new ExecutiveWorkflowDAO().updateExecutiveWorkflow(ewf.getExecutive_workflow_status_id(),
				ewf.getSent_invitations(), ewf.getCompleted_skillport_enrollment(), ewf.getAssessments_recorded(),
				ewf.getVendor_training_clearance(), ewf.getCompleted_feedback(), ewf.getTraining_completed());
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/toProcessing/it/{req_id}")
	public String toProcessingIT(@PathVariable("req_id") int[] req_id) {
		for (int i = 0; i < req_id.length; i++) {
			new InternalTrainingRequestDAO().insertInternalTrainingRequest(req_id[i]);
			new CallbackFunction().statusChange(req_id[i], 103);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Internal Trainer");
		}
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/toProcessing/dt/{req_id}")
	public String toProcessingDT(@PathVariable("req_id") int[] req_id) {
		for (int i = 0; i < req_id.length; i++) {
			new DDTTrainingDAO().insertDDTTrainingWithDTTID(req_id[i]);
			new CallbackFunction().statusChange(req_id[i], 203);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Dev Team Trainer");
		}
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/toProcessing/vt/{req_id}")
	public String toProcessingVT(@PathVariable("req_id") int[] req_id) {
		for (int i = 0; i < req_id.length; i++) {
			// TODO: update status of red_id[i]
			new VendorTrainingRequestDAO().insertVendorTrainingRequestWithTRID(req_id[i]);
			new CallbackFunction().statusChange(req_id[i], 303);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Vendor Trainer");
		}
		return "redirect:/dashboard";
	}
	//-----------------Change between training types
	@RequestMapping(value="/changeProcessing/it/{req_id}")
	public String changeProcessingIT(@PathVariable("req_id") int[] req_id){
		for (int i=0; i< req_id.length; i++) {
			new CallbackFunction().clearPreviousTrainingRequset(req_id[i]);
			new InternalTrainingRequestDAO().insertInternalTrainingRequest(req_id[i]);
			new CallbackFunction().statusChange(req_id[i], 103);
		}
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/changeProcessing/dt/{req_id}")
	public String changeProcessingDT(@PathVariable("req_id") int [] req_id){
		for (int i=0; i< req_id.length; i++) {
			new CallbackFunction().clearPreviousTrainingRequset(req_id[i]);
			new DDTTrainingDAO().insertDDTTrainingWithDTTID(req_id[i]);
			new CallbackFunction().statusChange(req_id[i], 203);
		}
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/changeProcessing/vt/{req_id}")
	public String changeProcessingVT(@PathVariable("req_id") int[] req_id){
		for (int i=0; i< req_id.length; i++) {			
			new CallbackFunction().clearPreviousTrainingRequset(req_id[i]);
			new VendorTrainingRequestDAO().insertVendorTrainingRequestWithTRID(req_id[i]);
			new CallbackFunction().statusChange(req_id[i], 303);
		}
		return "redirect:/dashboard";
	}

	/*----------------------------- Modal and accordion services for Vendor Trainings ----------------------------*/
	@RequestMapping(value = "/process", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String process() {
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/section1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section1(@RequestParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {
		// Get Complex Object
		List<VendorShortListSpocAndVendorDetails> shortlistSPOC = new VendorShortListSpocAndVendorDetailsDAO()
				.getShortListSpocForSpoc(id);
		// Downcast it to get the List of VendorDetail
		ArrayList<VendorDetail> vd = new ArrayList<VendorDetail>();
		for (int i = 0; i < shortlistSPOC.size(); i++)
			vd.add(shortlistSPOC.get(i).getVd());
		// Convert List to JSON using JacksonMapper
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, vd);
		final byte[] JSON = out.toByteArray();
		System.out.println(new String(JSON));
		return JSON;
	}

	@RequestMapping(value = "/section2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section2(@RequestParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {
		// Get Complex Object
		List<VendorShortListPtAndVendorDetails> shortlistPT = new VendorShortListPtAndVendorDetailsDAO()
				.getShortListPtForSpoc(id);
		// Downcast it to get the List of VendorDetail
		ArrayList<VendorDetail> vd = new ArrayList<VendorDetail>();
		for (int i = 0; i < shortlistPT.size(); i++)
			vd.add(shortlistPT.get(i).getVd());
		// Convert List to JSON using JacksonMapper
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, vd);
		final byte[] JSON = out.toByteArray();
		System.out.println(new String(JSON));
		return JSON;
	}

	@RequestMapping(value = "/selectDates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section3(@RequestParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {
		// Get Complex Object
		TrainingSchedule dates = new TrainingScheduleDAO().getStartDateAndEndDate(id);
		dates.setTraining_start_date(dates.getTraining_start_date().split(" ")[0]);
		dates.setTraining_end_date(dates.getTraining_end_date().split(" ")[0]);
		System.out.println(dates.toString());
		// Convert List to JSON using JacksonMapper
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, dates);
		final byte[] JSON = out.toByteArray();
		System.out.println(new String(JSON));
		return JSON;
	}

	/*
	 * @RequestMapping(value="/section4", method = RequestMethod.POST, produces =
	 * MediaType.APPLICATION_JSON_VALUE) public @ResponseBody byte[]
	 * section4(@RequestParam("id") int id) throws JsonGenerationException,
	 * JsonMappingException, IOException { // Get Complex Object
	 * List<VendorShortListPtAndVendorDetails> shortlistSPOC = new
	 * VendorShortListPtAndVendorDetailsDAO().getShortListPtForSpoc(id);
	 * 
	 * // Downcast it to get the List of VendorDetail ArrayList<VendorDetail> vd =
	 * new ArrayList<VendorDetail>(); for(int i = 0; i < shortlistSPOC.size(); i++)
	 * vd.add(shortlistSPOC.get(i).getVd());
	 * 
	 * // Convert List to JSON using JacksonMapper final ByteArrayOutputStream out =
	 * new ByteArrayOutputStream(); final ObjectMapper mapper = new ObjectMapper();
	 * mapper.writeValue(out, vd); final byte[] JSON = out.toByteArray();
	 * System.out.println(new String(JSON)); return JSON; }
	 */

	@RequestMapping(value = "/insertDates/{id}/{start}/{end}")
	public String insertTrainingSchedule(@PathVariable("id") int id, @PathVariable("start") String start,
			@PathVariable("end") String end) {
		Timestamp startDate = Timestamp.valueOf(start + " 00:00:00");
		Timestamp endDate = Timestamp.valueOf(end + " 00:00:00");
		int schedule_id = new TrainingScheduleDAO().insertStartDateAndEndDate(startDate, endDate);
		System.out.println("the id is : " + schedule_id);
		new VendorTrainingRequestDAO().updateVendorTrainingRequestWithScheduleId(schedule_id, id);
		return "redirect:/dashboard";
	}

	@RequestMapping(value = "/vendorForm")
	public String formView() {
		return "vendorForm";
	}

	@RequestMapping(value = "/insertVendor")
	public String insertVendor(HttpServletRequest request, ModelMap model) {

		String name = request.getParameter("v-name");
		String phone = request.getParameter("v-phone");
		String email = request.getParameter("v-email");
		String city = request.getParameter("v-city");
		String state = request.getParameter("v-state");
		String country = request.getParameter("v-country");
		String zipcode = request.getParameter("v-zipcode");
		String timezone = request.getParameter("v-timezone");

		System.out.println(request);
		System.out.println(name);

		new VendorDetailDAO().insertVendorDetail(name, phone, email, city, state, country, zipcode, timezone);

		return "redirect:/vendormanagement{0}";
	}

	@RequestMapping(value = "/deleteVendor")
	public String deleteVendor() {
		return "";
	}
	
/*	@RequestMapping(value="it/{trainingID}")
	public String updateproduct(@PathVariable("trainingID") int trainingID, ModelMap map)
	{
		InputForm inputform = new InputFormServices().loadForm(trainingID);
		map.addAttribute("command", inputform);
		map.addAttribute("maheshFun", inputform);
		
		GetNameDAO nameDAO = new GetNameDAO();
		List<GetName> alltrainers = nameDAO.getAllTrainers();
		List<String> names = new ArrayList<String>();
		for(GetName gn : alltrainers){
			names.add(gn.getEmployee().getNames());
		}
		map.addAttribute("alltrainers", names);
		
		return "processInProgress";
	}
*/
	
	@RequestMapping(value = "it", produces = MediaType.APPLICATION_JSON_VALUE)
	public String processInProgressRedirect(ModelMap map) {
		map.addAttribute("command", new InputForm());
		return "processInProgress";
	}
	
	@RequestMapping(value="itModal") 
	public String updateproduct(@RequestParam("trainingID") int trainingID, ModelMap map)
	{
		InputForm inputform = new InputFormServices().loadForm(trainingID);
		map.addAttribute("command", inputform);
		map.addAttribute("maheshFun", inputform);
		
		GetNameDAO nameDAO = new GetNameDAO();
		List<GetName> alltrainers = nameDAO.getAllTrainers();
		List<String> names = new ArrayList<String>();
		for(GetName gn : alltrainers){
			names.add(gn.getEmployee().getNames());
		}
		System.out.println(names.toString());
		map.addAttribute("alltrainers", names);
		
		return "processInProgress";
	}

	
	@RequestMapping(value="saveRequest/{trainingID}") // in form, ../ - come to root directory then go ahead
	public String updateproductservice(@ModelAttribute("inputform") InputForm inputform, @PathVariable("trainingID") int trainingID)
	{
		GetStatusDAO gs = new GetStatusDAO();
		TrainingManagementStatusDAO tsdao = new TrainingManagementStatusDAO();
		new InputFormServices().saveForm(inputform.getTrainingID(), new GetNameDAO().getIdByName(inputform.getTrainerName()), inputform.getTrainerName(),
				inputform.getMode(), inputform.getAddress(), inputform.getCity(),
				inputform.getRoomNum(), inputform.getUrl(), inputform.getPhoneNum(),
				inputform.getStartDate(), inputform.getEndDate(), inputform.getStartTime(),
				inputform.getEndTime(), inputform.getDescription(), inputform.getState(),
				inputform.getCountry(), inputform.getZipCode(), inputform.getTimeZone(),
				inputform.getSchedBreakdown());
	
		return "redirect:/it/{trainingID}";
	}

}
