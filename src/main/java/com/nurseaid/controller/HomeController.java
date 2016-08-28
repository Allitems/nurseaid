package com.nurseaid.controller;

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

import com.nurseaid.model.User;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("session_data")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
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
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model, HttpSession sess) {
		
		//User v = (User)sess.getAttribute("session_data");
		
		//model.addAttribute("fx", "HomeController : home() " + v.getUserName());
		model.addAttribute("fx", "HomeController : home() ");
		
		return "home";
	}
	
//	@RequestMapping(value = "/login", method = RequestMethod.GET)
//    public String loginPage(Locale locale, Model model) {
//		model.addAttribute("fx", "Login...");
//		
//		User user = new User();
//        model.addAttribute("userForm", user);
//		
//        return "login";
//    }
//     
//    @RequestMapping(value = "/home", method = RequestMethod.POST)
//    public String login(@Valid @ModelAttribute("userForm") User user, BindingResult result, Model model) {
//    	
//    	if (result.hasErrors()) {
//    		model.addAttribute("fx", "Error...");
//            return "login";
//        }
//    	
//    	model.addAttribute("fx", "User Details...");
//        model.addAttribute("user_detail", user);
//        
//        model.addAttribute("session_data", user);
//        
//        return "user";
//    }
	
}
