package com.nurseaid.model.extended;

import com.nurseaid.model.TblEmployee;

public class TblEmployeeEx extends TblEmployee 
{
	private String date_string;
	
	public String getDate_string() {
		return date_string;
	}

	public void setDate_string(String date_string) {
		this.date_string = date_string;
	}	
	
}
