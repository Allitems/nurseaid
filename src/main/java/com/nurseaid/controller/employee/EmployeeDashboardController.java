package com.nurseaid.controller.employee;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nurseaid.model.TblCms;
import com.nurseaid.model.extended.SessionModel;
import com.nurseaid.protocol.Message;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.security.TblCmsValidator;
import com.nurseaid.service.CMSService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("session_data")
public class EmployeeDashboardController extends EmployeeBaseController
{
	
	HashMap<Integer, String[]> breadcrumb;
	
	
	public EmployeeDashboardController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"/console/employee/landing", "active", getSessionName()});
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/console/employee/landing", method = RequestMethod.GET)
	public String loadLandingPage(Locale locale, Model model, HttpSession sess) {	
		
		
		model.addAttribute("home_url", "/console/employee/landing");
		buildBreadCrumb();
		model.addAttribute("breadcrumb", breadcrumb);
		
		SessionModel session_user = (SessionModel)sess.getAttribute("logged_in_user");		
		model.addAttribute("logged_in_user", session_user);
		
		return "employee/landing";
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/employee/my_profile", method = RequestMethod.GET)
	public String loadSiteSettingsPage(Locale locale, Model model, HttpSession sess) {
		model.addAttribute("home_url", "/console/employee/landing");
		buildBreadCrumb();
		
		breadcrumb.replace(0, new String[]{"/console/employee/landing", "", getSessionName()});
		breadcrumb.put(1, new String[]{"#", "active", " My Profile"});
		
		model.addAttribute("breadcrumb", breadcrumb);
		
		
		
		return "employee/my_profile";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/employee/job_history", method = RequestMethod.GET)
	public String loadAllJobsTimesheets(Locale locale, Model model, HttpSession sess) {
		model.addAttribute("home_url", "/console/employee/landing");
		buildBreadCrumb();
		
		breadcrumb.replace(0, new String[]{"/console/employee/landing", "", getSessionName()});
		breadcrumb.put(1, new String[]{"#", "active", " Job History"});
		
		model.addAttribute("breadcrumb", breadcrumb);
		
		
		
		return "employee/job_history";
	}
	
}
