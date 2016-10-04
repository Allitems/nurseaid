package com.nurseaid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.nurseaid.core.CRUDManager;
import com.nurseaid.core.DAO;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.extended.TblAdminEx;
import com.nurseaid.protocol.Message;


public class DoctypeService implements CRUDManager{
	
	DAO<TblAttachment> dao = new DAO<TblAttachment>();
	
	@Override
	public Message create(Object obj, HttpSession sess) {
		
		try
		{
			TblAttachment o = (TblAttachment)obj;
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_DOCTYPE_NEW);
			
			return m;
		}
		catch(Exception ex)
		{
			Message m = new Message();
			m.prepareMessage(new String[]{"danger", ex.toString()});
			
			return m;
		}
	}

	@Override
	public Message update(Object obj) {
		try
		{
			TblAttachment tmp = (TblAttachment)obj;
			
			TblAttachment o = this.getById(String.valueOf(tmp.getId()));
			o.setDetail(tmp.getDetail());
			o.setTitle(tmp.getTitle());
			o.setForType(tmp.getForType());
			o.setIsRequired(tmp.isIsRequired());
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_DOCTYPE_UPDATE);
			
			return m;
		}
		catch(Exception ex)
		{
			Message m = new Message();
			m.prepareMessage(new String[]{"danger", ex.toString()});
			
			return m;
		}
	}

	@Override
	public Message delete(String id) {
		try
		{
			dao.delete(dao.findById(Integer.parseInt(id), TblAttachment.class));
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_DOCTYPE_DELETE);
			
			return m;
		}
		catch(Exception ex)
		{
			Message m = new Message();
			m.prepareMessage(new String[]{"danger", ex.getMessage()});
			
			return m;
		}
	}

	@Override
	public TblAttachment getById(String id) {
		return dao.findById(Integer.parseInt(id), TblAttachment.class);
	}

	@Override
	public Set<TblAttachment> getAll() {
		return dao.getAll(TblAttachment.class);
	}
	
	
}
