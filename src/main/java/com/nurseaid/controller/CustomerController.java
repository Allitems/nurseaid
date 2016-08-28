package com.nurseaid.controller;

import java.util.ArrayList;
import java.util.Locale;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nurseaid.model.User;
import com.nurseaid.service.CustomerService;


/**
 * Handles requests for the application home page.
 */
@Controller
@SessionAttributes("session_data")
public class CustomerController {
	
	private CustomerService c_service;
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/customer/list", method = RequestMethod.GET)
	public String listAction(Locale locale, Model model, HttpSession sess) {
		
		c_service = new CustomerService();
		
		User u = c_service.createCustomer("Nimesh");
		c_service.addCustomerToList(u);
		
		u = c_service.createCustomer("Ram");
		c_service.addCustomerToList(u);
		
		u = c_service.createCustomer("Krishna");
		c_service.addCustomerToList(u);
		
		
		model.addAttribute("fx", "CustomerController : listAction()");
		
		User v = (User)sess.getAttribute("session_data");
		String uname = "";
		if(v != null){
			uname = v.getUserName();
		}
		
		model.addAttribute("fx", "List Customers " + uname);
		
		
		model.addAttribute("data_list", c_service.getAllCustomers() );
		return "customer/list";
	}
}
