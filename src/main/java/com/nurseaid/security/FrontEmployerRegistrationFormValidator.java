package com.nurseaid.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblMessage;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.model.extended.EmployerRegistrationModel;
import com.nurseaid.model.extended.TblAdminEx;

public class FrontEmployerRegistrationFormValidator implements Validator
{
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean supports(Class<?> arg0) {
		return EmployerRegistrationModel.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		EmployerRegistrationModel obj = (EmployerRegistrationModel) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company_name", null, "Company Name is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contact_person", null, "Contact Person Name is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "billing_email", null, "Billing Email is Required.");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "company_phone", null, "Phone Number is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, "Username is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Password is Required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", null, "Address is Required.");
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "c_password", null, "Confirm Password is Required.");
		
		
		if(!obj.getBilling_email().isEmpty())
	    {
		    pattern = Pattern.compile(EMAIL_PATTERN);
		    matcher = pattern.matcher(obj.getBilling_email());
		    if (!matcher.matches()) 
		    {
		    	errors.rejectValue("billing_email", null, "Invalid Email.");
		    }
	    }
		
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
	}

}
