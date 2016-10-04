package com.nurseaid.model;
// Generated Sep 26, 2016 12:31:45 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * TblJob generated by hbm2java
 */
public class TblJob implements java.io.Serializable {

	private Integer id;
	private TblEmployer tblEmployer;
	private TblJobPosition tblJobPosition;
	private String referenceNumber;
	private int quantity;
	private String shiftFrom;
	private String shiftTo;
	private Date jobDate;
	private Set tblTimesheets = new HashSet(0);
	private Set tblJobStatuses = new HashSet(0);

	public TblJob() {
	}

	public TblJob(TblEmployer tblEmployer, TblJobPosition tblJobPosition, String referenceNumber, int quantity,
			String shiftFrom, String shiftTo, Date jobDate) {
		this.tblEmployer = tblEmployer;
		this.tblJobPosition = tblJobPosition;
		this.referenceNumber = referenceNumber;
		this.quantity = quantity;
		this.shiftFrom = shiftFrom;
		this.shiftTo = shiftTo;
		this.jobDate = jobDate;
	}

	public TblJob(TblEmployer tblEmployer, TblJobPosition tblJobPosition, String referenceNumber, int quantity,
			String shiftFrom, String shiftTo, Date jobDate, Set tblTimesheets, Set tblJobStatuses) {
		this.tblEmployer = tblEmployer;
		this.tblJobPosition = tblJobPosition;
		this.referenceNumber = referenceNumber;
		this.quantity = quantity;
		this.shiftFrom = shiftFrom;
		this.shiftTo = shiftTo;
		this.jobDate = jobDate;
		this.tblTimesheets = tblTimesheets;
		this.tblJobStatuses = tblJobStatuses;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TblEmployer getTblEmployer() {
		return this.tblEmployer;
	}

	public void setTblEmployer(TblEmployer tblEmployer) {
		this.tblEmployer = tblEmployer;
	}

	public TblJobPosition getTblJobPosition() {
		return this.tblJobPosition;
	}

	public void setTblJobPosition(TblJobPosition tblJobPosition) {
		this.tblJobPosition = tblJobPosition;
	}

	public String getReferenceNumber() {
		return this.referenceNumber;
	}

	public void setReferenceNumber(String referenceNumber) {
		this.referenceNumber = referenceNumber;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getShiftFrom() {
		return this.shiftFrom;
	}

	public void setShiftFrom(String shiftFrom) {
		this.shiftFrom = shiftFrom;
	}

	public String getShiftTo() {
		return this.shiftTo;
	}

	public void setShiftTo(String shiftTo) {
		this.shiftTo = shiftTo;
	}

	public Date getJobDate() {
		return this.jobDate;
	}

	public void setJobDate(Date jobDate) {
		this.jobDate = jobDate;
	}

	public Set getTblTimesheets() {
		return this.tblTimesheets;
	}

	public void setTblTimesheets(Set tblTimesheets) {
		this.tblTimesheets = tblTimesheets;
	}

	public Set getTblJobStatuses() {
		return this.tblJobStatuses;
	}

	public void setTblJobStatuses(Set tblJobStatuses) {
		this.tblJobStatuses = tblJobStatuses;
	}

}
