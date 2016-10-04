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
import com.nurseaid.model.extended.TblEmployeeEx;
import com.nurseaid.model.extended.TblEmployerEx;
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
public class AdminEmployerController extends AdminBaseController {
	
	HashMap<Integer, String[]> breadcrumb;
	EmployerService service = new EmployerService();
	
	public AdminEmployerController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"#", "", getSessionName()});
		breadcrumb.put(1, new String[]{"/admin/employer", "", "Employer"});
	}
		
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employer", method = RequestMethod.GET)
	public String employerDashboard(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		breadcrumb.replace(1, new String[]{"/admin/employer", "active", "Employer"});
		model.addAttribute("breadcrumb", breadcrumb);
		return "admin/employer/dashboard";
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employer/add", method = RequestMethod.GET)
	public String employerAdd(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		breadcrumb.replace(1, new String[]{"/admin/employee", "", "Employer"});
		breadcrumb.put(2, new String[]{"#", "active", " Add Employer"});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/employer/add";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employer/search", method = RequestMethod.POST)
	public String employerSearch(Locale locale, Model model, HttpSession sess, HttpServletRequest request) {
		buildBreadCrumb();
		breadcrumb.put(2, new String[]{"#", "active", "Search Results"});		
		model.addAttribute("breadcrumb", breadcrumb);
			
		
		Set<TblEmployer> s = service.searchEmployers(request.getParameter("q").trim());
		
		PropertyUtilsBean p = new PropertyUtilsBean();
		
		HashSet<TblEmployerEx> m_list = new HashSet<TblEmployerEx>();
		TblEmployerEx tmp;
		TblEmployer o;
		Iterator it = s.iterator();
		while(it.hasNext())
		{
			tmp = new TblEmployerEx();
			o = (TblEmployer)it.next();
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
		
		return "admin/employer/search";
	}
	
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/employer/edit/{id}", method = RequestMethod.GET)
	public String employerEdit(Locale locale, Model model, HttpSession sess, @PathVariable String id) {
		buildBreadCrumb();
		
		TblEmployer t = service.getById(id);
		
		breadcrumb.put(2, new String[]{"#", "active", t.getCompanyName()});		
		model.addAttribute("breadcrumb", breadcrumb);
		
		return "admin/employer/edit";
	}	
	
}
