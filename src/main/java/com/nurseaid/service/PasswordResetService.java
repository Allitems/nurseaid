package com.nurseaid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.nurseaid.core.CRUDManager;
import com.nurseaid.core.DAO;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblPasswordResetRequest;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.protocol.Message;


public class PasswordResetService implements CRUDManager{
	
	DAO<TblPasswordResetRequest> dao = new DAO<TblPasswordResetRequest>();
	
	public Message create(Object obj) 
	{
		
		try
		{
			TblPasswordResetRequest o = (TblPasswordResetRequest)obj;
			
			dao.insertOrUpdate((TblPasswordResetRequest)obj);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_CMS_NEW);
			
			return m;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			Message m = new Message();
			m.prepareMessage(new String[]{"danger", ex.toString()});
			
			return m;
		}
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
	public TblCms getById(String id) {
		return null;
	}

	@Override
	public Set<TblCms> getAll() {
		return null;
	}

	@Override
	public Message create(Object obj, HttpSession sess) {
		// TODO Auto-generated method stub
		return null;
	}
		
}
