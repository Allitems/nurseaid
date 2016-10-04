package com.nurseaid.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.nurseaid.model.extended.SessionModel;

public class SessionInterceptor extends HandlerInterceptorAdapter
{
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler)
		    throws Exception 
	{
		
			HttpSession session = request.getSession();		
			
			
			/***********TO REMOVE LATER START*********/
//			SessionModel sm = new SessionModel();
//			sm.setFull_name("TEST NURSING HOME");
//			sm.setUsername("jindalee");
//			sm.setRole("employer");
//			sm.setUser_id("5");
			
			
			
//			SessionModel sm = new SessionModel();
//			sm.setFull_name("Employee Shrestha");
//			sm.setUsername("employee");
//			sm.setRole("employee");
//			sm.setUser_id("1");
//			
			
			
//			SessionModel sm = new SessionModel();
//			sm.setFull_name("Admin Shrestha");
//			sm.setUsername("a");
//			sm.setRole("admin");
//			sm.setUser_id("124");		
//			
//			session.setAttribute("logged_in_user", sm);
			/***********TO REMOVE LATER END*********/
			
			
			SessionModel session_user = (SessionModel)session.getAttribute("logged_in_user");
			
			if(session_user == null)
			{
				response.sendRedirect(request.getContextPath() + "/login");
			}
			else
			{
				session.setAttribute("user_id", session_user.getUser_id());
			}
			
			return true;
	}
}
