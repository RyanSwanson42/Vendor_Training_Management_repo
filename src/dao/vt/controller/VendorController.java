package dao.vt.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import SpocChartStatus.SpocChartStatus;
import SpocChartStatus.SpocChartStatusDao;
import aop.vt.cookieHandler.CookieHandlerAdvice;
import aop.vt.cookieHandler.CookieHandlerPojo;
import bl.SecurityCheck;
import dao.employee.Employee;
import dao.employee.EmployeeDAO;
import dao.vt.SpocChart.SpocChart;
import dao.vt.SpocChart.SpocChartDao;
import dao.vt.SpocChartMonth.SpocChartMonth;
import dao.vt.SpocChartMonth.SpocChartMonthDao;
import dao.vt.vendorDetail.VendorDetail;
import dao.vt.vendorDetail.VendorDetailDAO;
import dao.vt.vendorTrainingRequestAndStatus.VendorTrainingRequestAndStatus;
import dao.vt.vendorTrainingRequestAndStatus.VendorTrainingRequestAndStatusDAO;

@Controller
public class VendorController {
	
//	@RequestMapping(value="/login")
//	public String login(ModelMap map) {
//		System.out.println("Login Controller");
//		return "redirect:/";
//	}
	@RequestMapping(value="/login",method = RequestMethod.POST)
	public String login(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		
		/****************************************************************
		//check if there are any cookies already set
		Cookie cookie = null;
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			System.out.println(cookies);
		}
		*****************************************************************/
		
		bl.SecurityCheck ob = new SecurityCheck();
		boolean result = ob.isUserValid(request.getParameter("un"), request.getParameter("up"));
		
		if(result){
			String uid = request.getParameter("un");
			
			
			/*********************************************************************
			 * Broken do not and we do not need. Wanted to do server side cookies
			 * String upass = request.getParameter("up");
			 * String rememberChecked = request.getParameterValues("remember")[0];
			if(rememberChecked.equals("on")){
				CookieHandlerPojo cook = new CookieHandlerPojo();
				cook.setUsername(uid);
				cook.setPassword(upass);
				CookieHandlerAdvice cookadv = new CookieHandlerAdvice();
				cookadv.setCookie(cook,response);				

				}
				*****************************************************************/
			
			Employee user = new EmployeeDAO().getEmployee(uid);
			String uservertical = user.getVertical();
			model.addAttribute("userid", uid);
			model.addAttribute("uservert", uservertical);
			//model.addAttribute("newmessage", message);
			System.out.println("login controller");
			//return "redirect:/";
			
			return "index";
		}else{
			return "redirect:/loginerror";
		}		
		
	}
	
	@RequestMapping(value="/loginerror")
	public String loginerror(ModelMap map) {
		System.out.println("Logout Controller");
		return "login";
	}
	
	@RequestMapping(value="/report")
	public String ChartJs(ModelMap map) {
		
		/****************************************************
		 * Yosuf: Delete all my previous code from controller
		 * Add the code you added below this
		 ********************************************/
		String vertical = "BNFS";
		
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
		map.addAttribute("SpocChartList",sc);
		map.addAttribute("spcParticipants",sc1);
		map.addAttribute("ITMonth",spm1);
		map.addAttribute("VTMonth",spm2);
		map.addAttribute("DTTMonth",spm3);
		map.addAttribute("Status",scp1);

		return "report";
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
		map.addAttribute("vendorDetailList", vendorDetails);
		return "index";
	}		
	
	@RequestMapping(value="/process", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody String process(@RequestParam("id") int id, ModelMap map) {
		System.out.println("THE ID sent is: " + id);
		List<VendorDetail> vendorDetailList = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetailList", vendorDetailList);
		//System.out.println(map.toString());
		return map.toString();	
	}
	
/*	@RequestMapping(value="/process/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String process(@PathVariable("id") int id, ModelMap map) {
		System.out.println("THE ID sent is: " + id);
		List<VendorDetail> vendorDetailList = new VendorDetailDAO().getAllVendorDetail();
		map.addAttribute("vendorDetailList", vendorDetailList);
		//System.out.println(map.toString());
		//return map.toString();
		return "redirect:/";
		
	}	*/
}
