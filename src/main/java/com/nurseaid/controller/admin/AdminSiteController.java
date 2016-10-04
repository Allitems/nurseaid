package com.nurseaid.controller.admin;

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
public class AdminSiteController extends AdminBaseController
{
	
	HashMap<Integer, String[]> breadcrumb;
	
	
	public AdminSiteController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"#", "", getSessionName()});
		breadcrumb.put(1, new String[]{"/admin/site", "active", "Site"});
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/landing", method = RequestMethod.GET)
	public String loadLandingPage(Locale locale, Model model, HttpSession sess) {	
		
		SessionModel session_user = (SessionModel)sess.getAttribute("logged_in_user");
		
		model.addAttribute("logged_in_user", session_user);
		
		return "admin/landing";
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site", method = RequestMethod.GET)
	public String loadSiteSettingsPage(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/site";
	}
	
	
}
