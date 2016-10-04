package com.nurseaid.controller.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;


import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("session_data")
public class CmsController {
	
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(Locale locale, Model model, SessionStatus status) {
//		logger.info("Welcome home! The client locale is {}.", locale);
//		
//		status.setComplete();
//		
//		model.addAttribute("fx", "Logging out ");
//		
//		User user = new User();
//        model.addAttribute("userForm", user);
//		
//		return "login";
//	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/admin/cms", method = RequestMethod.GET)
	public String listCms(Locale locale, Model model, HttpSession sess) {
		
		//User v = (User)sess.getAttribute("session_data");
		
		//model.addAttribute("fx", "HomeController : home() " + v.getUserName());
		model.addAttribute("fx", "data list here...");
		
		return "admin/cms/list";
	}
	
}
