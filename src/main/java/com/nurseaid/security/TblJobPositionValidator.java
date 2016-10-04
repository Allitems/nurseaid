package com.nurseaid.security;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblJobPosition;

public class TblJobPositionValidator implements Validator
{

	@Override
	public boolean supports(Class<?> arg0) {
		return TblJobPosition.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		TblJobPosition obj = (TblJobPosition) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", null, "Title is Required !!!");
		
	}

}
