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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nurseaid.model.TblCms;
import com.nurseaid.model.extended.EmployeeRegistrationModel;
import com.nurseaid.model.extended.EmployerRegistrationModel;
import com.nurseaid.protocol.Message;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.security.FrontEmployeeRegistrationFormValidator;
import com.nurseaid.security.FrontEmployerRegistrationFormValidator;
import com.nurseaid.service.CMSService;
import com.nurseaid.service.EmployeeService;
import com.nurseaid.service.EmployerService;

/**
 * Handles requests for Employer Functions
 */
@Controller
public class EmployeeController {
	
	EmployeeService service = new EmployeeService();
	FrontEmployeeRegistrationFormValidator v = new FrontEmployeeRegistrationFormValidator();
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/employee/register", method = {RequestMethod.GET, RequestMethod.POST})
	public String registerEmployer(@ModelAttribute("ObjForm") @Validated EmployeeRegistrationModel obj_form,
			BindingResult result, final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req) {
		
		CMSService cms = new CMSService();
		TblCms content = cms.getById("10");
		model.addAttribute("content", content);
		
		
		if(RequestUtility.isGet(req))
		{
			EmployeeRegistrationModel obj = new EmployeeRegistrationModel();
			model.addAttribute("ObjForm", obj);		
			return "employee/register";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "employee/register";
			}
			else
			{				
				Message m = service.register(obj_form);				
				
				if(m.type == "success")
				{	
					model.addAttribute("css", m.type);
					content = cms.getById("9");
					model.addAttribute("msg", content.getContent());
					return "employee/register/success";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					return "employee/register";
				}
				
			}					
			
		}
		
		return "error";
		
	}
	
	
	
}
