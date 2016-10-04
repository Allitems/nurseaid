package com.nurseaid.service;

import java.lang.reflect.InvocationTargetException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.PropertyUtilsBean;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nurseaid.core.CRUDManager;
import com.nurseaid.core.DAO;
import com.nurseaid.core.HUtil;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblEmployer;
import com.nurseaid.model.TblEntityAbstract;
import com.nurseaid.model.TblJob;
import com.nurseaid.model.TblJobPosition;
import com.nurseaid.model.TblJobStatus;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.model.extended.EmployerJobCreateModel;
import com.nurseaid.model.extended.EmployerRegistrationModel;
import com.nurseaid.model.extended.TblJobEx;
import com.nurseaid.protocol.Message;


public class EmployerService implements CRUDManager{
	
	
	
	
	public Message register(Object obj)
	{
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		try
		{
			EmployerRegistrationModel o = (EmployerRegistrationModel)obj;
			
			DAO<TblEntityAbstract> dao_entity = new DAO<TblEntityAbstract>();
			TblEntityAbstract dbo_entity = new TblEntityAbstract();
			
			
			dbo_entity.setUsername(o.getUsername());
			dbo_entity.setPassword(o.getPassword());
			dbo_entity.setAddress1(o.getAddress());
			dbo_entity.setStatus((byte)0);
			dbo_entity.setEntityCode("ER-"+HUtil.randomString(6));
			
			dbo_entity = dao_entity.insertOrUpdate((TblEntityAbstract)dbo_entity);
			
			TblEmployer dbo_employer = new TblEmployer();
			dbo_employer.setCompanyName(o.getCompany_name());
			dbo_employer.setCompanyNumber(o.getCompany_phone());
			dbo_employer.setContactPerson(o.getContact_person());
			dbo_employer.setEmail(o.getBilling_email());
			dbo_employer.setTblEntityAbstract(dbo_entity);
			dbo_employer.setGeocodedLatitude("");
			dbo_employer.setGeocodedLongitude("");
			
			
			DAO<TblEmployer> dao_employer = new DAO<TblEmployer>();	
			dao_employer.insertOrUpdate((TblEmployer)dbo_employer);
			
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
	
	public Message publishJob(Object obj, HttpSession sess) {
		try
		{
			String staff_list = "";
			EmployerJobCreateModel tmp = (EmployerJobCreateModel)obj;
			
			DAO<TblEmployer> dao_employer = new DAO<TblEmployer>();
			TblEmployer dbo_employer = dao_employer.findById(Integer.parseInt((String)sess.getAttribute("user_id")), TblEmployer.class);
			
			DAO<TblJobPosition> dao_job_position = new DAO<TblJobPosition>();
			TblJobPosition dbo_job_position = dao_job_position.findById(tmp.getPosition(), TblJobPosition.class);
			
			Calendar calendar = Calendar.getInstance();
			calendar.setTime(new Date());
			
			TblJob o = new TblJob();
			o.setTblEmployer(dbo_employer);
			o.setTblJobPosition(dbo_job_position);
			
			String ref_number = "JB-"+HUtil.randomString(6);
			
			
			//o.setQuantity(tmp.getQuantity());
			o.setShiftFrom(tmp.getShift_from());
			o.setShiftTo(tmp.getShift_to());
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
			o.setJobDate(sdf.parse(tmp.getJob_date()));
			
			
			DAO<TblJob> dao = new DAO<TblJob>();
			List<TblJob> m_list = new ArrayList();
			
			PropertyUtilsBean p = new PropertyUtilsBean();
			
			if(tmp.getQuantity() > 1)
			{
				for(int mj = 0 ; mj < tmp.getQuantity() ; mj++)
				{
					TblJob tmp_job = new TblJob();
					try {
						p.copyProperties(tmp_job, o);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					tmp_job.setReferenceNumber(ref_number+String.valueOf(mj + 1));
					tmp_job.setQuantity(1);
					
					//dao = new DAO<TblJob>();
					//dao.insertOrUpdate((TblJob)o);
					//System.out.println("adding to list..."+tmp_job.getReferenceNumber());
					m_list.add(tmp_job);
					
					staff_list += "<br/>1 "+dbo_job_position.getTitle()+" Ref No. : "+tmp_job.getReferenceNumber();
				}
			}
			else
			{
				o.setReferenceNumber(ref_number);
				o.setQuantity(tmp.getQuantity());
				m_list.add(o);
				
				staff_list += "<br/>1 "+dbo_job_position.getTitle()+" Ref No. : "+ref_number;
			}
			
			dao.insertOrUpdateList(m_list);
			
			Message m = new Message();
			String message_string = "Your request has been sent to all our users on your city."
					+"<br/>"
					+staff_list
					+"<br/><br/>Total staff requested : " + tmp.getQuantity();
			m.prepareMessage(new String[]{"success", message_string});
			
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
	
	
	public int getApplicantCount()
	{
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		int c = 0;
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession(true);
	    
	    int employer_id = Integer.parseInt((String)session.getAttribute("user_id"));
	    
	    JobService js = new JobService();
	    Set<TblJob> jobs = js.getByEmployerId(employer_id);
	    
	    if(jobs != null)
	    {
		    Iterator it = jobs.iterator();
		    
		    while(it.hasNext())
		    {
		    	TblJob job = (TblJob)it.next();
		    	
		    	JobStatusService j_service = new JobStatusService();
		    	Set<TblJobStatus> applied_job_status_set = j_service.getByJobAndStatus(job.getId(), "0");
		    	
		    	c = c + applied_job_status_set.size();
		    }
	    }
		return c;
	}
	
	
	public int getJobCompletionAlertCount()
	{
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		int c = 0;
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession(true);
	    
	    int employer_id = Integer.parseInt((String)session.getAttribute("user_id"));
	    
	    JobService js = new JobService();
	    Set<TblJob> jobs = js.getByEmployerId(employer_id);
	    
	    Iterator it = jobs.iterator();
	    
	    while(it.hasNext())
	    {
	    	TblJob job = (TblJob)it.next();
	    	
	    	JobStatusService j_service = new JobStatusService();
	    	Set<TblJobStatus> applied_job_status_set = j_service.getByJobAndStatus(job.getId(), "4");
	    	if(applied_job_status_set != null)
	    	{
	    		c = c + applied_job_status_set.size();
	    	}
	    }
		
		return c;
	}
	
	
	
	
	public Set<TblJobStatus> getCompletedJobs()
	{
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		HashSet<TblJobStatus> m_list = new HashSet<TblJobStatus>();		
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession(true);
	    
	    int employer_id = Integer.parseInt((String)session.getAttribute("user_id"));
	    
	    JobService js = new JobService();
	    Set<TblJob> jobs = js.getByEmployerId(employer_id);
	    
	    Iterator it = jobs.iterator();
	    
	    while(it.hasNext())
	    {
	    	TblJob job = (TblJob)it.next();
	    	
	    	JobStatusService j_service = new JobStatusService();
	    	Set<TblJobStatus> applied_job_status_set = j_service.getByJobAndStatus(job.getId(), "4");
	    	
	    	if(applied_job_status_set.size() > 0)
	    	{
	    		Iterator<TblJobStatus> it_jobs = applied_job_status_set.iterator();
	    		TblJobStatus j_status = (TblJobStatus)it_jobs.next();
	    		m_list.add(j_status);
	    	}
	    	
	    }
		
		return m_list;
	}
	
	
	public Set<TblJobEx> getAppliedJobs()
	{
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		HashSet<TblJobEx> m_list = new HashSet<TblJobEx>();
		
		TblJobEx tmp = new TblJobEx();
		PropertyUtilsBean p = new PropertyUtilsBean();
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession(true);
	    
	    int employer_id = Integer.parseInt((String)session.getAttribute("user_id"));
	    
	    JobService js = new JobService();
	    Set<TblJob> jobs = js.getByEmployerId(employer_id);
	    
	    try
	    {
		    Iterator it = jobs.iterator();
		    
		    while(it.hasNext())
		    {
		    	TblJob job = (TblJob)it.next();
		    	
		    	JobStatusService j_service = new JobStatusService();
		    	Set<TblJobStatus> applied_job_status_set = j_service.getByJobAndStatus(job.getId(), "0");
		    	
		    	if(applied_job_status_set.size() > 0)
		    	{
		    		Iterator<TblJobStatus> it_jobs = applied_job_status_set.iterator();
		    		TblJobStatus j_status = (TblJobStatus)it_jobs.next();
		    		
		    		tmp = new TblJobEx();
	
		    		try {
						p.copyProperties(tmp, j_status.getTblJob());
					} catch (Exception e) {
						e.printStackTrace();
					}
		    		tmp.setCount_x(applied_job_status_set.size());
		    		
		    		//System.out.println("adding job..."+tmp.getTblJobPosition().getTitle());
		    		
		    		m_list.add(tmp);
		    	}
		    	
		    }
	    }
	    catch(Exception ex)
	    {
	    	ex.printStackTrace();
	    }
		return m_list;
	}
	
	
	
	@Override
	public Message create(Object obj, HttpSession sess) {
		
		return null;
		/*try
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
		}*/
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
	public TblEmployer getById(String id) {
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		return dao.findById(Integer.parseInt(id), TblEmployer.class);
	}

	@Override
	public Set<TblEmployer> getAll() {
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		return dao.getAll(TblEmployer.class);
	}
	
	public int getWorkedForYourCompanyCount(int employer_id, int employee_id)
	{
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		try
		{
			String sql = "select m.* from tbl_job_status m inner join "
					+ "tbl_job a ON m.tbl_job_id = a.id "
					+ "where tbl_employee_id = "+employee_id+" AND a.tbl_employer_id = "+employer_id+" "
					+ "AND (m.job_status = 4 OR m.job_status = 5)";
			
			Set s = dao.excuteSQL(sql, TblJobStatus.class);
			
			return s.size();
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return -1;
		}
		
	}
	
	
	public Set<TblEmployer> searchEmployers(String s)
	{
		DAO<TblEmployer> dao = new DAO<TblEmployer>();
		try
		{
			String hql = "FROM TblEmployer M where company_name like '%"+s+"%' "
					+ "OR M.tblEntityAbstract.entityCode like '%"+s+"%'";
			
			Set<TblEmployer> result = dao.excuteHQL(hql);
			
			return result;
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			return null;
		}
		
	}
}
