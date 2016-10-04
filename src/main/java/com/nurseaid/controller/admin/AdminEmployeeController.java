package com.nurseaid.controller.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.nurseaid.core.HUtil;
import com.nurseaid.model.TblEmployee;
import com.nurseaid.model.TblEmployer;
import com.nurseaid.model.TblJobStatus;
import com.nurseaid.model.extended.EmployeeRegistrationModel;
import com.nurseaid.model.extended.TblEmployeeEx;
import com.nurseaid.model.extended.TblJobStatusEx;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.service.EmployeeService;
import com.nurseaid.service.EmployerService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("session_data")
public class AdminEmployeeController extends AdminBaseController {
	
	HashMap<Integer, String[]> breadcrumb;
	EmployeeService service = new EmployeeService();
	
	public AdminEmployeeController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"#", "", getSessionName()});
		breadcrumb.put(1, new String[]{"/admin/employee", "", "Employee"});
	}
		
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employee", method = RequestMethod.GET)
	public String employeeDashboard(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		breadcrumb.replace(1, new String[]{"/admin/employee", "active", "Employee"});
		model.addAttribute("breadcrumb", breadcrumb);
		return "admin/employee/dashboard";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employee/alljobs", method = {RequestMethod.GET, RequestMethod.POST})
	public String employeeAllJobs(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		breadcrumb.put(2, new String[]{"#", "active", "All Jobs"});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/employee/alljobs";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employee/timesheetsummary", method = RequestMethod.GET)
	public String employeeTimesheetSummary(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		breadcrumb.put(2, new String[]{"#", "active", "Timesheet Summary"});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/employee/timesheetsummary";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employee/alert", method = RequestMethod.GET)
	public String employeeAlert(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		breadcrumb.put(2, new String[]{"#", "active", "Alerts"});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/employee/alert";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employee/stafftimesheet", method = RequestMethod.GET)
	public String employeeStaffTimesheet(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		breadcrumb.put(2, new String[]{"#", "active", "Staff Timesheet"});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/employee/stafftimesheet";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employee/search", method = RequestMethod.POST)
	public String employeeSearch(Locale locale, Model model, HttpSession sess, HttpServletRequest request) {
		buildBreadCrumb();
		breadcrumb.put(2, new String[]{"#", "active", "Search Results"});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		Set<TblEmployee> s = service.searchEmployees(request.getParameter("q").trim());
		
		PropertyUtilsBean p = new PropertyUtilsBean();
		
		HashSet<TblEmployeeEx> m_list = new HashSet<TblEmployeeEx>();
		TblEmployeeEx tmp;
		TblEmployee o;
		Iterator it = s.iterator();
		while(it.hasNext())
		{
			tmp = new TblEmployeeEx();
			o = (TblEmployee)it.next();
			try {
				p.copyProperties(tmp, o);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			tmp.setDate_string(HUtil.formatDate(o.getTblEntityAbstract().getCreatedDate()));
			m_list.add(tmp);
		}
				
		model.addAttribute("q", request.getParameter("q").trim());
		
		model.addAttribute("list", m_list);
		
		return "admin/employee/search";
	}
	
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employee/edit/{id}", method = RequestMethod.GET)
	public String employeeEdit(Locale locale, Model model, HttpSession sess, @PathVariable String id) {
		buildBreadCrumb();
		
		TblEmployee t = service.getById(id);
		
		breadcrumb.put(2, new String[]{"#", "active", t.getFirstName()+" "+t.getLastName()});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/employee/edit";
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employee/add", method = RequestMethod.GET)
	public String employeeAdd(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		breadcrumb.put(2, new String[]{"#", "active", " Add Employee"});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/employee/add";
	}
}
