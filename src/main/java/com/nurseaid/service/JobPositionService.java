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
import com.nurseaid.model.TblJobPosition;
import com.nurseaid.model.extended.TblAdminEx;
import com.nurseaid.protocol.Message;


public class JobPositionService implements CRUDManager{
	
	@Override
	public Message create(Object obj, HttpSession sess) {
		DAO<TblJobPosition> dao = new DAO<TblJobPosition>();
		try
		{
			TblJobPosition o = (TblJobPosition)obj;
			
			//System.out.println("======"+sess.getAttribute("user_id"));
			
			DAO<TblAdmin> dao_user = new DAO<TblAdmin>();
			TblAdmin dbo_user = dao_user.findById(Integer.parseInt((String)sess.getAttribute("user_id")), TblAdmin.class);
			
			o.setTblAdmin(dbo_user);
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_JOB_POSITION_NEW);
			
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
		DAO<TblJobPosition> dao = new DAO<TblJobPosition>();
		try
		{
			TblJobPosition tmp = (TblJobPosition)obj;
			
			TblJobPosition o = this.getById(String.valueOf(tmp.getId()));
			o.setTitle(tmp.getTitle());
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_JOB_POSITION_UPDATE);
			
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
		DAO<TblJobPosition> dao = new DAO<TblJobPosition>();
		try
		{
			dao.delete(dao.findById(Integer.parseInt(id), TblJobPosition.class));
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_JOB_POSITION_DELETE);
			
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
	public TblJobPosition getById(String id) {
		DAO<TblJobPosition> dao = new DAO<TblJobPosition>();
		return dao.findById(Integer.parseInt(id), TblJobPosition.class);
	}

	@Override
	public Set<TblJobPosition> getAll() {
		DAO<TblJobPosition> dao = new DAO<TblJobPosition>();
		return dao.getAll(TblJobPosition.class);
	}
	
	
}
