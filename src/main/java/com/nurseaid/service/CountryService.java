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
import com.nurseaid.model.TblCountry;
import com.nurseaid.model.TblMessage;
import com.nurseaid.model.extended.TblAdminEx;
import com.nurseaid.protocol.Message;


public class CountryService implements CRUDManager{
	
	DAO<TblCountry> dao = new DAO<TblCountry>();
	
	@Override
	public Message create(Object obj, HttpSession sess) {
		
		try
		{
			TblCountry o = (TblCountry)obj;
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_COUNTRY_NEW);
			
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
			TblCountry tmp = (TblCountry)obj;
			
			TblCountry o = this.getById(String.valueOf(tmp.getId()));
			o.setNationality(tmp.getNationality());
			o.setTitle(tmp.getTitle());
			
			dao.insertOrUpdate(o);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_COUNTRY_UPDATE);
			
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
			dao.delete(dao.findById(Integer.parseInt(id), TblCountry.class));
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_COUNTRY_DELETE);
			
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
	public TblCountry getById(String id) {
		return dao.findById(Integer.parseInt(id), TblCountry.class);
	}

	@Override
	public Set<TblCountry> getAll() {
		return dao.getAll(TblCountry.class);
	}
	
	
}
