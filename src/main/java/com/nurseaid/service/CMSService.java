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
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.protocol.Message;


public class CMSService implements CRUDManager{
	
	DAO<TblCms> dao = new DAO<TblCms>();
	
	@Override
	public Message create(Object obj, HttpSession sess) {
		
		try
		{
			TblCms o = (TblCms)obj;
			
			DAO<TblAdmin> dao_user = new DAO<TblAdmin>();
			TblAdmin dbo_user = dao_user.findById(Integer.parseInt((String)sess.getAttribute("user_id")), TblAdmin.class);
			
			
			o.setTblAdmin(dbo_user);
			o.setLastModifiedOn(new Date());		
			
			dao.insertOrUpdate((TblCms)obj);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_CMS_NEW);
			
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
			TblCms o = (TblCms)obj;
			TblCms tmp = this.getById(String.valueOf(o.getId()));
			
			tmp.setTitle(o.getTitle());
			tmp.setContent(o.getContent());
			
			dao.insertOrUpdate(tmp);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_CMS_UPDATE);
			
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
			dao.delete(dao.findById(Integer.parseInt(id), TblCms.class));
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_CMS_DELETE);
			
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
	public TblCms getById(String id) {
		return dao.findById(Integer.parseInt(id), TblCms.class);
	}

	@Override
	public Set<TblCms> getAll() {
		return dao.getAll(TblCms.class);
	}
	
	
	/**** frontoffice functions *****/
	
	public Message sendMessage(Object obj)
	{
		try
		{
			ContactFormModel o = (ContactFormModel)obj;
			
			
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_FRONT_CONTACT_MESSAGE_SENT);
			
			return m;
		}
		catch(Exception ex)
		{
			Message m = new Message();
			m.prepareMessage(new String[]{"danger", ex.toString()});
			
			return m;
		}
	}
	
	
}
