package com.nurseaid.controller.employer;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.nurseaid.core.HUtil;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblJob;
import com.nurseaid.model.TblJobPosition;
import com.nurseaid.model.TblJobStatus;
import com.nurseaid.model.extended.EmployerJobCreateModel;
import com.nurseaid.model.extended.SessionModel;
import com.nurseaid.model.extended.TblJobEx;
import com.nurseaid.model.extended.TblJobStatusEx;
import com.nurseaid.protocol.Message;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.security.EmployerJobCreateFormValidator;
import com.nurseaid.security.TblCmsValidator;
import com.nurseaid.service.CMSService;
import com.nurseaid.service.EmployerService;
import com.nurseaid.service.JobPositionService;
import com.nurseaid.service.JobService;
import com.nurseaid.service.JobStatusService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class EmployerJobCompletionController extends EmployerBaseController
{
	
	HashMap<Integer, String[]> breadcrumb;
	
	EmployerService service = new EmployerService();
	EmployerJobCreateFormValidator v = new EmployerJobCreateFormValidator();
	
	
	public EmployerJobCompletionController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"/console/employer/landing", "active", getSessionName()});
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/console/employer/job_completion_alert", method = RequestMethod.GET)
	public String loadSiteSettingsPage(Locale locale, Model model, HttpSession sess) {
		model.addAttribute("home_url", "/console/employer/landing");
		buildBreadCrumb();
		
		breadcrumb.replace(0, new String[]{"/console/employer/landing", "", getSessionName()});
		breadcrumb.put(1, new String[]{"#", "active", " Job Completion Alert"});
		
		model.addAttribute("breadcrumb", breadcrumb);
		
		int count = service.getJobCompletionAlertCount();
		
		if(count == 0)
		{
			Message m = new Message();
			m.prepareMessage(MessageCode.NO_INVOICES);
			
			model.addAttribute("message", m.text);
			return "employer/general_message";
		}
		else
		{
			Set<TblJobStatus> s = service.getCompletedJobs();
			
			model.addAttribute("list", s);
			
			return "employer/job_completion_alert";
		}
	}
	
}
