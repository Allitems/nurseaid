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
import com.nurseaid.model.extended.TblAdminEx;

public class FrontContactFormValidator implements Validator
{
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
	   + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public boolean supports(Class<?> arg0) {
		return ContactFormModel.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		ContactFormModel obj = (ContactFormModel) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "full_name", null, "Full Name is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", null, "Email is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "message", null, "Message is Required.");		
		
		
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
