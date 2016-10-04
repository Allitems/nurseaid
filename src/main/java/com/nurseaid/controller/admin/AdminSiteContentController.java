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
public class AdminSiteContentController extends AdminBaseController{
	
	HashMap<Integer, String[]> breadcrumb;
	CMSService service = new CMSService();
	TblCmsValidator v = new TblCmsValidator();
	
	
	public AdminSiteContentController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"#", "", getSessionName()});
		breadcrumb.put(1, new String[]{"/admin/site", "", "Site"});
		breadcrumb.put(2, new String[]{"#", "active", " Content Management"});
	}
	
		
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/content", method = RequestMethod.GET)
	public String siteContentList(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		model.addAttribute("breadcrumb", breadcrumb);
		model.addAttribute("list", service.getAll());
		return "admin/site/content";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/content/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String addContent(@ModelAttribute("TblCmsForm") @Validated TblCms obj_form,
			BindingResult result, final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req) {
		
		
		buildBreadCrumb();
		breadcrumb.replace(2, new String[]{"/admin/site/content", "", " Content Management"});
		breadcrumb.put(3, new String[]{"#", "active", " Add/Edit"});
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("btn_text", "Add");
		
		if(RequestUtility.isGet(req))
		{
			
			TblCms obj = new TblCms();
			model.addAttribute("TblCmsForm", obj);
			return "admin/site/content/add";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("TblCmsForm", obj_form);
				return "admin/site/content/add";
			}
			else
			{				
				Message m = service.create(obj_form, sess);
				
				
				if(m.type == "success")
				{	
					ra.addFlashAttribute("css", m.type);
					ra.addFlashAttribute("msg", m.text);
					return "redirect:/admin/site/content";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					return "admin/site/content/add";
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
	@RequestMapping(value = "/admin/site/content/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String editContent(@ModelAttribute("TblCmsForm") @Validated TblCms obj_form,
			BindingResult result, final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req, @PathVariable String id) {
		
		
		buildBreadCrumb();
		breadcrumb.replace(2, new String[]{"/admin/site/content", "", " Content Management"});
		breadcrumb.put(3, new String[]{"#", "active", " Add/Edit"});
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("btn_text", "Update");
		
		
		if(RequestUtility.isGet(req))
		{
			TblCms obj = new TblCms();
			obj = service.getById(id);
			model.addAttribute("TblCmsForm", obj);
			return "admin/site/content/add";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("TblCmsForm", obj_form);
				return "admin/site/content/add";
			}
			else
			{	
				Message m = service.update(obj_form);
				if(m.type == "success")
				{
					ra.addFlashAttribute("css", m.type);
					ra.addFlashAttribute("msg", m.text);
					
					return "redirect:/admin/site/content";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					
					return "admin/site/content/add";
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
	@RequestMapping(value = "/admin/site/content/delete/{id}", method = {RequestMethod.GET})
	public String deleteContent(final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req, @PathVariable String id) {
		
		if(RequestUtility.isGet(req))
		{
			Message m = service.delete(id);
			ra.addFlashAttribute("css", m.type);
			ra.addFlashAttribute("msg", m.text);
			
			return "redirect:/admin/site/content";
		}
		
		return "error";
		
	}
}
