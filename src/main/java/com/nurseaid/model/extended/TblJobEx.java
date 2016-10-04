package com.nurseaid.model.extended;

import com.nurseaid.model.TblEmployee;
import com.nurseaid.model.TblJob;
import com.nurseaid.model.TblJobStatus;

public class TblJobEx extends TblJob
{
	int count_x;
	String date_string;
	
	TblJobStatus allotted_to;

	String job_status_string;
	
	
	public String getJob_status_string() {
		return job_status_string;
	}

	public void setJob_status_string(String job_status_string) {
		this.job_status_string = job_status_string;
	}

	public TblJobStatus getAllotted_to() {
		return allotted_to;
	}

	public void setAllotted_to(TblJobStatus allotted_to) {
		this.allotted_to = allotted_to;
	}

	public String getDate_string() {
		return date_string;
	}

	public void setDate_string(String date_string) {
		this.date_string = date_string;
	}

	public int getCount_x() {
		return count_x;
	}

	public void setCount_x(int count_x) {
		this.count_x = count_x;
	}
	
}
