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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblSettings;
import com.nurseaid.model.extended.SettingsModel;
import com.nurseaid.protocol.Message;
import com.nurseaid.protocol.RequestUtility;
import com.nurseaid.security.TblCmsValidator;
import com.nurseaid.security.TblSettingsValidator;
import com.nurseaid.service.CMSService;
import com.nurseaid.service.SettingsService;

import javax.servlet.ServletContext;
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
public class AdminSiteSettingsController extends AdminBaseController {
	
	HashMap<Integer, String[]> breadcrumb;
	SettingsService service = new SettingsService();
	TblSettingsValidator v = new TblSettingsValidator();
	
	
	public AdminSiteSettingsController(){
		
	}
	
	public void buildBreadCrumb()
	{
		breadcrumb = new HashMap();
		breadcrumb.put(0, new String[]{"#", "", getSessionName()});
		breadcrumb.put(1, new String[]{"/admin/site", "", "Site"});
		breadcrumb.put(2, new String[]{"#", "active", " Site Settings"});
	}
	
		
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/settings", method = RequestMethod.GET)
	public String siteSettingsList(Locale locale, Model model, HttpSession sess) {
		buildBreadCrumb();
		model.addAttribute("breadcrumb", breadcrumb);
		model.addAttribute("list", service.getAll());
		
		ServletContext ctx = sess.getServletContext();
		model.addAttribute("DIR_PATH", ctx.getContextPath() + SettingsService.DIR_PATH);
		
		//System.out.println(ctx.getContextPath() + SettingsService.DIR_PATH);
		
		return "admin/site/settings";
	}
	
	/**
	 * @param locale
	 * @param model - form data model
	 * @param sess
	 * @param req
	 * @return
	 */
	@RequestMapping(value = "/admin/site/settings/edit/{id}", method = {RequestMethod.GET, RequestMethod.POST})
	public String editSettings(@ModelAttribute("ObjForm") @Validated SettingsModel obj_form,
			BindingResult result, 
			final RedirectAttributes ra, Model model, HttpSession sess, HttpServletRequest req, @PathVariable String id) {
		
		
		buildBreadCrumb();
		breadcrumb.replace(2, new String[]{"/admin/site/settings", "", " Site Settings"});
		breadcrumb.put(3, new String[]{"#", "active", " Edit"});
		model.addAttribute("breadcrumb", breadcrumb);
		
		model.addAttribute("btn_text", "Update");
		
		
		if(RequestUtility.isGet(req))
		{
			TblSettings obj = new TblSettings();
			obj = service.getById(id);
			
			SettingsModel sm = new SettingsModel();
			sm.setId(obj.getId());
			sm.setTitle(obj.getTitle());
			sm.setType(obj.getType());
			sm.setValue(obj.getValue());
			
			model.addAttribute("ObjForm", sm);
			return "admin/site/settings/edit";
		}
		else 
		if(RequestUtility.isPost(req))
		{
			
			{	
				
				Message m = service.update(obj_form, sess);
				if(m.type == "success")
				{
					ra.addFlashAttribute("css", m.type);
					ra.addFlashAttribute("msg", m.text);
					
					return "redirect:/admin/site/settings";
				}
				else
				{
					model.addAttribute("css", m.type);
					model.addAttribute("msg", m.text);
					
					return "admin/site/settings/edit";
				}
				
			}		
			
		}		
		return "error";
		
	}
	
}
