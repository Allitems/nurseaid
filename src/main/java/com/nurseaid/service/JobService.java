package com.nurseaid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.nurseaid.core.CRUDManager;
import com.nurseaid.core.DAO;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblJob;
import com.nurseaid.model.TblJobStatus;
import com.nurseaid.model.TblSettings;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.protocol.Message;


public class JobService implements CRUDManager{
	
	DAO<TblJob> dao = new DAO<TblJob>();
	
	public Set<TblJob> getByEmployerId(int employer_id) {
		
		try
		{
			Set s = dao.excuteHQL("FROM TblJob C WHERE tbl_employer_id = '"+employer_id+"'");
			return s;
			
		}
		catch(Exception e)
		{
			return null;
		}
	} 
	
	@Override
	public Message create(Object obj, HttpSession sess) {		
		return null;
	}

	@Override
	public Message update(Object obj) {
		return null;
	}

	@Override
	public Message delete(String id) {
		return null;
	}

	@Override
	public TblJob getById(String id) {
		return dao.findById(Integer.parseInt(id), TblJob.class);
	}

	@Override
	public Set<TblJob> getAll() {
		return dao.getAll(TblJob.class);
	}
		
}
