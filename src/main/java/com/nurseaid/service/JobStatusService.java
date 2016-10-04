package com.nurseaid.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.nurseaid.core.CRUDManager;
import com.nurseaid.core.DAO;
import com.nurseaid.message.MessageCode;
import com.nurseaid.model.TblAdmin;
import com.nurseaid.model.TblCms;
import com.nurseaid.model.TblEmployee;
import com.nurseaid.model.TblJob;
import com.nurseaid.model.TblJobStatus;
import com.nurseaid.model.TblSettings;
import com.nurseaid.model.extended.ContactFormModel;
import com.nurseaid.model.extended.EmployerReportAllJobsTimesheetModel;
import com.nurseaid.protocol.Message;


public class JobStatusService implements CRUDManager{
	
	
	
	public TblJobStatus getAllottedStatus(int job_id)
	{
		DAO<TblJobStatus> dao = new DAO<TblJobStatus>();
		try
    	{
	    	Set<TblJobStatus> result = dao.excuteHQL("FROM TblJobStatus WHERE "
	    			+ "tbl_job_id = '"+job_id+"' AND (job_status != '9')");
			
	    	if(result.size() > 0)
	    	{
	    		Iterator<TblJobStatus> it_jobs = result.iterator();
	    		while(it_jobs.hasNext())
	    		{
	    			TblJobStatus j_status = (TblJobStatus)it_jobs.next();
		    		return j_status;
	    		}
	    	}
    	}
    	catch(Exception ex)
    	{
    		ex.printStackTrace();
    		return null;
    	}
		return null;
	}
	
	public Set<TblJob> filterJobs(Object obj_form)
	{
		EmployerReportAllJobsTimesheetModel f = (EmployerReportAllJobsTimesheetModel)obj_form;
		
		HashSet<TblJob> m_list = new HashSet<TblJob>();
		
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
	    HttpSession session = attr.getRequest().getSession(true);
	    
	    int employer_id = Integer.parseInt((String)session.getAttribute("user_id"));
	    
	    DAO<TblJob> dao_job = new DAO<TblJob>();
	    Set<TblJob> result;
	    TblJob j_status;
	    
	    String and_clause = " 1 = 1 ";
	    
	    if(Integer.parseInt(f.getJob_status().trim()) != -1)
	    {
	    	if(Integer.parseInt(f.getJob_status().trim()) == 15)
	    	{
	    		//f.setJob_status("-1");
	    	}
	    	else
	    	{
	    		and_clause += " AND A.jobStatus = '"+f.getJob_status()+"'  ";
	    	}
	    }
	    
	    String name_filter = "";
	    if(!f.getStaff_name().isEmpty())
	    {
	    	name_filter = f.getStaff_name().trim();
	    	//and_clause += " AND A.tblEmployee.firstName LIKE '%"+f.getStaff_name()+"%'  ";
	    }
	    
	    if(!f.getJob_ref().isEmpty())
	    {
	    	and_clause += " AND M.referenceNumber LIKE '%"+f.getJob_ref().trim()+"%'  ";
	    }
	    
	    
	    
	    if(!f.getPoint_date().isEmpty())
	    {
	    	
	    	String arx[] = f.getPoint_date().trim().split("-");
	    	String dtx = arx[2]+"-"+arx[1]+"-"+arx[0];
	    	
	    	and_clause += " AND job_date = '"+dtx+"'  ";
	    }
	    
	    
	    if(!f.getDate_from().isEmpty() && !f.getDate_to().isEmpty())
	    {
	    	String arx_f[] = f.getDate_from().trim().split("-");
	    	String dtx_f = arx_f[2]+"-"+arx_f[1]+"-"+arx_f[0];
	    	
	    	String arx_t[] = f.getDate_to().trim().split("-");
	    	String dtx_t = arx_t[2]+"-"+arx_t[1]+"-"+arx_t[0];
	    	
	    	
	    	and_clause += " AND job_date BETWEEN '"+dtx_f
	    			+"' AND '"+dtx_t+"'  ";
	    }
	    

	    	try
	    	{
		    	
	    		
	    		String hql = "";	    		
	    		
	    		if(Integer.parseInt(f.getJob_status().trim()) == -1 || Integer.parseInt(f.getJob_status().trim()) == 15)
	    		{
	    			hql = "SELECT M FROM TblJob M  "
	    					+" WHERE M.tblEmployer.id = '"+
	    			    	employer_id+"' AND "
	    			    					+ and_clause;
	    		}
	    		else
	    		{
	    			hql = "SELECT M FROM TblJob M left join M.tblJobStatuses A "
	    					+" WHERE M.tblEmployer.id = '"+
	    			    	employer_id+"' AND "
	    			    					+ and_clause;
	    		}
		    	
		    	result = dao_job.excuteHQL(hql);
		    	
		    	//System.out.println("==========="+hql);
				
		    	boolean match_name;
		    	String check_name;
		    	
		    	if(result.size() > 0)
		    	{
		    		Iterator<TblJob> it_jobs = result.iterator();
		    		while(it_jobs.hasNext())
		    		{
			    		j_status = (TblJob)it_jobs.next();
			    		
			    		match_name = false;
			    		if(name_filter.isEmpty())
			    		{
			    			match_name = true;
			    		}
			    		else
			    		{
				    		Set<TblJobStatus> s_i = j_status.getTblJobStatuses();
				    		Iterator i_i = s_i.iterator();
				    		while(i_i.hasNext())
				    		{
				    			TblJobStatus t_i = (TblJobStatus)i_i.next();
				    			if(t_i.getJobStatus() != 9)
				    			{
					    			check_name = t_i.getTblEmployee().getFirstName()+""+t_i.getTblEmployee().getLastName();
					    			if(check_name.indexOf(name_filter) != -1)
					    			{
					    				match_name = true;
					    				break;
					    			}
				    			}
				    		}
			    		}
			    		
			    		if(match_name)
			    		{
			    			m_list.add(j_status);
			    		}
		    		}
		    	}
	    	}
	    	catch(Exception ex)
	    	{
	    		ex.printStackTrace();
	    	}
		
		return m_list;
	}
	
	
	
	
	
	public Set<TblJobStatus> getByJobAndStatus(int job_id, String status) {
		
		String[] split = status.split(",");
		
		String and_clause = "1 = 1";
		
		for(int i = 0 ; i < split.length ; i++)
		{
			split[i] = " job_status = '"+split[i]+"' ";
		}
		
		and_clause = and_clause.join(" OR ", split);
		
		try
		{
			DAO<TblJobStatus> dao = new DAO<TblJobStatus>();
			//System.out.println("====="+"FROM TblJobStatus C WHERE tbl_job_id = '"+job_id+"' AND ("+ and_clause +")");
			Set s = dao.excuteHQL("FROM TblJobStatus C WHERE tbl_job_id = '"+job_id+"' AND ("+ and_clause +")");
			return s;
			
		}
		catch(Exception e)
		{
			return null;
		}
	} 
	
	
	public Message assignJob(String employee_id, String job_id)
	{
		try
		{
			TblJobStatus o;
			DAO<TblJobStatus> dao = new DAO<TblJobStatus>();
			
			dao.executeUpdateHQL("update TblJobStatus set job_status = '9' where tbl_job_id = '"+job_id+"'");
			
			Set<TblJobStatus> s = dao.excuteHQL("FROM TblJobStatus C WHERE tbl_job_id = '"+job_id+"' AND tbl_employee_id = '"+employee_id+"'");
			Iterator<TblJobStatus> it = s.iterator();
			
			if(s.size() <= 0)
			{
				Message m = new Message();
				m.prepareMessage(MessageCode.OPERATION_FAILED);
				return m;
			}
			
			o = (TblJobStatus)it.next();
			o.setJobStatus((byte)1);
			dao.insertOrUpdate(o);
			
			
			
			Message m = new Message();
			m.prepareMessage(MessageCode.OPERATION_SUCCESSFUL);
			
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
	public TblJobStatus getById(String id) {
		DAO<TblJobStatus> dao = new DAO<TblJobStatus>();
		return dao.findById(Integer.parseInt(id), TblJobStatus.class);
	}

	@Override
	public Set<TblJobStatus> getAll() {
		DAO<TblJobStatus> dao = new DAO<TblJobStatus>();
		return dao.getAll(TblJobStatus.class);
	}
		
}
