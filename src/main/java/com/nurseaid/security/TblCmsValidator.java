package com.nurseaid.security;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nurseaid.model.TblCms;

public class TblCmsValidator implements Validator
{

	@Override
	public boolean supports(Class<?> arg0) {
		return TblCms.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		TblCms obj = (TblCms) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", null, "Title is Required !!!");
		
	}

}
