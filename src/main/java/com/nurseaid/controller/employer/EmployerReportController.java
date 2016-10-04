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
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblJob;
import com.nurseaid.model.TblJobPosition;
import com.nurseaid.model.TblJobStatus;
import com.nurseaid.model.extended.EmployerJobCreateModel;
import com.nurseaid.model.extended.EmployerReportAllJobsTimesheetModel;
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
public class EmployerReportController extends EmployerBaseController
{
	
	HashMap<Integer, String[]> breadcrumb;
	
	EmployerService service = new EmployerService();
	EmployerJobCreateFormValidator v = new EmployerJobCreateFormValidator();
	
	
	public EmployerReportController(){
		
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
	@RequestMapping(value = "/console/employer/all_jobs_timesheets", method = {RequestMethod.GET, RequestMethod.POST})
	public String loadAllJobsTimesheets(@ModelAttribute("ObjForm") @Validated EmployerReportAllJobsTimesheetModel obj_form, 
			Locale locale, Model model, HttpSession sess, HttpServletRequest req) {
		model.addAttribute("home_url", "/console/employer/landing");
		buildBreadCrumb();
		
		breadcrumb.replace(0, new String[]{"/console/employer/landing", "", getSessionName()});
		breadcrumb.put(1, new String[]{"#", "active", " All Jobs Timesheets"});
		
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("list_of_job_status", HUtil.getListOfJobStatus());
		
		
		if(RequestUtility.isGet(req))
		{
			EmployerReportAllJobsTimesheetModel obj = new EmployerReportAllJobsTimesheetModel();
			model.addAttribute("list", null);
			model.addAttribute("ObjForm", obj);
		}
		else 
		if(RequestUtility.isPost(req))
		{
			PropertyUtilsBean p = new PropertyUtilsBean();
			
			JobStatusService js = new JobStatusService();
			
			Set<TblJob> s = js.filterJobs(obj_form);
			Iterator it = s.iterator();
			
			Set<TblJobEx> final_list = new HashSet<TblJobEx>();
			
			TblJobEx job_ex;
			TblJob job;
			while(it.hasNext())
			{
				job = (TblJob)it.next();
				job_ex = new TblJobEx();
				
				try {
					p.copyProperties(job_ex, job);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				job_ex.setAllotted_to(js.getAllottedStatus(job.getId()));
				
				try
				{
				if(job_ex.getAllotted_to().getJobStatus() == 5)
				{
					job_ex.setJob_status_string("Invoiced");
				}
				else
					if(job_ex.getAllotted_to().getJobStatus() == 4)
					{
						job_ex.setJob_status_string("Completed");
					}
					else
						if(job_ex.getAllotted_to().getJobStatus() == 2)
						{
							job_ex.setJob_status_string("Confirmed");
						}
						else
							if(job_ex.getAllotted_to().getJobStatus() == 0)
							{
								job_ex.setJob_status_string("Applied");
							}
							else
							{
								job_ex.setJob_status_string("Available");
							}
				}
				catch(Exception ex)
				{
					job_ex.setJob_status_string("Available");
				}
				
				if(Integer.parseInt(obj_form.getJob_status().trim()) == 15)
				{
					if(job_ex.getJob_status_string() == "Available")
					{
						final_list.add(job_ex);
					}
					
				}
				else
				{
					final_list.add(job_ex);
				}
			}
			
			model.addAttribute("list", final_list);
		}
		
		return "employer/all_jobs_timesheets";
	}
	
		
}
