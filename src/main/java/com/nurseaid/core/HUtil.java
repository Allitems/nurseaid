package com.nurseaid.core;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nurseaid.protocol.Message;
import com.nurseaid.service.SettingsService;

public class HUtil {
	private static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    
    public static String getFileExtension(String name) {
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }
    }
    
    
    public static Message sendEmail(String to, String from, String from_name, String subject, String content)
    {
    	Message m = new Message();
    	
    	SettingsService settings_service = new SettingsService();
		String SMTP_SERVER = settings_service.getByKey("SMTP_SERVER");
		String SMTP_PORT = settings_service.getByKey("SMTP_PORT");	
		
		Properties props = new Properties();
		props.put("mail.smtp.host", SMTP_SERVER);
		props.put("mail.smtp.auth", "false");
		props.put("mail.smtp.port", SMTP_PORT);
		
		Session session = Session.getDefaultInstance(props);
		
		javax.mail.Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(from, from_name));
			message.setRecipients(javax.mail.Message.RecipientType.TO, InternetAddress.parse(to));
			message.setSubject(subject);
			
			message.setContent(content, "text/html; charset=utf-8");
			Transport.send(message);
		} catch (Exception e) {
			m.type = "danger";
			m.text = e.getMessage();
			return m;
		}		
		
    	m.type = "success";
    	m.text = "dummy";
    	return m;
    }
    
    
    public static String getBaseURL()
    {
    	ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpServletRequest request = attr.getRequest();	    
	    
    	String url = request.getRequestURL().toString();
	    String uri = request.getRequestURI();
	    String root = url.substring( 0, url.indexOf(uri) );
	    
	    if(root.indexOf("localhost") != -1)
	    {
	    	root = root + "/nurseaid";
	    }
	    return root;
    }
    
    public static boolean isNumeric(String str)
	{
	  return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal.
	}
    
    public static String randomString(int length) 
    {
    	String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        Random r = new Random(); // perhaps make it a class variable so you don't make a new one every time
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < length; i++) {
        	sb.append(chars.charAt(r.nextInt(chars.length())));
        }
        return sb.toString();
    }
    
    
    public static String formatDate(Date in_date)
    {
    	SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		return sdf.format(in_date);
    }
    
    
    public static Map getListOfJobStatus()
	{
		Map<String,String> lv = new LinkedHashMap<String,String>();
		lv.put("-1", "--- Select Job Status ---");
		lv.put("15", "Available");
		lv.put("0", "Applied");
		lv.put("2", "Confirmed");
		lv.put("4", "Completed");
		lv.put("5", "Invoiced");
		return lv;		
	}
    
}
