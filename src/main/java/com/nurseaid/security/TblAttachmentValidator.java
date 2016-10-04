package com.nurseaid.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.extended.TblAdminEx;

public class TblAttachmentValidator implements Validator
{

	@Override
	public boolean supports(Class<?> arg0) {
		return TblAttachment.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		TblAttachment obj = (TblAttachment) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", null, "Title is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "detail", null, "Detail is Required.");
		
		
		
		if((obj.getForType()) == -1)
		{
			errors.rejectValue("forType", null, "This field is required.");
		}
		
	}

}
