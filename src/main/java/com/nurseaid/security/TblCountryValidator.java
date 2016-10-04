package com.nurseaid.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblCountry;
import com.nurseaid.model.TblMessage;
import com.nurseaid.model.extended.TblAdminEx;

public class TblCountryValidator implements Validator
{

	@Override
	public boolean supports(Class<?> arg0) {
		return TblCountry.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		TblCountry obj = (TblCountry) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", null, "Title is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nationality", null, "Nationality is Required.");
		
		
	}

}
