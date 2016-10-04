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

import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.extended.TblAdminEx;
import com.nurseaid.protocol.Message;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.security.TblAdminValidator;
import com.nurseaid.security.TblCmsValidator;
import com.nurseaid.service.CMSService;
import com.nurseaid.service.UserService;

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
public class AdminSiteUserController extends AdminBaseController{
	
	HashMap<Integer, String[]> breadcrumb;
	UserService service = new UserService();
	TblAdminValidator v = new TblAdminValidator();
	
	
	public AdminSiteUserController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"#", "", getSessionName()});
		breadcrumb.put(1, new String[]{"/admin/site", "", "Site"});
		breadcrumb.put(2, new String[]{"#", "active", " User Management"});
	}
	
		
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/user", method = RequestMethod.GET)
	public String getAdminList(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		model.addAttribute("breadcrumb", breadcrumb);
		model.addAttribute("list", service.getAll());
		return "admin/site/user";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/user/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String addUser(@ModelAttribute("ObjForm") @Validated TblAdminEx obj_form,
			BindingResult result, final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req) {
		
		
		buildBreadCrumb();
		breadcrumb.replace(2, new String[]{"/admin/site/user", "", " User Management"});
		breadcrumb.put(3, new String[]{"#", "active", " Add/Edit User"});
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("btn_text", "Add");
		
		if(RequestUtility.isGet(req))
		{
			
			TblAdminEx obj = new TblAdminEx();
			model.addAttribute("ObjForm", obj);
			return "admin/site/user/add";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "admin/site/user/add";
			}
			else
			{				
				Message m = service.create(obj_form, sess);
				
				
				if(m.type == "success")
				{	
					ra.addFlashAttribute("css", m.type);
					ra.addFlashAttribute("msg", m.text);
					return "redirect:/admin/site/user";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					return "admin/site/user/add";
				}
				
			}		
			
		}		
		return "error";
		
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/user/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String editUser(@ModelAttribute("ObjForm") @Validated TblAdminEx obj_form,
			BindingResult result, final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req, @PathVariable String id) {
		
		
		buildBreadCrumb();
		breadcrumb.replace(2, new String[]{"/admin/site/user", "", " User Management"});
		breadcrumb.put(3, new String[]{"#", "active", " Add/Edit User"});
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("btn_text", "Update");
		
		
		if(RequestUtility.isGet(req))
		{
			TblAdmin obj = new TblAdmin();
			obj = (TblAdmin)service.getById(id);
			model.addAttribute("ObjForm", obj);
			return "admin/site/user/add";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			obj_form.setPassword("DO_NOT_CHANGE");
			obj_form.setC_password("DO_NOT_CHANGE");
			
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "admin/site/user/add";
			}
			else
			{	
				Message m = service.update(obj_form);
				if(m.type == "success")
				{
					ra.addFlashAttribute("css", m.type);
					ra.addFlashAttribute("msg", m.text);
					
					return "redirect:/admin/site/user";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					
					return "admin/site/user/add";
				}
				
			}		
			
		}		
		return "error";
		
	}
	
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/user/delete/{id}", method = {RequestMethod.GET})
	public String deleteUser(final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req, @PathVariable String id) {
		
		if(RequestUtility.isGet(req))
		{
			Message m = service.delete(id);
			ra.addFlashAttribute("css", m.type);
			ra.addFlashAttribute("msg", m.text);
			
			return "redirect:/admin/site/user";
		}
		
		return "error";
		
	}
}
