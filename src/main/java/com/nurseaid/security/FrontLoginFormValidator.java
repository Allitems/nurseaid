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
import com.nurseaid.model.extended.LoginFormModel;
import com.nurseaid.model.extended.TblAdminEx;

public class FrontLoginFormValidator implements Validator
{
	
	@Override
	public boolean supports(Class<?> arg0) {
		return LoginFormModel.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		LoginFormModel obj = (LoginFormModel) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", null, "Username is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", null, "Password is Required.");
		
		
	}

}
