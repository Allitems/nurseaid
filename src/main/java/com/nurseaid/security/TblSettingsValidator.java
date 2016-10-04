package com.nurseaid.security;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblSettings;
import com.nurseaid.model.extended.SettingsModel;

public class TblSettingsValidator implements Validator
{

	@Override
	public boolean supports(Class<?> arg0) {
		return SettingsModel.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		SettingsModel obj = (SettingsModel) target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", null, "Title is Required !!!");
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "value", null, "Value is Required !!!");
		
	}

}
