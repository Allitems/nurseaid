package com.nurseaid.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.extended.TblAdminEx;

public class TblAdminValidator implements Validator
{

	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	 
	@Override
	public boolean supports(Class<?> arg0) {
		return TblAdminEx.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		TblAdminEx obj = (TblAdminEx) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "fullName", null, "Full Name is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, "Username is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Password is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "Email is Required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "c_password", null, "Confirm Password is Required.");
		
		if(!obj.getPassword().isEmpty())
		{
		    if (obj.getPassword().length() < 6) {
		        errors.rejectValue("password", null, "Password must be at least 6 characters.");
		    }
		}
		
		if(!obj.getUsername().isEmpty())
		{
		    if (obj.getUsername().length() < 6) {
		        errors.rejectValue("username", null, "Username must be at least 6 characters.");
		    }
		}
		
		if(!obj.getPassword().isEmpty() && !obj.getC_password().isEmpty())
		{
		    if (!obj.getPassword().trim().equals(obj.getC_password().trim())) 
		    {
		        errors.rejectValue("c_password", null, "Password and Confirm Password do not match.");
		    }
		}
		
	    if(!obj.getEmail().isEmpty())
	    {
		    pattern = Pattern.compile(EMAIL_PATTERN);
		    matcher = pattern.matcher(obj.getEmail());
		    if (!matcher.matches()) 
		    {
		    	errors.rejectValue("email", null, "Invalid Email.");
		    }
	    }
		
	}

}
