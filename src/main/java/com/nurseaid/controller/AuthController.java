package com.nurseaid.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nurseaid.model.TblCms;
import com.nurseaid.model.extended.EmployeeRegistrationModel;
import com.nurseaid.model.extended.ForgotPasswordFormModel;
import com.nurseaid.model.extended.LoginFormModel;
import com.nurseaid.protocol.Message;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.security.FrontEmployeeRegistrationFormValidator;
import com.nurseaid.security.FrontForgotPasswordFormValidator;
import com.nurseaid.security.FrontLoginFormValidator;
import com.nurseaid.service.AuthService;
import com.nurseaid.service.CMSService;
import com.nurseaid.service.EmployeeService;

/**
 * Handles requests for login, registrations, validation and forgot password
 */
@Controller
public class AuthController {	
	
	AuthService service = new AuthService();
	FrontLoginFormValidator v = new FrontLoginFormValidator();
	
	FrontForgotPasswordFormValidator v_forgot = new FrontForgotPasswordFormValidator();
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/forgot_password", method = {RequestMethod.GET, RequestMethod.POST})
	public String forgotPassword(@ModelAttribute("ObjForm") @Validated ForgotPasswordFormModel obj_form,
			BindingResult result, Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		if(RequestUtility.isGet(req))
		{
			ForgotPasswordFormModel obj = new ForgotPasswordFormModel();
			model.addAttribute("ObjForm", obj);		
			return "auth/forgot_password";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v_forgot.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "auth/forgot_password";
			}
			else
			{	
				
				Message m = service.sendResetPasswordEmail(obj_form);
				
				//if(m.type == "success")
				{	
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					return "auth/forgot_password";
				}
			}
			
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
	@RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
	public String logout(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		sess.removeAttribute("logged_in_user");
		sess.removeAttribute("user_id");
		
		return "redirect:/login";
		
	}
	
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST})
	public String login(@ModelAttribute("ObjForm") @Validated LoginFormModel obj_form,
			BindingResult result, Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		CMSService cms = new CMSService();
		TblCms content = cms.getById("11");
		model.addAttribute("content", content);
		
		if(RequestUtility.isGet(req))
		{
			LoginFormModel obj = new LoginFormModel();
			model.addAttribute("ObjForm", obj);
			return "auth/login";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "auth/login";
			}
			else
			{				
				Message m = service.login(obj_form, sess);				
				
				if(m.type == "success")
				{	
					if(m.text == "admin")
					{
						return "redirect:/admin/landing";
					}
					else
						if(m.text == "employer")
						{
							return "redirect:/console/employer/landing";
						}
						else
							if(m.text == "employee")
							{
								return "redirect:/console/employee/landing";
							}
							else
							{
								return "error";
							}
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					return "auth/login";
				}
				
			}
			
		}
		
		return "error";
	}
	
}
