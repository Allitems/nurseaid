package com.nurseaid.model.extended;

import java.util.Date;

public class EmployerJobCreateModel {

	int quantity;
	int position;
	String shift_from;
	String shift_to;
	String job_date;
	
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	public String getShift_from() {
		return shift_from;
	}
	public void setShift_from(String shift_from) {
		this.shift_from = shift_from;
	}
	public String getShift_to() {
		return shift_to;
	}
	public void setShift_to(String shift_to) {
		this.shift_to = shift_to;
	}
	public String getJob_date() {
		return job_date;
	}
	public void setJob_date(String job_date) {
		this.job_date = job_date;
	}
	
	
	
}
