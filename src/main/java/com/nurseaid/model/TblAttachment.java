package com.nurseaid.model;
// Generated Sep 26, 2016 12:31:45 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * TblAttachment generated by hbm2java
 */
public class TblAttachment implements java.io.Serializable {

	private Integer id;
	private String title;
	private String detail;
	private boolean isRequired;
	private byte forType;
	private Set tblEntityAttachments = new HashSet(0);

	public TblAttachment() {
	}

	public TblAttachment(String title, String detail, boolean isRequired, byte forType) {
		this.title = title;
		this.detail = detail;
		this.isRequired = isRequired;
		this.forType = forType;
	}

	public TblAttachment(String title, String detail, boolean isRequired, byte forType, Set tblEntityAttachments) {
		this.title = title;
		this.detail = detail;
		this.isRequired = isRequired;
		this.forType = forType;
		this.tblEntityAttachments = tblEntityAttachments;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDetail() {
		return this.detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public boolean isIsRequired() {
		return this.isRequired;
	}

	public void setIsRequired(boolean isRequired) {
		this.isRequired = isRequired;
	}

	public byte getForType() {
		return this.forType;
	}

	public void setForType(byte forType) {
		this.forType = forType;
	}

	public Set getTblEntityAttachments() {
		return this.tblEntityAttachments;
	}

	public void setTblEntityAttachments(Set tblEntityAttachments) {
		this.tblEntityAttachments = tblEntityAttachments;
	}

}
