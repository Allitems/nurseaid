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
public class ContentController {

	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/content/about", method = {RequestMethod.GET})
	public String contentAbout(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		return "content/general";
		
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/content/terms", method = {RequestMethod.GET})
	public String contentTerms(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		return "content/general";
		
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/content/privacy", method = {RequestMethod.GET})
	public String contentPrivacy(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		return "content/general";
		
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/content/contact", method = {RequestMethod.GET})
	public String contentContact(Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		
		return "content/contact";
		
	}
	
}
