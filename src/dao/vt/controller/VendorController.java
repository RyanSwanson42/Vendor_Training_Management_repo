package dao.vt.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	
	@RequestMapping(value="/login")
	public String login(ModelMap map) {
		System.out.println("Login Controller");
		return "redirect:/";
	}
	
	@RequestMapping(value="/logout")
	public String logout(ModelMap map) {
		System.out.println("Logout Controller");
		return "login";
	}
	
	@RequestMapping(value="/")
	public String loginView(ModelMap map) {
		List<VendorTrainingRequestAndStatus> list101 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail101();
		map.addAttribute("vendorTrainingRequestList1", list101);
		List<VendorTrainingRequestAndStatus> list102 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail102();
		map.addAttribute("vendorTrainingRequestList2", list102);
		List<VendorTrainingRequestAndStatus> list103 = new VendorTrainingRequestAndStatusDAO().getTrainingRequestDetail103();
		map.addAttribute("vendorTrainingRequestList3", list103);
		List<VendorDetail> vendorDetails = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetails", vendorDetails);
		return "index";
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
	
	@RequestMapping(value="/vendormanagement")
    public String vendorManagementView() {
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
/*	
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
	
	@RequestMapping(value="/vendorModal", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public String openVendorModal() {
		return "redirect:/";
	}*/
}



