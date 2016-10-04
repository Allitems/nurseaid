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
import com.nurseaid.model.TblMessage;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.protocol.Message;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.security.FrontContactFormValidator;
import com.nurseaid.service.CMSService;
import com.nurseaid.service.SettingsService;

/**
 * Handles requests for login, registrations, validation and forgot password
 */
@Controller
public class ContentController {
	
	CMSService service = new CMSService();
	FrontContactFormValidator v = new FrontContactFormValidator();

	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/about", method = {RequestMethod.GET})
	public String contentAbout(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		TblCms o = service.getById("4");
		
		model.addAttribute("content_title", o.getTitle());
		model.addAttribute("content_text", o.getContent());
		
		return "content/general";
		
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/terms", method = {RequestMethod.GET})
	public String contentTerms(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		TblCms o = service.getById("5");
		
		model.addAttribute("content_title", o.getTitle());
		model.addAttribute("content_text", o.getContent());
		
		return "content/general";
		
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/privacy", method = {RequestMethod.GET})
	public String contentPrivacy(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		TblCms o = service.getById("6");
		
		model.addAttribute("content_title", o.getTitle());
		model.addAttribute("content_text", o.getContent());
		
		return "content/general";
		
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/contact", method = {RequestMethod.GET, RequestMethod.POST})
	public String contentContact(@ModelAttribute("ObjForm") @Validated ContactFormModel obj_form, 
			BindingResult result, Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		SettingsService settings_service = new SettingsService();
		model.addAttribute("map_address", settings_service.getByKey("NURSEAID_ADDRESS"));
		
		
		if(RequestUtility.isGet(req))
		{			
			ContactFormModel obj = new ContactFormModel();
			model.addAttribute("ObjForm", obj);
			return "content/contact";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "content/contact";
			}
			else
			{				
				Message m = service.sendMessage(obj_form);				
				
				model.addAttribute("css", m.type);
				model.addAttribute("msg", m.text);
				return "content/contact";
			}		
			
		}		
		
		return "error";
		
	}
	
}
