package com.nurseaid.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import com.nurseaid.core.CRUDManager;
import com.nurseaid.core.DAO;
import com.nurseaid.core.HUtil;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblSettings;
import com.nurseaid.model.extended.SettingsModel;
import com.nurseaid.protocol.Message;

public class SettingsService implements CRUDManager{
	
	DAO<TblSettings> dao = new DAO<TblSettings>();	
	
	public static String DIR_PATH = "/site_files/";

	
	public Message update(Object obj, HttpSession session) {
		try
		{
			SettingsModel s = (SettingsModel)obj;
			
			TblSettings tmp = this.getById(String.valueOf(s.getId()));
			MultipartFile file = s.getFile();
			
			
			if(file == null)
			{
				tmp.setValue(s.getValue());
			}
			else
			{
				
				
				ServletContext ctx = session.getServletContext();
				
				String path = ctx.getRealPath(DIR_PATH + tmp.getValue());
				
				
				System.out.println("--UPLOADING--"+path);
				
				File original = new File(path);
				original.delete();
				
				String ext = HUtil.getFileExtension(file.getOriginalFilename());
				String filename = tmp.getId()+ "_" + String.valueOf(Calendar.getInstance().get(Calendar.MILLISECOND)) +"."+ext; 
				path = ctx.getRealPath(DIR_PATH + filename);
				
				File destination = new File(path);	
				
				file.transferTo(destination);
				
				tmp.setValue(filename);
			}			
			
			dao.insertOrUpdate(tmp);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_SETTINGS_UPDATE);
			
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
	public TblSettings getById(String id) {
		return dao.findById(Integer.parseInt(id), TblSettings.class);
	}

	@Override
	public Set<TblSettings> getAll() {
		return dao.getAll(TblSettings.class);
	}

	@Override
	public Message create(Object obj, HttpSession sess) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message delete(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	public String getByKey(String key) {
		
		String value = "";
		
		try
		{
			Set s = dao.excuteHQL("FROM TblSettings C WHERE title LIKE '%"+key+"%'");
			Iterator it = s.iterator();
			
			if(s.size() == 0)
			{
				return "NO_VALUE_FOR_KEY";
			}
			else
			{
				TblSettings v = (TblSettings)it.next();
				value = v.getValue();
			}
			
		}
		catch(Exception e)
		{
			value = e.getMessage();
		}
		
		return value;
	}

	@Override
	public Message update(Object obj) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
