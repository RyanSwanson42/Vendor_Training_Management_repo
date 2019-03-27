package dao.vt.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
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

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bl.SecurityCheck;
import dao.employee.Employee;
import dao.employee.EmployeeDAO;
import dao.trainingRequestAndStatus.TrainingRequestAndStatus;
import dao.trainingRequestAndStatus.TrainingRequestAndStatusDAO;
import dao.vt.SpocChart.SpocChart;
import dao.vt.SpocChart.SpocChartDao;
import dao.vt.vendorDetail.VendorDetail;
import dao.vt.vendorDetail.VendorDetailDAO;
import dao.vt.vendorShortListPtAndVendorDetails.VendorShortListPtAndVendorDetails;
import dao.vt.vendorShortListPtAndVendorDetails.VendorShortListPtAndVendorDetailsDAO;
import dao.vt.vendorShortListSpocAndVendorDetails.VendorShortListSpocAndVendorDetails;
import dao.vt.vendorShortListSpocAndVendorDetails.VendorShortListSpocAndVendorDetailsDAO;
import dao.vt.vendorTrainingRequestAndStatus.VendorTrainingRequestAndStatus;
import dao.vt.vendorTrainingRequestAndStatus.VendorTrainingRequestAndStatusDAO;

@Controller
public class VendorController {
	
/*	@RequestMapping(value="/login")
	public String login(ModelMap map) {
		System.out.println("Login Controller");
		return "redirect:/";
	}*/
	
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
	
/*	
	@RequestMapping(value="/")
	public String loginView(ModelMap map) {
		List<TrainingRequestAndStatus> list100 = new TrainingRequestAndStatusDAO().getTrainingRequestDetail100();
		map.addAttribute("trainingRequestList", list100);
		List<VendorTrainingRequestAndStatus> list102 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail303("BNFS");
		map.addAttribute("vendorTrainingRequestList2", list102);
		List<VendorTrainingRequestAndStatus> list103 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail330();
		map.addAttribute("vendorTrainingRequestList3", list103);
		List<VendorDetail> vendorDetails = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetails", vendorDetails);
		return "index";
	}	*/	
	
	@RequestMapping(value="/")
	public String loginView() {
		return "login";
	}
	
	@RequestMapping(value="/login")
    public String login(HttpServletRequest request, ModelMap map) {
        
		System.out.println("Username is : " + request.getParameter("un") + "PAssword is: " + request.getParameter("up"));
        
		bl.SecurityCheck ob = new SecurityCheck();
        boolean result = ob.isUserValid(request.getParameter("un"), request.getParameter("up"));
        System.out.println("result is: " + result);
        
        System.out.println("Username is : " + request.getParameter("un") + "PAssword is: " + request.getParameter("up"));
        if(result){
            
            String username = request.getParameter("un");
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
            //model.addAttribute("newmessage", message);
            System.out.println("login controller");
            //return "redirect:/";
           
            return "index";
        }else{
            return "redirect:/loginerror";
        }   
    }   
	
	@RequestMapping(value="/toProcessing/it/{req_id}")
	public String toProcessingIT(@PathVariable("req_id") String[] req_id){
		for (int i=0; i< req_id.length; i++) {
			//TODO: update status of red_id[i]
			//new TrainingRequestDAO().updateStatus(req_id[i], 102);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Internal Trainer");
		}
		return "redirect:/";
	}
	@RequestMapping(value="/toProcessing/dt/{req_id}")
	public String toProcessingDT(@PathVariable("req_id") String[] req_id){
		for (int i=0; i< req_id.length; i++) {
			//TODO: update status of red_id[i]
			//new TrainingRequestDAO().updateStatus(req_id[i], 202);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Dev Team Trainer");
		}
		return "redirect:/";
	}
	@RequestMapping(value="/toProcessing/vt/{req_id}")
	public String toProcessingVT(@PathVariable("req_id") String[] req_id){
		for (int i=0; i< req_id.length; i++) {
			//TODO: update status of red_id[i]
			//new TrainingRequestDAO().updateStatus(req_id[i], 302);
			System.out.println("Updating Status for Training Request: " + req_id[i] + " to Vendor Trainer");
		}
		return "redirect:/";
	}

	@RequestMapping(value="/vendormanagement/{id}")
    public String vendorManagementView(@PathVariable("id") int id) {
		System.out.println("The training id sent is: " + id);
        return "vendormanagement";
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

	@RequestMapping(value="/section3", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody byte[] section3(@RequestParam("id") int id) throws JsonGenerationException, JsonMappingException, IOException {
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
	}
	
	@RequestMapping(value="/section4", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
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
	}
	
	@RequestMapping(value="/trainingSchedule/{id}")
	public String insertTrainingSchedule(@PathVariable("id") int id, HttpServletRequest request) {
		String training_city = request.getParameter("city");
		String training_state = request.getParameter("state");
		String training_country = request.getParameter("country");
		String training_zipcode = request.getParameter("zipcode");
		//new TrainingScheduleDAO().insertTrainingSchedule(training_city, training_state, training_country, training_zipcode, training_time_zone, training_location, training_room_number, training_start_date, training_end_date, training_break_down, training_url, training_phone);
		return "redirect:/";
	}
	
	@RequestMapping(value="/vendorModal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String openVendorModal() {
		return "redirect:/";
	}
	
	@RequestMapping(value="/report")
	public String ChartJs(ModelMap map) {
		System.out.println("Report Login");
		List<SpocChart> sc = new SpocChartDao().getChartInformation("", "");
		map.addAttribute("SpocChartList",sc);
		return "report";
	}
}



