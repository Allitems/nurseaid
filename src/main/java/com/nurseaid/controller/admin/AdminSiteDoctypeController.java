package com.nurseaid.controller.admin;

import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
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
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.extended.TblAdminEx;
import com.nurseaid.protocol.Message;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.security.TblAdminValidator;
import com.nurseaid.security.TblAttachmentValidator;
import com.nurseaid.security.TblCmsValidator;
import com.nurseaid.service.CMSService;
import com.nurseaid.service.DoctypeService;
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
public class AdminSiteDoctypeController extends AdminBaseController {
	
	HashMap<Integer, String[]> breadcrumb;
	DoctypeService service = new DoctypeService();
	TblAttachmentValidator v = new TblAttachmentValidator();
	
	
	public AdminSiteDoctypeController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"#", "", getSessionName()});
		breadcrumb.put(1, new String[]{"/admin/site", "", "Site"});
		breadcrumb.put(2, new String[]{"#", "active", " Document Types"});
	}
	
		
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/doctype", method = RequestMethod.GET)
	public String getAdminList(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		model.addAttribute("breadcrumb", breadcrumb);
		model.addAttribute("list", service.getAll());
		return "admin/site/doctype";
	}
	
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/doctype/add", method = {RequestMethod.GET, RequestMethod.POST})
	public String addUser(@ModelAttribute("ObjForm") @Validated TblAttachment obj_form,
			BindingResult result, final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req) {
		
		
		buildBreadCrumb();
		breadcrumb.replace(2, new String[]{"/admin/site/doctype", "", " Document Types"});
		breadcrumb.put(3, new String[]{"#", "active", " Add/Edit"});
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("document_for", getDocumentFor());
		
		model.addAttribute("btn_text", "Add");
		
		if(RequestUtility.isGet(req))
		{
			
			TblAttachment obj = new TblAttachment();
			model.addAttribute("ObjForm", obj);
			return "admin/site/doctype/add";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "admin/site/doctype/add";
			}
			else
			{				
				Message m = service.create(obj_form, sess);				
				
				if(m.type == "success")
				{	
					ra.addFlashAttribute("css", m.type);
					ra.addFlashAttribute("msg", m.text);
					return "redirect:/admin/site/doctype";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					return "admin/site/doctype/add";
				}
				
			}		
			
		}		
		return "error";
		
	}
	
	public Map getDocumentFor()
	{
		
		Map<String,String> lv = new LinkedHashMap<String,String>();
		lv.put("-1", "Select Entity");
		lv.put("1", "Employee");
		lv.put("2", "Employer");
		return lv;
		
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/doctype/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String editUser(@ModelAttribute("ObjForm") @Validated TblAttachment obj_form,
			BindingResult result, final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req, @PathVariable String id) {
		
		
		buildBreadCrumb();
		breadcrumb.replace(2, new String[]{"/admin/site/doctype", "", " Document Types"});
		breadcrumb.put(3, new String[]{"#", "active", " Add/Edit"});
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("btn_text", "Update");
		
		model.addAttribute("document_for", getDocumentFor());
		
		if(RequestUtility.isGet(req))
		{
			TblAttachment obj = new TblAttachment();
			obj = (TblAttachment)service.getById(id);
			model.addAttribute("ObjForm", obj);
			return "admin/site/doctype/add";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			v.validate(obj_form, result);
			if(result.hasErrors())
			{
				model.addAttribute("ObjForm", obj_form);
				return "admin/site/doctype/add";
			}
			else
			{	
				Message m = service.update(obj_form);
				if(m.type == "success")
				{
					ra.addFlashAttribute("css", m.type);
					ra.addFlashAttribute("msg", m.text);
					
					return "redirect:/admin/site/doctype";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					
					return "admin/site/doctype/add";
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
	@RequestMapping(value = "/admin/site/doctype/delete/{id}", method = {RequestMethod.GET})
	public String deleteUser(final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req, @PathVariable String id) {
		
		if(RequestUtility.isGet(req))
		{
			Message m = service.delete(id);
			ra.addFlashAttribute("css", m.type);
			ra.addFlashAttribute("msg", m.text);
			
			return "redirect:/admin/site/doctype";
		}
		
		return "error";
		
	}
}