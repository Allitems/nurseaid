package com.nurseaid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nurseaid.core.CRUDManager;
import com.nurseaid.core.DAO;
import com.nurseaid.core.HUtil;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblEmployee;
import com.nurseaid.model.TblEmployer;
import com.nurseaid.model.TblEntityAbstract;
import com.nurseaid.model.TblMessage;
import com.nurseaid.model.TblPasswordResetRequest;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.model.extended.EmployeeRegistrationModel;
import com.nurseaid.model.extended.EmployerRegistrationModel;
import com.nurseaid.model.extended.ForgotPasswordFormModel;
import com.nurseaid.model.extended.LoginFormModel;
import com.nurseaid.model.extended.SessionModel;
import com.nurseaid.protocol.Message;
import javax.mail.internet.MimeMessage;

public class AuthService{
	
	Object user_obj;
	
	public Message checkEmail(String email)
	{
		user_obj = null;
		
		boolean login_admin = false;
		boolean login_employer = false;
		boolean login_employee = false;
		
		Message m = new Message();
		
		try
		{
			DAO<TblAdmin> dao_ = new DAO<TblAdmin>();
			Set s = dao_.excuteHQL("from TblAdmin WHERE email = '"+email+"'");
			if(s.size() > 0)
			{
				login_admin = true;
				
				Iterator it = s.iterator();
				this.user_obj = (TblAdmin)it.next();			
				
				m.prepareMessage(MessageCode.SUCCESS_LOGIN_ADMIN);
				return m;
			}
			
			
			DAO<TblEmployee> dao_employee = new DAO<TblEmployee>();
			s = dao_employee.excuteHQL("from TblEmployee WHERE email = '"+email+"'");
			if(s.size() > 0)
			{
				login_employee = true;
				
				Iterator it = s.iterator();
				this.user_obj = (TblEmployee)it.next();			
				
				m.prepareMessage(MessageCode.SUCCESS_LOGIN_EMPLOYEE);
				return m;
			}
			
			
			DAO<TblEmployer> dao_employer = new DAO<TblEmployer>();
			s = dao_employer.excuteHQL("from TblEmployer WHERE email = '"+email+"'");
			if(s.size() > 0)
			{
				login_employer = true;
				
				Iterator it = s.iterator();
				this.user_obj = (TblEmployer)it.next();			
				
				m.prepareMessage(MessageCode.SUCCESS_LOGIN_EMPLOYER);
				return m;
			}
		}
		catch(Exception ex)
		{
			//ex.printStackTrace();
			m.prepareMessage(new String[]{"danger", ex.toString()});			
			return m;
		}
		
		if(!login_admin && !login_employer && !login_employee)
		{
			m.prepareMessage(MessageCode.ERROR_USER_DOES_NOT_EXIST);				
		}
		
		return m;
	}
		
	public Message sendResetPasswordEmail(Object obj)
	{
		ForgotPasswordFormModel model = (ForgotPasswordFormModel)obj;
		
		String CUSTOMER_NAME = "SAMPLE_CUSTOMER_NAME";
		String CUSTOMER_EMAIL = "nuru.freelancer@gmail.com";	// default email	
		
	    String key = UUID.randomUUID().toString();
	    String PASSWORD_RESET_LINK = HUtil.getBaseURL() + "/reset_password/" + key;	    
		
	    
		Message m = checkEmail(model.getEmail());
		
		TblPasswordResetRequest req = new TblPasswordResetRequest();
		req.setIdKey(key);		
		
		if(m.type == "danger")
		{
			return m;
		}
		else
		{
			if(user_obj.getClass() == TblAdmin.class)
			{
				TblAdmin o = (TblAdmin)user_obj;
				CUSTOMER_NAME = o.getFullName();
				CUSTOMER_EMAIL = o.getEmail();
				
				req.setUserType("admin");
				req.setUserId(o.getId());
				
			}
			else
				if(user_obj.getClass() == TblEmployee.class)
				{
					TblEmployee o = (TblEmployee)user_obj;
					CUSTOMER_NAME = o.getFirstName()+" "+o.getLastName();
					CUSTOMER_EMAIL = o.getEmail();
					
					req.setUserType("employee");
					req.setUserId(o.getId());
				}
				else
					if(user_obj.getClass() == TblEmployer.class)
					{
						TblEmployer o = (TblEmployer)user_obj;
						CUSTOMER_NAME = o.getCompanyName();
						CUSTOMER_EMAIL = o.getEmail();
						
						req.setUserType("employer");
						req.setUserId(o.getId());
					}
		}
		
		PasswordResetService pwd_s = new PasswordResetService();
		pwd_s.create(req);
		
		
		SettingsService settings_service = new SettingsService();				
		String SITE_EMAIL = settings_service.getByKey("SITE_EMAIL");
		String SITE_TITLE = settings_service.getByKey("SITE_TITLE");
		
		MessageService message_service = new MessageService();
		TblMessage email = message_service.getByKey("FORGOT_PASSWORD_EMAIL");
					
		String email_body = email.getContent();
		email_body = email_body.replace("{CUSTOMER_NAME}", CUSTOMER_NAME);
		email_body = email_body.replace("{PASSWORD_RESET_LINK}", PASSWORD_RESET_LINK);
		email_body = email_body.replace("{SITE_TITLE}", SITE_TITLE);		
		
		
		m = HUtil.sendEmail(CUSTOMER_EMAIL, SITE_EMAIL, SITE_TITLE, email.getSubject(), email_body);			
		if(m.type == "success")
		{
			m.prepareMessage(MessageCode.SUCCESS_SEND_RESET_PASSWORD);
		}
		
		return m;		
	
	}
	
	public Message login(Object obj, HttpSession session)
	{
		try
		{
			boolean login_admin = false;
			boolean login_employer = false;
			boolean login_employee = false;
			
			Message m = new Message();
			
			LoginFormModel o = (LoginFormModel)obj;
			
			//DAO<TblEntityAbstract> dao_entity = new DAO<TblEntityAbstract>();
			//TblEntityAbstract dbo_entity = new TblEntityAbstract();
			
			DAO<TblAdmin> dao_ = new DAO<TblAdmin>();
			Set s = dao_.excuteHQL("from TblAdmin WHERE username = '"+o.getUsername()+"' AND password = '"+o.getPassword()+"'");			
			
			if(s.size() > 0)
			{
				login_admin = true;
				
				Iterator it = s.iterator();
				TblAdmin _user = (TblAdmin)it.next();
				
				SessionModel sm = new SessionModel();
				sm.setFull_name(_user.getFullName());
				sm.setUser_id(String.valueOf(_user.getId()));
				sm.setUsername(_user.getUsername());
				sm.setRole("admin");
				
				session.setAttribute("logged_in_user", sm);
				
				m.prepareMessage(MessageCode.SUCCESS_LOGIN_ADMIN);
				return m;
			}
			
			
			DAO<TblEntityAbstract> dao_entity = new DAO<TblEntityAbstract>();
			Set s_entity = dao_entity.excuteHQL("from TblEntityAbstract WHERE username = '"+o.getUsername()+"' AND password = '"+o.getPassword()+"'");			
			
			if(s_entity.size() > 0)
			{
				
				Iterator it = s_entity.iterator();
				TblEntityAbstract _entity = (TblEntityAbstract)it.next();
				
				Set employees = _entity.getTblEmployees();
				if(employees.size() > 0)
				{
					login_employee = true;
					
					it = employees.iterator();
					TblEmployee _employee = (TblEmployee)it.next();
					
					SessionModel sm = new SessionModel();
					sm.setFull_name(_employee.getFirstName()+" "+_employee.getLastName());
					sm.setUser_id(String.valueOf(_employee.getId()));
					sm.setUsername(_entity.getUsername());
					sm.setRole("employee");
					
					session.setAttribute("logged_in_user", sm);
					
					m.prepareMessage(MessageCode.SUCCESS_LOGIN_EMPLOYEE);
					return m;
				}
				
				Set employers = _entity.getTblEmployers();
				if(employers.size() > 0)
				{
					login_employer = true;
					
					it = employers.iterator();
					TblEmployer _employer = (TblEmployer)it.next();
					
					//System.out.println("xxxxxxx "+_employer.getCompanyName());
					
					SessionModel sm = new SessionModel();
					sm.setFull_name(_employer.getCompanyName());
					sm.setUser_id(String.valueOf(_employer.getId()));
					sm.setUsername(_entity.getUsername());
					sm.setRole("employer");
					
					session.setAttribute("logged_in_user", sm);
					
					m.prepareMessage(MessageCode.SUCCESS_LOGIN_EMPLOYER);
					return m;
				}
				
			}
			
			
			if(!login_admin && !login_employer && !login_employee)
			{
				m.prepareMessage(MessageCode.ERROR_LOGIN);				
			}
			
			return m;
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Message m = new Message();
			m.prepareMessage(new String[]{"danger", ex.toString()});
			
			return m;
		}
	}	
}
