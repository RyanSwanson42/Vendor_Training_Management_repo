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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import trm.vt.bl.SecurityCheck;
import trm.vt.dao.SpocChart.SpocChart;
import trm.vt.dao.SpocChart.SpocChartDao;
import trm.vt.dao.employee.Employee;
import trm.vt.dao.employee.EmployeeDAO;
import trm.vt.dao.trainingManagementStatus.TrainingManagementStatusDAO;
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
	
	@RequestMapping(value="/")
	public String loginView() {
		return "login";
	}
	
	@RequestMapping(value="/logout")
	public String logout(ModelMap map) {
		System.out.println("Logout Controller");
		return "login";
	}
	
	@RequestMapping(value="/loginerror")
	public String logingerror(ModelMap map) {
		System.out.println("Login Error Controller");
		return "login";
	}
	@RequestMapping(value="/report")
	public String ChartJs(ModelMap map) {
		System.out.println("Report Login");
		List<SpocChart> sc = new SpocChartDao().getChartInformation("", "");
		map.addAttribute("SpocChartList",sc);
		return "report";
	}
	
//	@RequestMapping(value="/vendormanagement/{id}")
//    public String vendorManagementView(@PathVariable("id") int id) {
//		System.out.println("The training id sent is: " + id);
//        return "vendormanagement";
//    }
	
	@RequestMapping(value="/vendormanagement/{id}")
    public String vendorManagementView(ModelMap map) {
        List<VendorDetail> vendorDetails = new VendorDetailDAO().getAllVendorDetail();
        map.addAttribute("vendorDetails", vendorDetails);
        return "vendormanagement";
    }
	
	@RequestMapping(value="/login")
    public String login(HttpServletRequest request, RedirectAttributes redirectAttributes) {
                
		trm.vt.bl.SecurityCheck ob = new SecurityCheck();
        boolean result = ob.isUserValid(request.getParameter("un"), request.getParameter("up"));
        
        if(!result) {	
        	return "redirect:/loginerror";
        }
        else {
        	request.getSession().setAttribute("username", request.getParameter("un"));
        	return "redirect:/dashboard";
        }   
    }   
	
	@RequestMapping(value="/dashboard")
	public String dashboardView(ModelMap map, HttpServletRequest request) {

		String username = request.getSession().getAttribute("username").toString();
        Employee user = new EmployeeDAO().getEmployeeByUsername(username);
        String uservertical = user.getVertical();
        String userfname = user.getFirst_name();
        String userlname = user.getLast_name();
        
    	List<TrainingRequestAndStatus> list100 = new TrainingRequestAndStatusDAO().getTrainingRequestDetail100();
		map.addAttribute("trainingRequestList", list100);
		List<VendorTrainingRequestAndStatus> list102 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail303(uservertical);
		map.addAttribute("vendorTrainingRequestList2", list102);
		List<VendorTrainingRequestAndStatus> list103 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail330(uservertical);
		map.addAttribute("vendorTrainingRequestList3", list103);
		List<VendorDetail> vendorDetails = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetails", vendorDetails);
        
        map.addAttribute("username", username);
        map.addAttribute("uservert", uservertical);
        map.addAttribute("fname", userfname);
        map.addAttribute("lname", userlname);
        System.out.println("login controller");
       
        return "index";
	}
	
	@RequestMapping(value="/toProcessing/it/{req_id}")
	public String toProcessingIT(@PathVariable("req_id") String[] req_id){
		for (int i=0; i< req_id.length; i++) {
			//TODO: update status of red_id[i]
			//new TrainingRequestDAO().updateStatus(req_id[i], 102);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Internal Trainer");
		}
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/toProcessing/dt/{req_id}")
	public String toProcessingDT(@PathVariable("req_id") String[] req_id){
		for (int i=0; i< req_id.length; i++) {
			//TODO: update status of red_id[i]
			//new TrainingRequestDAO().updateStatus(req_id[i], 202);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Dev Team Trainer");
		}
		return "redirect:/dashboard";
	}
	@RequestMapping(value="/toProcessing/vt/{req_id}")
	public String toProcessingVT(@PathVariable("req_id") int[] req_id){
		for (int i=0; i< req_id.length; i++) {
			//TODO: update status of red_id[i]
			new VendorTrainingRequestDAO().insertVendorTrainingRequestWithTRID(req_id[i]);
			new TrainingManagementStatusDAO().updateTrainingManagementStatusOnPid(303, req_id[i]);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Vendor Trainer");
		}
		return "redirect:/dashboard";
	}

	@RequestMapping(value="/process", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String process() {
		return "redirect:/";
	}
	
	@RequestMapping(value="/section1", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section1(@RequestParam("id") int id) throws JsonGenerationException, JsonMappingException, IOException {
		// Get Complex Object
		List<VendorShortListSpocAndVendorDetails> shortlistSPOC = new VendorShortListSpocAndVendorDetailsDAO().getShortListSpocForSpoc(id);
		// Downcast it to get the List of VendorDetail
		ArrayList<VendorDetail> vd = new ArrayList<VendorDetail>();
		for(int i = 0; i < shortlistSPOC.size(); i++)
			vd.add(shortlistSPOC.get(i).getVd());
		// Convert List to JSON using JacksonMapper
	    final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(out, vd);
	    final byte[] JSON = out.toByteArray();
	    System.out.println(new String(JSON));
		return JSON;
	}
	
	@RequestMapping(value="/section2", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section2(@RequestParam("id") int id) throws JsonGenerationException, JsonMappingException, IOException {
		// Get Complex Object
		List<VendorShortListPtAndVendorDetails> shortlistPT = new VendorShortListPtAndVendorDetailsDAO().getShortListPtForSpoc(id);		
		// Downcast it to get the List of VendorDetail
		ArrayList<VendorDetail> vd = new ArrayList<VendorDetail>();
		for(int i = 0; i < shortlistPT.size(); i++)
			vd.add(shortlistPT.get(i).getVd());
		// Convert List to JSON using JacksonMapper
	    final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(out, vd);
	    final byte[] JSON = out.toByteArray();
	    System.out.println(new String(JSON));
		return JSON;
	}

	@RequestMapping(value="/selectDates", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section3(@RequestParam("id") int id) throws JsonGenerationException, JsonMappingException, IOException {
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
	
/*	@RequestMapping(value="/section4", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section4(@RequestParam("id") int id) throws JsonGenerationException, JsonMappingException, IOException {
		// Get Complex Object
		List<VendorShortListPtAndVendorDetails> shortlistSPOC = new VendorShortListPtAndVendorDetailsDAO().getShortListPtForSpoc(id);
		
		// Downcast it to get the List of VendorDetail
		ArrayList<VendorDetail> vd = new ArrayList<VendorDetail>();
		for(int i = 0; i < shortlistSPOC.size(); i++)
			vd.add(shortlistSPOC.get(i).getVd());
		
		// Convert List to JSON using JacksonMapper
	    final ByteArrayOutputStream out = new ByteArrayOutputStream();
	    final ObjectMapper mapper = new ObjectMapper();
	    mapper.writeValue(out, vd);
	    final byte[] JSON = out.toByteArray();
	    System.out.println(new String(JSON));
		return JSON;
	}*/
	
	@RequestMapping(value="/insertDates/{id}/{start}/{end}")
	public String insertTrainingSchedule(@PathVariable("id") int id, @PathVariable("start") String start, @PathVariable("end") String end) {
		Timestamp startDate = Timestamp.valueOf(start + " 00:00:00");
		Timestamp endDate = Timestamp.valueOf(end + " 00:00:00");
		int schedule_id = new TrainingScheduleDAO().insertStartDateAndEndDate(startDate, endDate);
		System.out.println("the id is : " + schedule_id);
		new VendorTrainingRequestDAO().updateVendorTrainingRequestWithScheduleId(schedule_id, id);
		return "redirect:/dashboard";
	}    
    
    @RequestMapping(value="/vendorForm")
    public String formView() {
        return "vendorForm";
    }
        
    @RequestMapping(value="/insertVendor")
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
    
    @RequestMapping(value="/deleteVendor")
    public String deleteVendor() {  
        return "";
    }
	

}



