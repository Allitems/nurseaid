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
 * Handles requests for login, registrations, validation and forgot password
 */
@Controller
public class AuthController {

	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/employee/register", method = {RequestMethod.GET, RequestMethod.POST})
	public String employeeRegister(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		if(RequestUtility.isGet(req))
		{
			model.addAttribute("fx", "HomeController : home() ");			
			return "auth/employee_register";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			//User v = (User)sess.getAttribute("session_data");			
			//model.addAttribute("fx", "HomeController : home() " + v.getUserName());
			return "auth/employee_register";
		}
		
		return "error";
		
	}
	
	
	
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/forgot_password", method = {RequestMethod.GET, RequestMethod.POST})
	public String forgotPassword(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		if(RequestUtility.isGet(req))
		{
			model.addAttribute("fx", "HomeController : home() ");			
			return "auth/forgot_password";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			//User v = (User)sess.getAttribute("session_data");			
			//model.addAttribute("fx", "HomeController : home() " + v.getUserName());
			return "auth/forgot_password";
		}
		
		return "error";
		
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		if(RequestUtility.isGet(req))
		{
			model.addAttribute("fx", "HomeController : home() ");			
			return "auth/login";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			//User v = (User)sess.getAttribute("session_data");			
			//model.addAttribute("fx", "HomeController : home() " + v.getUserName());
			return "auth/login";
		}
		
		return "error";
	}
	
}
