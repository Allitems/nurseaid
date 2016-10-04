package com.nurseaid.model;
// Generated Sep 26, 2016 12:31:45 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TblJobPosition generated by hbm2java
 */
public class TblJobPosition implements java.io.Serializable {

	private Integer id;
	private TblAdmin tblAdmin;
	private String title;
	private Set tblJobs = new HashSet(0);

	public TblJobPosition() {
	}

	public TblJobPosition(TblAdmin tblAdmin, String title) {
		this.tblAdmin = tblAdmin;
		this.title = title;
	}

	public TblJobPosition(TblAdmin tblAdmin, String title, Set tblJobs) {
		this.tblAdmin = tblAdmin;
		this.title = title;
		this.tblJobs = tblJobs;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TblAdmin getTblAdmin() {
		return this.tblAdmin;
	}

	public void setTblAdmin(TblAdmin tblAdmin) {
		this.tblAdmin = tblAdmin;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set getTblJobs() {
		return this.tblJobs;
	}

	public void setTblJobs(Set tblJobs) {
		this.tblJobs = tblJobs;
	}

}
