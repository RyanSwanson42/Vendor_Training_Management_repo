package controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import dao.employee.Employee;
import dao.getName.GetName;
import dao.getName.GetNameDAO;
import bl.InputForm;
import bl.InputFormServices;
import bl.SecurityCheck;

@Controller
public class InternalTrainingController {
	
	//First page / root directory
	@RequestMapping(value="/")
	public String loginRedirect()
	{
		return "login"; //TODO: change to the login page
	}
	//Testing directives
	@RequestMapping(value="/main")
	public String mainRedirect()
	{
		return "main";
	}
	@RequestMapping(value="/processNew")
	public String processNewRedirect()
	{
		return "redirect:/processNew"; 
	}
	@RequestMapping(value="/processInProgress")
	public String processInProgressRedirect()
	{
		return "processInProgress";
	}
	@RequestMapping(value="/infoNewAndProcess")
	public String infoNewAndProcessRedirect()
	{
		return "infoNewAndProcess";
	}

	@RequestMapping(value="/login")
	public String login_service(HttpServletRequest request, ModelMap model)
	{
		boolean result = SecurityCheck.isUserValid(request.getParameter("un"), request.getParameter("up"));
		if (result )
		{
			String uid = request.getParameter("un");
			String message = "main";
			model.addAttribute("userid",uid);
			model.addAttribute("newmessage",message);
			return "main";
		}
		else return "login";
	}
	//end of testing directives	
	
//	... i dont know what the value here is going to be: get from other team... replace ...it/ with the correct path
//	@RequestMapping(value="it/{trainingID}")
	@RequestMapping(value="it/{trainingID}")
	public String updateproduct(@PathVariable("trainingID") int trainingID, ModelMap map)
	{
		System.out.println("Noob.....");
		InputForm inputform = new InputFormServices().loadForm(trainingID);
		System.out.println("Noob...saucer..");
//		inputform.setAddress("Location");
//		inputform.setCity("cit");
//		inputform.setState("Loon");
//		inputform.setTrainerName("Mahesh IS the Best and Greatest");
//		inputform.setTrainingID(10000);
		map.addAttribute("command", inputform);
		map.addAttribute("maheshFun", inputform);
		
		GetNameDAO nameDAO = new GetNameDAO();
		List<GetName> alltrainers = nameDAO.getAllTrainers();
		List<String> names = new ArrayList<String>();
//		for(GetName gn : alltrainers){
//			names.add(gn.getEmployee().getNames());
//		}
//		map.addAttribute("alltrainers", names);
		
		return "processInProgress";
	}
	
	@RequestMapping(value="saveRequest") // in form, ../ - come to root directory then go ahead
	public String updateproductservice(@ModelAttribute("inputform") InputForm inputform)
	{
		new InputFormServices().saveForm(inputform.getTrainingID(), inputform.getTrainerID(), inputform.getTrainerName(),
				inputform.getMode(), inputform.getAddress(), inputform.getCity(),
				inputform.getRoomNum(), inputform.getUrl(), inputform.getPhoneNum(),
				inputform.getStartDate(), inputform.getEndDate(), inputform.getStartTime(),
				inputform.getEndTime(), inputform.getDescription(), inputform.getState(),
				inputform.getCountry(), inputform.getZipCode(), inputform.getTimeZone(),
				inputform.getSchedBreakdown());
		return "redirect:/processInProgress";
	}
}
