package com.nurseaid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.nurseaid.core.CRUDManager;
import com.nurseaid.core.DAO;
import com.nurseaid.core.HUtil;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblEmployee;
import com.nurseaid.model.TblEmployer;
import com.nurseaid.model.TblEntityAbstract;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.model.extended.EmployeeRegistrationModel;
import com.nurseaid.model.extended.EmployerRegistrationModel;
import com.nurseaid.protocol.Message;


public class EmployeeService implements CRUDManager{
	
	DAO<TblEmployee> dao = new DAO<TblEmployee>();
	
	
	public Message register(Object obj)
	{
		try
		{
			EmployeeRegistrationModel o = (EmployeeRegistrationModel)obj;
			
			DAO<TblEntityAbstract> dao_entity = new DAO<TblEntityAbstract>();
			TblEntityAbstract dbo_entity = new TblEntityAbstract();
			
			
			dbo_entity.setUsername(o.getUsername());
			dbo_entity.setPassword(o.getPassword());
			dbo_entity.setAddress1(o.getAddress());
			dbo_entity.setStatus((byte)0);
			dbo_entity.setEntityCode("EE-"+HUtil.randomString(6));
			
			dbo_entity = dao_entity.insertOrUpdate((TblEntityAbstract)dbo_entity);
			
			TblEmployee dbo_employee = new TblEmployee();
			dbo_employee.setFirstName(o.getFirst_name());
			dbo_employee.setLastName(o.getLast_name());
			dbo_employee.setMobile(o.getMobile());
			dbo_employee.setEmail(o.getEmail());
			dbo_employee.setTblEntityAbstract(dbo_entity);
			
			
			DAO<TblEmployee> dao_employee = new DAO<TblEmployee>();	
			dao_employee.insertOrUpdate((TblEmployee)dbo_employee);
			
			Message m = new Message();
			m.prepareMessage(MessageCode.INFO_FRONT_USER_REGISTRATION_SUCCESSFUL);
			
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
	public Message create(Object obj, HttpSession sess) {
		
		return null;
		/*
		try
		{
			TblCms o = (TblCms)obj;
			
			DAO<TblAdmin> dao_user = new DAO<TblAdmin>();
			TblAdmin dbo_user = dao_user.findById((Integer)sess.getAttribute("user_id"), TblAdmin.class);
			
			
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
		*/
	}

	@Override
	public Message update(Object obj) {
		return null;
		/*try
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
		}*/
	}

	@Override
	public Message delete(String id) {
		return null;
		/*try
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
		}*/
	}

	@Override
	public TblEmployee getById(String id) {
		return dao.findById(Integer.parseInt(id), TblEmployee.class);
	}

	@Override
	public Set<TblEmployee> getAll() {
		return dao.getAll(TblEmployee.class);
	}
	
	
	public Set<TblEmployee> searchEmployees(String s)
	{
		try
		{
			String hql = "FROM TblEmployee M where first_name like '%"+s+"%' "
					+"OR first_name like '%"+s+"%' "
					+ "OR M.tblEntityAbstract.entityCode like '%"+s+"%'";
			
			Set<TblEmployee> result = dao.excuteHQL(hql);
			
			return result;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}
}
