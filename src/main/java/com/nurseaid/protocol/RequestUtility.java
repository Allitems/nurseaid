package com.nurseaid.protocol;

import javax.servlet.http.HttpServletRequest;

public class RequestUtility {

	public static boolean isGet(HttpServletRequest request)
	{
		return ("GET".equalsIgnoreCase(request.getMethod()));
	}
	
	public static boolean isPost(HttpServletRequest request)
	{
		return ("POST".equalsIgnoreCase(request.getMethod()));
	}
	
}
