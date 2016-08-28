package com.nurseaid.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nurseaid.protocol.RequestUtility;

/**
 * Handles requests for Employer Functions
 */
@Controller
public class EmployerController {

	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/employer/register", method = {RequestMethod.GET, RequestMethod.POST})
	public String publishJob(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		if(RequestUtility.isGet(req))
		{
			model.addAttribute("fx", "HomeController : home() ");			
			return "employer/publish_job";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			//User v = (User)sess.getAttribute("session_data");			
			//model.addAttribute("fx", "HomeController : home() " + v.getUserName());
			return "employer/publish_job";
		}
		
		return "error";
		
	}
	
	
}
