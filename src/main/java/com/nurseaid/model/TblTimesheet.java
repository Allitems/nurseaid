package com.nurseaid.model;
// Generated Sep 26, 2016 12:31:45 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;

/**
 * TblTimesheet generated by hbm2java
 */
public class TblTimesheet implements java.io.Serializable {

	private int id;
	private TblJob tblJob;
	private Date acceptedDate;
	private Date startTime;
	private Date endTime;
	private Float duration;
	private Float break_;
	private Float ph150;
	private Float ot15;
	private Float ot2;
	private Float c50PerSat;
	private Float c75PerSun;

	public TblTimesheet() {
	}

	public TblTimesheet(int id, TblJob tblJob) {
		this.id = id;
		this.tblJob = tblJob;
	}

	public TblTimesheet(int id, TblJob tblJob, Date acceptedDate, Date startTime, Date endTime, Float duration,
			Float break_, Float ph150, Float ot15, Float ot2, Float c50PerSat, Float c75PerSun) {
		this.id = id;
		this.tblJob = tblJob;
		this.acceptedDate = acceptedDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.duration = duration;
		this.break_ = break_;
		this.ph150 = ph150;
		this.ot15 = ot15;
		this.ot2 = ot2;
		this.c50PerSat = c50PerSat;
		this.c75PerSun = c75PerSun;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public TblJob getTblJob() {
		return this.tblJob;
	}

	public void setTblJob(TblJob tblJob) {
		this.tblJob = tblJob;
	}

	public Date getAcceptedDate() {
		return this.acceptedDate;
	}

	public void setAcceptedDate(Date acceptedDate) {
		this.acceptedDate = acceptedDate;
	}

	public Date getStartTime() {
		return this.startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return this.endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Float getDuration() {
		return this.duration;
	}

	public void setDuration(Float duration) {
		this.duration = duration;
	}

	public Float getBreak_() {
		return this.break_;
	}

	public void setBreak_(Float break_) {
		this.break_ = break_;
	}

	public Float getPh150() {
		return this.ph150;
	}

	public void setPh150(Float ph150) {
		this.ph150 = ph150;
	}

	public Float getOt15() {
		return this.ot15;
	}

	public void setOt15(Float ot15) {
		this.ot15 = ot15;
	}

	public Float getOt2() {
		return this.ot2;
	}

	public void setOt2(Float ot2) {
		this.ot2 = ot2;
	}

	public Float getC50PerSat() {
		return this.c50PerSat;
	}

	public void setC50PerSat(Float c50PerSat) {
		this.c50PerSat = c50PerSat;
	}

	public Float getC75PerSun() {
		return this.c75PerSun;
	}

	public void setC75PerSun(Float c75PerSun) {
		this.c75PerSun = c75PerSun;
	}

}
