package com.nurseaid.security;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nurseaid.core.HUtil;
import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblMessage;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.model.extended.EmployerJobCreateModel;
import com.nurseaid.model.extended.EmployerRegistrationModel;
import com.nurseaid.model.extended.TblAdminEx;

public class EmployerJobCreateFormValidator implements Validator
{
	
	
	@Override
	public boolean supports(Class<?> arg0) {
		return EmployerJobCreateModel.class.equals(arg0);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		EmployerJobCreateModel obj = (EmployerJobCreateModel) target;
		
		//ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantity", null, "Quantity is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shift_from", null, "Shift From is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "shift_to", null, "Shift To is Required.");		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "position", null, "Position is Required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "job_date", null, "Job Date is Required.");
		
		try
		{
			if(!HUtil.isNumeric(String.valueOf(obj.getQuantity())))
			{
				 errors.rejectValue("quantity", null, "Quantity should be a number.");
			}
			
			if(Integer.valueOf(obj.getQuantity()) == 0)
			{
				errors.rejectValue("quantity", null, "Quantity should be a non-zero value.");
			}
		}
		catch(Exception e)
		{
			errors.rejectValue("quantity", null, "Quantity should be a number.");
		}
		
		if((obj.getPosition()) == -1)
		{
			errors.rejectValue("position", null, "Job Position is required.");
		}
		
	}
	
	

}
