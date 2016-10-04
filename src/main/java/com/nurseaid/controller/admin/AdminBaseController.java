package com.nurseaid.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nurseaid.model.extended.SessionModel;

public class AdminBaseController {

	public String getSessionName()
	{
	    ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession(true);
	    
	    SessionModel session_user = (SessionModel)session.getAttribute("logged_in_user");
	    
	    if(session_user.getRole() == "admin")
	    {
	    	return "Admin ("+session_user.getFull_name()+")";
	    }
	    else
	    {
	    	return "?????";
	    }
	    
	    
	}
	
}
