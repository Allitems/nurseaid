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
import com.nurseaid.model.TblAttachment;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblMessage;
import com.nurseaid.model.TblSettings;
import com.nurseaid.model.extended.TblAdminEx;
import com.nurseaid.protocol.Message;


public class MessageService implements CRUDManager{
	
	DAO<TblMessage> dao = new DAO<TblMessage>();
	
	@Override
	public Message create(Object obj, HttpSession sess) {
		
		try
		{
			TblMessage o = (TblMessage)obj;
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_MESSAGE_NEW);
			
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
			TblMessage tmp = (TblMessage)obj;
			
			TblMessage o = this.getById(String.valueOf(tmp.getId()));
			o.setContent(tmp.getContent());
			o.setTitle(tmp.getTitle());
			o.setSubject(tmp.getSubject());
			o.setMessageType(tmp.getMessageType());
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_MESSAGE_UPDATE);
			
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
			dao.delete(dao.findById(Integer.parseInt(id), TblMessage.class));
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_MESSAGE_DELETE);
			
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
	public TblMessage getById(String id) {
		return dao.findById(Integer.parseInt(id), TblMessage.class);
	}

	@Override
	public Set<TblMessage> getAll() {
		return dao.getAll(TblMessage.class);
	}
	
	public TblMessage getByKey(String key) {
		
		String value = "";
		
		try
		{
			Set s = dao.excuteHQL("FROM TblMessage C WHERE title LIKE '%"+key+"%'");
			Iterator it = s.iterator();
			
			if(s.size() == 0)
			{
				return null;
			}
			else
			{
				TblMessage v = (TblMessage)it.next();
				return v;
			}
			
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
}
