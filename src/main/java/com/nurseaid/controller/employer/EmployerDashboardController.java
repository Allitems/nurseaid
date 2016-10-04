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
public class EmployerDashboardController extends EmployerBaseController
{
	
	HashMap<Integer, String[]> breadcrumb;
	
	EmployerService service = new EmployerService();
	EmployerJobCreateFormValidator v = new EmployerJobCreateFormValidator();
	
	
	public EmployerDashboardController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"/console/employer/landing", "active", getSessionName()});
	}
	
	public Map getListOfPositions()
	{
		JobPositionService jposition_service = new JobPositionService();
		Set<TblJobPosition> s = jposition_service.getAll();
		
		Iterator it = s.iterator();
		
		Map<String,String> lv = new LinkedHashMap<String,String>();
		lv.put("-1", "--- Select Job Position ---");
		TblJobPosition o;
		while(it.hasNext())
		{
			o = (TblJobPosition)it.next();
			lv.put(String.valueOf(o.getId()), o.getTitle());
		}
		return lv;		
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/console/employer/assign_job", method = {RequestMethod.POST})
	public void assignJob(Model model, HttpSession sess, HttpServletRequest req, HttpServletResponse response, 
			@RequestParam(value="job_id") String job_id, 
	        @RequestParam(value="employee_id") String employee_id) 
	{	
		
		JobStatusService js_service = new JobStatusService();
		Message m = js_service.assignJob(employee_id, job_id);
		
		JsonObject json = new JsonObject();
		json.addProperty("job_id", job_id);
		json.addProperty("employee_id", employee_id);
		
		if(m.type == "danger")
		{
			json.addProperty("success", 0);
		}
		else
		{
			json.addProperty("success", 1);
		}
		
        
        try {
			response.getWriter().print(json.toString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/console/employer/landing", method = {RequestMethod.GET, RequestMethod.POST})
	public String loadLandingPage(@ModelAttribute("ObjForm") @Validated EmployerJobCreateModel obj_form,
			BindingResult result, final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req) {	
		
		
		model.addAttribute("home_url", "/console/employer/landing");
		buildBreadCrumb();
		model.addAttribute("breadcrumb", breadcrumb);
		
		SessionModel session_user = (SessionModel)sess.getAttribute("logged_in_user");		
		model.addAttribute("logged_in_user", session_user);
		
		model.addAttribute("list_position", getListOfPositions());
		
		model.addAttribute("new_applicant_count", service.getApplicantCount());
		
		model.addAttribute("job_completion_alert_count", service.getJobCompletionAlertCount());
		
		if(RequestUtility.isGet(req))
		{
			EmployerJobCreateModel obj = new EmployerJobCreateModel();
			obj.setQuantity(1);
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			Date date = new Date();
			String sDate= sdf.format(date);
			
			obj.setJob_date(sDate);
			model.addAttribute("ObjForm", obj);
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "employer/landing";
			}
			else
			{		
				Message m = service.publishJob(obj_form, sess);				
				
				if(m.type == "success")
				{	
					model.addAttribute("message", m.text);
					return "employer/general_message";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					return "employer/landing";
				}
			}
		}
		
		return "employer/landing";
	}
	
	
	
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/console/employer/choose_applicants/{id}", method = RequestMethod.GET)
	public String loadChooseApplicants(Locale locale, Model model, HttpSession sess, @PathVariable String id) {
		model.addAttribute("home_url", "/console/employer/landing");
		buildBreadCrumb();
		
		breadcrumb.replace(0, new String[]{"/console/employer/landing", "", getSessionName()});
		breadcrumb.put(1, new String[]{"#", "active", " Choose Applicants"});
		
		model.addAttribute("breadcrumb", breadcrumb);
		PropertyUtilsBean p = new PropertyUtilsBean();
		
		JobService job_s = new JobService();	
		TblJob job = job_s.getById(id);
		TblJobEx job_ex = new TblJobEx();
		try {
			p.copyProperties(job_ex, job);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		job_ex.setDate_string(HUtil.formatDate(job_ex.getJobDate()));
		model.addAttribute("job", job_ex);
		
		JobStatusService job_status_s = new JobStatusService();
		
		TblJobStatusEx tmp;
		
		HashSet<TblJobStatusEx> m_list = new HashSet<TblJobStatusEx>();
		
		Set<TblJobStatus> s = job_status_s.getByJobAndStatus(Integer.parseInt(id), "0,1");
		Iterator it = s.iterator();
		//System.out.println("===="+s.size());
		while(it.hasNext())
		{
			tmp = new TblJobStatusEx();
			try {
				p.copyProperties(tmp, (TblJobStatus)it.next());
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			tmp.setCount_x(service.getWorkedForYourCompanyCount(tmp.getTblJob().getTblEmployer().getId(), tmp.getTblEmployee().getId()));
			m_list.add(tmp);
		}
		
		model.addAttribute("candidate_list", m_list);
		
		return "employer/choose_applicants";
		
		
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/console/employer/choose_applicants/joblist", method = RequestMethod.GET)
	public String loadAppliedJobList(Locale locale, Model model, HttpSession sess) {
		model.addAttribute("home_url", "/console/employer/landing");
		buildBreadCrumb();
		
		breadcrumb.replace(0, new String[]{"/console/employer/landing", "", getSessionName()});
		breadcrumb.put(1, new String[]{"#", "active", " Choose Applicants"});
		
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("jobs", service.getAppliedJobs());
		
		return "employer/choose_applicants/joblist";
		
		
	}
	
}
