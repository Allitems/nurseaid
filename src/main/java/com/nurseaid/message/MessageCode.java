package com.nurseaid.message;

import java.util.HashMap;

public class MessageCode {
	
	public static String[] OPERATION_FAILED = new String[]{"danger", "Operation Failed !!!"};
	public static String[] OPERATION_SUCCESSFUL = new String[]{"success", "Operation Successful !!!"};
	
	public static String[] INFO_CMS_NEW = new String[]{"success", "Content Created !!!"};
	public static String[] INFO_CMS_UPDATE = new String[]{"success", "Content Updated !!!"};
	public static String[] INFO_CMS_DELETE = new String[]{"success", "Content Deleted !!!"};
	
	
	public static String[] INFO_USER_NEW = new String[]{"success", "Admin User Created !!!"};
	public static String[] INFO_USER_UPDATE = new String[]{"success", "Admin User Updated !!!"};
	public static String[] INFO_USER_DELETE = new String[]{"success", "Admin User Deleted !!!"};
	
	
	public static String[] INFO_DOCTYPE_NEW = new String[]{"success", "Document Type Created !!!"};
	public static String[] INFO_DOCTYPE_UPDATE = new String[]{"success", "Document Type Updated !!!"};
	public static String[] INFO_DOCTYPE_DELETE = new String[]{"success", "Document Type Deleted !!!"};
	
	public static String[] INFO_JOB_POSITION_NEW = new String[]{"success", "Job Position Created !!!"};
	public static String[] INFO_JOB_POSITION_UPDATE = new String[]{"success", "Job Position Updated !!!"};
	public static String[] INFO_JOB_POSITION_DELETE = new String[]{"success", "Job Position Deleted !!!"};
	
	public static String[] INFO_MESSAGE_NEW = new String[]{"success", "Notification Message Created !!!"};
	public static String[] INFO_MESSAGE_UPDATE = new String[]{"success", "Notification Message Updated !!!"};
	public static String[] INFO_MESSAGE_DELETE = new String[]{"success", "Notification Message Deleted !!!"};
	
	public static String[] INFO_COUNTRY_NEW = new String[]{"success", "Country Created !!!"};
	public static String[] INFO_COUNTRY_UPDATE = new String[]{"success", "Country Updated !!!"};
	public static String[] INFO_COUNTRY_DELETE = new String[]{"success", "Country Deleted !!!"};
	
	
	public static String[] INFO_SETTINGS_UPDATE = new String[]{"success", "Settings Updated !!!"};
	
	
	public static String[] JOB_PUBLISH_SUCCESS = new String[]{"success", "Job Published Successfully !!!"};
	
	
	public static String[] INFO_FRONT_CONTACT_MESSAGE_SENT = new String[]{"success", "Message Sent !!!"};
	public static String[] INFO_FRONT_CONTACT_MESSAGE_ERROR = new String[]{"success", "Error sending Message !!!"};
	
	public static String[] INFO_FRONT_USER_REGISTRATION_SUCCESSFUL = new String[]{"success", "Account has been created. Please wait till admin activates your account !!!"};
	
	
	
	public static String[] ERROR_USER_DOES_NOT_EXIST = new String[]{"danger", "This email does not exist in our System. Please re-check and try again. !!"};
	
	public static String[] ERROR_LOGIN = new String[]{"danger", "Error in Login. Try Again !!"};
	public static String[] SUCCESS_LOGIN_ADMIN = new String[]{"success", "admin"};
	public static String[] SUCCESS_LOGIN_EMPLOYER = new String[]{"success", "employer"};
	public static String[] SUCCESS_LOGIN_EMPLOYEE = new String[]{"success", "employee"};
	
	
	public static String[] SUCCESS_SEND_RESET_PASSWORD = new String[]{"success", "An email with password reset link has been sent. please check your mailbox."};
	
	public static String[] NO_INVOICES = new String[]{"system", "There are no more outstanding Timesheets which requires Approval and Invoicing"};
	
}
