package com.nurseaid.model.extended;

import org.springframework.web.multipart.MultipartFile;

import com.nurseaid.model.TblSettings;

public class SettingsModel extends TblSettings
{

	MultipartFile file;
	//getter and setter methods

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}
	

}