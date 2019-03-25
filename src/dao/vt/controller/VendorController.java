package dao.vt.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dao.vt.vendorDetail.VendorDetail;
import dao.vt.vendorDetail.VendorDetailDAO;
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
		return "index";
	}	
	
	@RequestMapping(value="/process", method = RequestMethod.GET)
	public String process(ModelMap map) {
		List<VendorDetail> vendorDetailList = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetailList", vendorDetailList);
		System.out.println(map.toString());
		return "redirect:/";	
		//return "index";
		/*String result = "<tr>\r\n" + 
		"		<td>${vd.vendor_name}</td>\r\n" + 
		"		<td>${vd.vendor_phone}</td>\r\n" + 
		"		<td>${vd.vendor_email}</td>\r\n" + 
		"		<td>${vd.vendor_city}</td>\r\n" + 
		"		<td>${vd.vendor_state}</td>\r\n" + 
		"	</tr>";
		return result;
		 */
	}	
	
}
