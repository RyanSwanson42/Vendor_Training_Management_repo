package trm.vt.dao.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.time.Instant;
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

import trm.dt.dao.developTeamTrainerRequest.DDTTrainerDOA;
import trm.dt.dao.developTeamTrainingRequest.DDTTrainingDAO;
import trm.dt.dao.executiveWorkflowStatus.ExecutiveWorkflow;
import trm.dt.dao.executiveWorkflowStatus.ExecutiveWorkflowDAO;
import trm.dt.dao.inProcessCard.InProcessCard;
import trm.dt.dao.inProcessCard.InProcessCardDAO;
import trm.dt.dao.inTrainingCard.InTrainingCard;
import trm.dt.dao.inTrainingCard.InTrainingCardDAO;

import trm.dt.dao.trainingManagementStatus.ManagmentStatusDAO;
import trm.dt.dao.trainingRequest.TrainingRequest;

import trm.dt.dao.trainingSchedule.DDTTrainingScheduleDAO;
import trm.dt.ddtProjectQueries.CallbackFunction;
import trm.dt.trial.DDTProject.DTTProcessingCard;
import trm.dt.trial.DDTProject.DTTdaoServices;
import trm.it.bl.InputForm;
import trm.it.bl.InputFormServices;
import trm.it.dao.getName.GetName;
import trm.it.dao.getName.GetNameDAO;
import trm.it.dao.internalTrainingRequest.InternalTrainingRequestDAO;
import trm.it.dao.internalTrainingRequestAndStatus.InternalTrainingRequestAndStatus;
import trm.it.dao.internalTrainingRequestAndStatus.InternalTrainingRequestAndStatusDAO;
import trm.pm.dbo.TrainingRequestLog;
import trm.pm.dbo.TrainingRequestLogDAO;
/*import trm.it.dao.trainingManagementStatus.TrainingManagementStatusDAO;*/
import trm.vt.bl.SecurityCheck;
import trm.vt.dao.SpocChart.SpocChart;
import trm.vt.dao.SpocChart.SpocChartDao;
import trm.vt.dao.SpocChartMonth.SpocChartMonth;
import trm.vt.dao.SpocChartMonth.SpocChartMonthDao;
import trm.vt.dao.SpocChartStatus.SpocChartStatus;
import trm.vt.dao.SpocChartStatus.SpocChartStatusDao;
import trm.vt.dao.employee.Employee;
import trm.vt.dao.employee.EmployeeDAO;
import trm.vt.dao.trainingRequest.TrainingRequestDAO;
import trm.vt.dao.trainingRequestAndStatus.TrainingRequestAndStatus;
import trm.vt.dao.trainingRequestAndStatus.TrainingRequestAndStatusDAO;
import trm.vt.dao.trainingSchedule.TrainingSchedule;
import trm.vt.dao.trainingSchedule.TrainingScheduleDAO;
import trm.vt.dao.vendorDetail.VendorDetail;
import trm.vt.dao.vendorDetail.VendorDetailDAO;
import trm.vt.dao.vendorShortListPt.VendorShortListPtDAO;
import trm.vt.dao.vendorShortListPtAndVendorDetails.VendorShortListPtAndVendorDetails;
import trm.vt.dao.vendorShortListPtAndVendorDetails.VendorShortListPtAndVendorDetailsDAO;
import trm.vt.dao.vendorShortListSpoc.VendorShortListSpocDAO;
import trm.vt.dao.vendorShortListSpocAndVendorDetails.VendorShortListSpocAndVendorDetails;
import trm.vt.dao.vendorShortListSpocAndVendorDetails.VendorShortListSpocAndVendorDetailsDAO;
import trm.vt.dao.vendorTrainingRequest.VendorTrainingRequestDAO;
import trm.vt.dao.vendorTrainingRequestAndStatus.VendorTrainingRequestAndStatus;
import trm.vt.dao.vendorTrainingRequestAndStatus.VendorTrainingRequestAndStatusDAO;

@Controller
public class VendorController {

	/****************************************************************************/
	/** ------ Login, logout, login error, and restricted access services ------ **/
	/****************************************************************************/

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

	/****************************************************************************/
	/** --------- Upon login, Route user to either SPOC or PM Dashboard--------- **/
	/****************************************************************************/

	// Decide where to route user
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
			if (jobTitle.equals("SPOC"))
				return "redirect:/dashboard";
			else if (jobTitle.equals("Project Manager"))
				return "redirect:/pm/alltraining";
			else
				return "redirect:/restricted";
		}
	}

	// Route user to the PM Dashboard
	@RequestMapping(value = "/firstpage")
	public String PMView() {
		return "firstpage";
	}

	/****************************************************************************/
	/**---------------------- SPOC Dashboard Service --------------------------**/
	/****************************************************************************/

	// Route user to the SPOC Dashboard
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
		List<TrainingRequestAndStatus> list100 = new TrainingRequestAndStatusDAO()
				.getTrainingRequestDetail100(uservertical);
		map.addAttribute("trainingRequestList", list100);

		// ---------------------------- VT Team Cards -------------------------------//
		List<VendorTrainingRequestAndStatus> list303 = new VendorTrainingRequestAndStatusDAO()
				.getTrainingRequestDetail303(uservertical);
		map.addAttribute("vendorTrainingRequestList2", list303);
		List<VendorTrainingRequestAndStatus> list330 = new VendorTrainingRequestAndStatusDAO()
				.getTrainingRequestDetail330(uservertical);
		map.addAttribute("vendorTrainingRequestList3", list330);
		
		//System.out.println("-----------------------" + list303.toString());

		// Get list of all vendors in the system
		List<VendorDetail> vendorDetails = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetails", vendorDetails);

		// ---------------------------- DT Team Cards -------------------------------//
		List<InProcessCard> inProcess;
		List<InTrainingCard> itc;

		inProcess = new InProcessCardDAO().getInProcessCardList(uservertical);
		itc = new InTrainingCardDAO().getInTrainingCardList(uservertical);
		System.out.println(inProcess.toString());
		map.addAttribute("inProcessList", inProcess);
		map.addAttribute("TRM_DTT_Homepage3", itc);
	

		// ---------------------------- IT Team Cards -------------------------------//
		List<InternalTrainingRequestAndStatus> list103 = new InternalTrainingRequestAndStatusDAO()
				.getTrainingRequestDetail103(uservertical);
		map.addAttribute("internalTrainingRequestList2", list103);
		List<InternalTrainingRequestAndStatus> list130 = new InternalTrainingRequestAndStatusDAO()
				.getTrainingRequestDetail130(uservertical);
		map.addAttribute("internalTrainingRequestList3", list130);

		//System.out.println(list103.toString());
		
		return "index";
	}
	
	// Get Progress/Status of the Vendor Training Request
	@RequestMapping(value = "/logs", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] getLogs(@RequestParam("id") int id, ModelMap map) throws JsonGenerationException, JsonMappingException, IOException {
		int training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithVendorTrainingRequestId(id);
		List<trm.vt.dao.trainingRequestLog.TrainingRequestLog> logs =  new trm.vt.dao.trainingRequestLog.TrainingRequestLogDAO().getTrainingRequestLog(training_request_id);
		System.out.println("THE LOGS ARE --------------------- " + logs.toString());
		
		map.addAttribute("vendorLogs", logs);
		
		// Convert List to JSON using JacksonMapper
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, logs);
		final byte[] JSON = out.toByteArray();
		System.out.println(new String(JSON));
		return JSON;
	}

	/****************************************************************************/
	/**----------------- Services for processing new requests -----------------**/
	/****************************************************************************/

	// Change from status 100 to 103 (IT Training)
	@RequestMapping(value = "/toProcessing/it/{req_id}")
	public String toProcessingIT(@PathVariable("req_id") int[] req_id, HttpServletRequest request) {
		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();

		for (int i = 0; i < req_id.length; i++) {
			new InternalTrainingRequestDAO().insertInternalTrainingRequest(req_id[i]);
			new CallbackFunction().statusChange(req_id[i], 103, firstName, lastName);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Internal Trainer");
		}
		return "redirect:/dashboard";
	}

	// Change from status 100 to 203 (DT Training)
	@RequestMapping(value = "/toProcessing/dt/{req_id}")
	public String toProcessingDT(@PathVariable("req_id") int[] req_id, HttpServletRequest request) {

		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		
		Instant instant = Instant.now();
		Timestamp timestamp = Timestamp.from(instant);
		for (int i = 0; i < req_id.length; i++) {
			
			
			int DDTScheduleId = new DDTTrainingScheduleDAO().getScheduleId();
			new DDTTrainingScheduleDAO().insertTrainingSchedule(DDTScheduleId, null, null, null, null, null, null, null, null, null, null, null, 0);
			
			int DDTTrainerReqId = new DDTTrainerDOA().getTrainerRequestId();
			new DDTTrainerDOA().insertDTTrainer(DDTTrainerReqId, timestamp, 1000000, DDTScheduleId, null, null, null, 0);
			
			System.out.println("Schedule ID: " + DDTScheduleId);
			System.out.println("DDTTrainer ID: " + DDTTrainerReqId);
			
			new DDTTrainingDAO().insertDDTTrainingWithDTTID(req_id[i],DDTScheduleId, DDTTrainerReqId);
			new CallbackFunction().statusChange(req_id[0], 203, firstName, lastName);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Dev Team Trainer");
			
			
		}
		return "redirect:/dashboard";

	}
	
	//DT Accordion Current Trainer Update 
/*	@RequestMapping(value ="updateTrainer/{dtt_trainer_request_id}")
	public String updateCurrentTrainer(@ModelAttribute("Employee") Employee emp, @PathVariable("dtt_trainer_request_id") int dtt_trainer_request_id)
	{
		int empId = emp.getEmployee_id();
		
		new DDTTrainerDOA().updateTrainerId(dtt_trainer_request_id, empId);
		System.out.println("dtt_trainer_req_id: " + dtt_trainer_request_id);
		System.out.println("Trainer_id: " + empId);
		System.out.println(emp.getCity());
		return "redirect:/dashboard";
	} */

	//DT Start Date and End Date Update
	@RequestMapping(value ="updateDate/{dtt_trainer_request_id}/{training_request_id}")
	public String updateStartEndDate(HttpServletRequest request,@PathVariable("training_request_id") int training_request_id, @PathVariable("dtt_trainer_request_id") int dtt_trainer_request_id, @ModelAttribute("TrainingRequest") TrainingRequest req, @ModelAttribute("Employee") Employee emp)
	{
		
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		
		int empId = emp.getEmployee_id();
		System.out.println("dtt_trainer_req_id: " + dtt_trainer_request_id);
		System.out.println("Trainer_id: " + empId);
		System.out.println(emp.getCity());
			
		
		new DDTTrainerDOA().updateTrainerId(dtt_trainer_request_id, empId);
		
		System.out.println("start date");
		String startDate = req.getRequest_start_date();
		System.out.println(startDate);
		
		String startDateYear = startDate.substring(0, 4);
		System.out.println(Integer.parseInt(startDateYear));
		
		String startDateMonth = startDate.substring(5, 7);
		System.out.println(startDateMonth);
		
		String startDateDay = startDate.substring(8);
		System.out.println(startDateDay);
		
		@SuppressWarnings("deprecation")
		Timestamp fullStartDate = new Timestamp(Integer.parseInt(startDateYear) - 1900, Integer.parseInt(startDateMonth) - 1, Integer.parseInt(startDateDay), 0, 0, 0, 0);
		System.out.println(fullStartDate);
		
		System.out.println("----------------------------end date");
		String endDate = req.getRequest_end_date();
		System.out.println(endDate);
		
		String endDateYear = endDate.substring(0, 4);
		System.out.println(Integer.parseInt(endDateYear));
		
		String endDateMonth = endDate.substring(5, 7);
		System.out.println(endDateMonth);
		
		String endDateDay = startDate.substring(8);
		System.out.println(endDateDay);
		
		@SuppressWarnings("deprecation")
		Timestamp fullEndDate = new Timestamp(Integer.parseInt(endDateYear) - 1900, Integer.parseInt(endDateMonth) - 1, Integer.parseInt(endDateDay), 0, 0, 0, 0);
		System.out.println(fullEndDate);
		
		new trm.dt.dao.trainingRequest.TrainingRequestDAO().updateEndStartDate(fullStartDate, fullEndDate, training_request_id);
		System.out.println("updated");
		
		new trm.dt.dao.trainingRequest.TrainingRequestDAO().updateTrainingRequestMode(training_request_id, req.getRequest_training_mode());
		System.out.println("updated Mode " + req.getRequest_training_mode());
		
		new CallbackFunction().statusChange(training_request_id, 210, firstName, lastName);
		
		return "redirect:/dashboard";
	}
	
	
	@RequestMapping(value = "trainingSchedule/{training_schedule_id}/{training_request_id}")
	public String update(HttpServletRequest request,  @ModelAttribute("TrainingSchedule") trm.dt.dao.trainingSchedule.TrainingSchedule s, @ModelAttribute("TrainingRequest") TrainingRequest req,
			@PathVariable("training_schedule_id") int training_schedule_id, @PathVariable("training_request_id") int training_request_id) {
		
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		
		int zip = s.getTraining_zipcode();
		String sZip = String.valueOf(zip);
		
		new DDTTrainingScheduleDAO().updateTrainingSchedule(training_schedule_id, s.getTraining_city(), s.getTraining_state(), s.getTraining_country(), sZip, s.getTraining_time_zone(), s.getTraining_location(), s.getTraining_room_number(), s.getTraining_break_down(), s.getTraining_url(), Double.parseDouble(s.getTraining_phone()));
		
		  new CallbackFunction().statusChange(training_request_id, 203, firstName, lastName);
		
		return "redirect:/dashboard";
	}  
	
	@RequestMapping(value = "/toProcessing/vt/{req_id}")
	public String toProcessingVT(@PathVariable("req_id") int[] req_id, HttpServletRequest request) {
		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		for (int i = 0; i < req_id.length; i++) {
			// TODO: update status of red_id[i]
			new VendorTrainingRequestDAO().insertVendorTrainingRequestWithTRID(req_id[i]);
			new CallbackFunction().statusChange(req_id[i], 303, firstName, lastName);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Vendor Trainer");
		}
		return "redirect:/dashboard";
	}
	
	/****************************************************************************/
	/**--------------- Services switching between request types  --------------**/
	/****************************************************************************/

	// Change to IT from (DT or VT)
	@RequestMapping(value = "/changeProcessing/it/{req_id}/{type}")
	public String changeProcessingIT(@PathVariable("req_id") int req_id, @PathVariable("type") String type, HttpServletRequest request) {
		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		int training_request_id = 0;
		if (type.equals("Vendor"))
			training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithVendorTrainingRequestId(req_id);
		if (type.equals("Develop"))
			training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithDevelopTrainingRequestId(req_id);
		new CallbackFunction().clearPreviousTrainingRequset(training_request_id);
		new InternalTrainingRequestDAO().insertInternalTrainingRequest(training_request_id);
		new CallbackFunction().statusChange(training_request_id, 103, firstName, lastName);
		return "redirect:/dashboard";
	}

	// Change to DT from (IT or VT)
	@RequestMapping(value = "/changeProcessing/dt/{req_id}/{type}")
	public String changeProcessingDT(@PathVariable("req_id") int req_id, @PathVariable("type") String type, HttpServletRequest request) {
		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		Instant instant = Instant.now();
        Timestamp timestamp = Timestamp.from(instant);
		
		int DDTScheduleId = new DDTTrainingScheduleDAO().getScheduleId();
        new DDTTrainingScheduleDAO().insertTrainingSchedule(DDTScheduleId, null, null, null, null, null, null, null, null, null, null, null, 0);
        
        int DDTTrainerReqId = new DDTTrainerDOA().getTrainerRequestId();
        new DDTTrainerDOA().insertDTTrainer(DDTTrainerReqId, timestamp, 1000000, DDTScheduleId, null, null, null, 0);
		
		int training_request_id = 0;
		if (type.equals("Vendor"))
			training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithVendorTrainingRequestId(req_id);
		if (type.equals("Internal"))
			training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithInternalTrainingRequestId(req_id);
		new CallbackFunction().clearPreviousTrainingRequset(training_request_id);

		new DDTTrainingDAO().insertDDTTrainingWithDTTID(training_request_id,DDTScheduleId, DDTTrainerReqId);
		new CallbackFunction().statusChange(training_request_id, 203, firstName, lastName);

		return "redirect:/dashboard";
	}

	// Change to VT from (DT or IT)
	@RequestMapping(value = "/changeProcessing/vt/{req_id}/{type}")
	public String changeProcessingVT(@PathVariable("req_id") int req_id, @PathVariable("type") String type, HttpServletRequest request) {
		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		int training_request_id = 0;
		if (type.equals("Develop"))
			training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithDevelopTrainingRequestId(req_id);
		if (type.equals("Internal"))
			training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithInternalTrainingRequestId(req_id);
		new CallbackFunction().clearPreviousTrainingRequset(training_request_id);
		new VendorTrainingRequestDAO().insertVendorTrainingRequestWithTRID(training_request_id);
		new CallbackFunction().statusChange(training_request_id, 303, firstName, lastName);
		return "redirect:/dashboard";
	}
	
	/****************************************************************************/
	/** ----------------- Vendor Training Management Services ------------------ **/
	/****************************************************************************/

	// Reporting Tab
	@RequestMapping(value = "/report")
	public String ChartJs(ModelMap map, HttpServletRequest request) {

		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String vertical = user.getVertical();
		map.addAttribute("username", username);
		map.addAttribute("uservert", vertical);

		/************************************
		 * Set all list for Chart Information
		 ************************************/
		List<SpocChart> sc = new SpocChartDao().getChartTrainingRequestInfo(vertical);
		List<SpocChart> sc1 = new SpocChartDao().GetTotalParticipants(vertical);
		List<SpocChartMonth> spm1 = new SpocChartMonthDao().getItChartTrainingRequestInfo(vertical);
		List<SpocChartMonth> spm2 = new SpocChartMonthDao().getVtChartTrainingRequestInfo(vertical);
		List<SpocChartMonth> spm3 = new SpocChartMonthDao().getDttChartTrainingRequestInfo(vertical);

		/***************************************
		 * Adding All Chart Statuses to one list
		 **************************************/
		List<SpocChartStatus> scp1 = new ArrayList<SpocChartStatus>();
		scp1.add(new SpocChartStatusDao().GetStatusLeft(vertical).get(0));
		scp1.add(new SpocChartStatusDao().GetStatusMiddle(vertical).get(0));
		scp1.add(new SpocChartStatusDao().GetStatusRight(vertical).get(0));
		scp1.get(0).setStatus("PreProcessing");
		scp1.get(1).setStatus("Processing");
		scp1.get(2).setStatus("PostProcessing");

		/************************************************
		 * Mapping All Chart Information To The Front End
		 ************************************************/
		map.addAttribute("SpocChartList", sc);
		map.addAttribute("spcParticipants", sc1);
		map.addAttribute("ITMonth", spm1);
		map.addAttribute("VTMonth", spm2);
		map.addAttribute("DTTMonth", spm3);
		map.addAttribute("Status", scp1);

		return "report";

	}
	
	/*----------------- Modal and accordion services for Vendor Training Requests----------------------------*/

	// Get Progress/Status of the Vendor Training Request
	@RequestMapping(value = "/progress", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] progress(@RequestParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {

		int training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithVendorTrainingRequestId(id);
		trm.vt.dao.trainingManagementStatus.TrainingManagementStatus status = new trm.vt.dao.trainingManagementStatus.TrainingManagementStatusDAO()
				.getTrainingManagementStatusWithTrainingRequestID(training_request_id);

		// Convert List to JSON using JacksonMapper
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, status);
		final byte[] JSON = out.toByteArray();
		System.out.println(new String(JSON));
		return JSON;
	}

	// Gets the list of Vendors Shortlisted by a SPOC
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

	// Shortlists the SPOC's Vendor Shortlist by inserting into the PT Shortlist Table and changes status
	@RequestMapping(value = "/vendor/PTApproved/{req_id}/{vendor_ids}")
	public String PTApproved(@PathVariable("req_id") int req_id, @PathVariable("vendor_ids") int[] vendor_ids, HttpServletRequest request) {
		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		System.out.println("Updating PT approved vendors from SPOC vendors for " + req_id);
		for (int i = 0; i < vendor_ids.length; i++) {
			// move names[i] to SPOC list
			new VendorShortListPtDAO().insertVendorShortListPt(req_id, vendor_ids[i]);
			System.out.println(vendor_ids[i] + " added to PT ShortList");
		}
		int training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithVendorTrainingRequestId(req_id);
		new CallbackFunction().statusChange(training_request_id, 305, firstName, lastName);

		String rtrn = "redirect:/dashboard#myModal" + req_id + "#2";
		return rtrn;
	}

	// Gets the list of Vendors Shortlisted by a PT Team
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

	// Sends PT Team Shortlist to the Project Manager
	@RequestMapping(value = "/PTListtoPM/{id}")
	public String insertTrainingSchedule(@PathVariable("id") int id, HttpServletRequest request) {
		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		int training_request_id = new TrainingRequestDAO().getTrainingRequestIdWithVendorTrainingRequestId(id);
		new CallbackFunction().statusChange(training_request_id, 310, firstName, lastName);
		String rtrn = "redirect:/dashboard#myModal" + Integer.toString(id);
		return rtrn;
	}

	// Inserts the start and end dates of the training
	@RequestMapping(value = "/insertDates/{id}/{start}/{end}")
	public String insertTrainingSchedule(@PathVariable("id") int id, @PathVariable("start") String start,
			@PathVariable("end") String end) {
		Timestamp startDate = Timestamp.valueOf(start + " 00:00:00");
		Timestamp endDate = Timestamp.valueOf(end + " 00:00:00");
		int schedule_id = new TrainingScheduleDAO().insertStartDateAndEndDate(startDate, endDate);
		System.out.println("the id is : " + schedule_id);
		new VendorTrainingRequestDAO().updateVendorTrainingRequestWithScheduleId(schedule_id, id);
		String rtrn = "redirect:/dashboard#myModal" + Integer.toString(id);
		return rtrn;
	}

	// Inserts the entire training schedule form; whereas the above methods only inserts the start and end dates
	@RequestMapping(value = "trainingSchedule/{id}")
	public String insertTrainingScheduleForm(@PathVariable("id") int id, HttpServletRequest request) {
		Timestamp startDate = Timestamp.valueOf(request.getParameter("startDate") + " 00:00:00");
		Timestamp endDate = Timestamp.valueOf(request.getParameter("endDate") + " 00:00:00");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String zipcode = request.getParameter("zipcode");
		String timezone = request.getParameter("timezone");
		String location = request.getParameter("location");
		String room = request.getParameter("room");
		String breakdown = request.getParameter("breakdown");
		String url = request.getParameter("url");
		String audio = request.getParameter("audio");
		int schedule_id = new TrainingScheduleDAO().insertTrainingSchedule(city, state, country, zipcode, timezone,
				location, room, startDate, endDate, breakdown, url, audio);
		System.out.println("the id is : " + schedule_id);
		new VendorTrainingRequestDAO().updateVendorTrainingRequestWithScheduleId(schedule_id, id);
		String rtrn = "redirect:/dashboard#myModal" + Integer.toString(id);
		return rtrn;
	}

	// Selects the Training Schedule for the Vendor Training Request and populates the form
	@RequestMapping(value = "/section4", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section4(@RequestParam("id") int id)
			throws JsonGenerationException, JsonMappingException, IOException {
		// Get Complex Object
		int tid = new TrainingScheduleDAO().getTrainingScheduleID(id);
		TrainingSchedule dates = new TrainingScheduleDAO().getTrainingSchedule(tid);
		dates.setTraining_start_date(dates.getTraining_start_date().split(" ")[0]);
		dates.setTraining_end_date(dates.getTraining_end_date().split(" ")[0]);

		// Convert List to JSON using JacksonMapper
		final ByteArrayOutputStream out = new ByteArrayOutputStream();
		final ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(out, dates);
		final byte[] JSON = out.toByteArray();
		System.out.println(new String(JSON));
		return JSON;
	}

	// ------------------------------ Vendor Management Tab -----------------------------------//
	@RequestMapping(value = "/vendormanagement/{id}")
	public String vendorManagementView(@PathVariable String id, ModelMap map, HttpServletRequest request) {
		// Get Session
		request.getSession().setAttribute("vid", id);
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String uservertical = user.getVertical();
		String userfname = user.getFirst_name();
		String userlname = user.getLast_name();
		map.addAttribute("username", username);
		map.addAttribute("uservert", uservertical);
		map.addAttribute("fname", userfname);
		map.addAttribute("lname", userlname);
		List<VendorDetail> vendorDetails = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetails", vendorDetails);
		return "vendormanagement";
	}

	@RequestMapping(value = "vendormanagement/submitVendors", method = RequestMethod.POST)
	@ResponseBody
	public String submitVendors(@RequestParam(value = "idList") List<String> idList, HttpServletRequest request) {

		// Get Session of employee who logged in
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String firstName = user.getFirst_name();
		String lastName = user.getLast_name();
		System.out.println("Inside submitVendors service.");

		String vid = request.getSession().getAttribute("vid").toString();

		for (String id : idList) {
			new VendorShortListSpocDAO().insertVendorShortListSpoc(Integer.parseInt(vid), Integer.parseInt(id));
		}
		System.out.println(vid);

		int training_request_id = new TrainingRequestDAO()
				.getTrainingRequestIdWithVendorTrainingRequestId(Integer.parseInt(vid));
		new CallbackFunction().statusChange(training_request_id, 304, firstName, lastName);
		String rtrn = "redirect:/dashboard#myModal" + vid;
		return rtrn;
	}

	@RequestMapping(value = "vendorForm", method = RequestMethod.GET)
	public String formView(ModelMap map, HttpServletRequest request) {
		// Get Session
		// map.addAttribute("validation", new VendorValidation());
		String username = request.getSession().getAttribute("username").toString();
		Employee user = new EmployeeDAO().getEmployeeByUsername(username);
		String uservertical = user.getVertical();
		String userfname = user.getFirst_name();
		String userlname = user.getLast_name();
		map.addAttribute("username", username);
		map.addAttribute("uservert", uservertical);
		map.addAttribute("fname", userfname);
		map.addAttribute("lname", userlname);
		System.out.println("In Vendor Form Service");
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
		new VendorDetailDAO().insertVendorDetail(name, phone, email, city, state, country, zipcode, timezone);
		return "redirect:/vendormanagement/{0}";
	}
	
	/****************************************************************************/
	/** ----------------- Develop Team Training Services ------------------ **/
	/****************************************************************************/

	// DT Accordion Update
	@RequestMapping(value = "updateTrainer/{dtt_trainer_request_id}")
	public String updateCurrentTrainer(@ModelAttribute("Employee") Employee emp,
			@PathVariable("dtt_trainer_request_id") int dtt_trainer_request_id) {
		int empId = emp.getEmployee_id();

		new DDTTrainerDOA().updateTrainerId(dtt_trainer_request_id, empId);
		System.out.println("dtt_trainer_req_id: " + dtt_trainer_request_id);
		System.out.println("Trainer_id: " + empId);
		System.out.println(emp.getCity());
		return "redirect:/dashboard";
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

	/****************************************************************************/
	/** --------------------- Internal Training Services --------------------- **/
	/****************************************************************************/

	/*
	 * @RequestMapping(value="it/{trainingID}") public String
	 * updateproduct(@PathVariable("trainingID") int trainingID, ModelMap map) {
	 * InputForm inputform = new InputFormServices().loadForm(trainingID);
	 * map.addAttribute("command", inputform); map.addAttribute("maheshFun",
	 * inputform);
	 * 
	 * GetNameDAO nameDAO = new GetNameDAO(); List<GetName> alltrainers =
	 * nameDAO.getAllTrainers(); List<String> names = new ArrayList<String>();
	 * for(GetName gn : alltrainers){ names.add(gn.getEmployee().getNames()); }
	 * map.addAttribute("alltrainers", names);
	 * 
	 * return "processInProgress"; }
	 */

	@RequestMapping(value = "it", produces = MediaType.APPLICATION_JSON_VALUE)
	public String processInProgressRedirect(ModelMap map) {
		map.addAttribute("command", new InputForm());
		return "processInProgress";
	}

	@RequestMapping(value = "itModal")
	public String updateproduct(@RequestParam("trainingID") int trainingID, ModelMap map) {
		InputForm inputform = new InputFormServices().loadForm(trainingID);
		map.addAttribute("command", inputform);
		map.addAttribute("maheshFun", inputform);

		GetNameDAO nameDAO = new GetNameDAO();
		List<GetName> alltrainers = nameDAO.getAllTrainers();
		List<String> names = new ArrayList<String>();
		for (GetName gn : alltrainers) {
			names.add(gn.getEmployee().getNames());
		}
		System.out.println(names.toString());
		map.addAttribute("alltrainers", names);

		return "processInProgress";
	}

	/*
	 * @RequestMapping(value="saveRequest/{trainingID}") // in form, ../ - come to
	 * root directory then go ahead public String
	 * updateproductservice(@ModelAttribute("inputform") InputForm
	 * inputform, @PathVariable("trainingID") int trainingID) { GetStatusDAO gs =
	 * new GetStatusDAO(); TrainingManagementStatusDAO tsdao = new
	 * TrainingManagementStatusDAO(); new
	 * InputFormServices().saveForm(inputform.getTrainingID(), new
	 * GetNameDAO().getIdByName(inputform.getTrainerName()),
	 * inputform.getTrainerName(), inputform.getMode(), inputform.getAddress(),
	 * inputform.getCity(), inputform.getRoomNum(), inputform.getUrl(),
	 * inputform.getPhoneNum(), inputform.getStartDate(), inputform.getEndDate(),
	 * inputform.getStartTime(), inputform.getEndTime(), inputform.getDescription(),
	 * inputform.getState(), inputform.getCountry(), inputform.getZipCode(),
	 * inputform.getTimeZone(), inputform.getSchedBreakdown());
	 * 
	 * return "redirect:/it/{trainingID}"; }
	 */
}
