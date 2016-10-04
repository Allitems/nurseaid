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
import com.nurseaid.model.extended.TblAdminEx;
import com.nurseaid.protocol.Message;


public class UserService implements CRUDManager{
	
	DAO<TblAdmin> dao = new DAO<TblAdmin>();
	
	@Override
	public Message create(Object obj, HttpSession sess) {
		
		try
		{
			TblAdminEx tmp = (TblAdminEx)obj;
			
			TblAdmin o = new TblAdmin(tmp.getFullName(), tmp.getUsername(), tmp.getPassword(), tmp.getEmail());
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_USER_NEW);
			
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
			TblAdminEx tmp = (TblAdminEx)obj;
			
			TblAdmin o = this.getById(String.valueOf(tmp.getId()));
			o.setEmail(tmp.getEmail());
			o.setUsername(tmp.getUsername());
			o.setFullName(tmp.getFullName());
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_USER_UPDATE);
			
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
			dao.delete(dao.findById(Integer.parseInt(id), TblAdmin.class));
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_USER_DELETE);
			
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
	public TblAdmin getById(String id) {
		return dao.findById(Integer.parseInt(id), TblAdmin.class);
	}

	@Override
	public Set<TblAdmin> getAll() {
		return dao.getAll(TblAdmin.class);
	}
	
	
}
