package com.nurseaid.core;


import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;

import com.nurseaid.model.TblJob;

/**
 *
 * @author Nimesh
 */
public class DAO<T> 
{
    
    Session session = null;

    public DAO() {
        this.session = HUtil.getSessionFactory().openSession();
    }
    
    public T insertOrUpdate(T obj) throws Exception
    {
        try {
                Transaction tx = this.session.beginTransaction();
                this.session.saveOrUpdate(obj);
                tx.commit();
                return obj;

        } catch (Exception re) {
                System.out.println("Error in : " + this.getClass().getName() + obj.getClass() + " insertOrUpdate()");
                throw re;
        }
    }
    
    
    
    public int insertOrUpdateList(List<T> obj_list) throws Exception
    {
        try {  
                for(T item : obj_list) {           	
                	this.session = HUtil.getSessionFactory().openSession();
            		Transaction tx = this.session.beginTransaction();
                	this.session.save(item);
                	tx.commit();
                    this.session.close();
                }                
                return obj_list.size();

        } catch (Exception re) {
                System.out.println("Error in : " + this.getClass().getName() + " insertOrUpdate()");
                throw re;
        }
    }
    
    public void delete(T obj) throws Exception
    {
        try {
                Transaction tx = this.session.beginTransaction();
                this.session.delete(obj);
                tx.commit();
        } catch (Exception re) {
                System.out.println("Error in : " + this.getClass().getName() + obj.getClass() + " delete()");
                throw re;
        }
    }
    
    public T findById(int id, Class c)
    {
        try {
                Transaction tx = this.session.beginTransaction();
                T instance = (T) this.session.get(c, id);
                return instance;
        } catch (Exception re) {
                System.out.println("Error in : " + this.getClass().getName() + c.getClass() + " findById()");
                return null;
        }
    }
    
    
    public Set excuteHQL(String hql) throws Exception
    {		
        try {
                Transaction tx = this.session.beginTransaction();
                //String hql = "FROM MCategory C WHERE title LIKE '%w%'";
                Query query = this.session.createQuery(hql);
                List results = query.list();
                return new HashSet(results);
        } catch (Exception re) {
                System.out.println("Error in : " + this.getClass().getName() + hql + " excuteHQL()");
                throw re;
        }
    }
    
    
    public int executeUpdateHQL(String hql) throws Exception
    {		
    	
        try {
                Transaction tx = this.session.beginTransaction();
                //String hql = "FROM MCategory C WHERE title LIKE '%w%'";
                Query query = this.session.createQuery(hql);
                return query.executeUpdate();
                
        } catch (Exception re) {
                System.out.println("Error in : " + this.getClass().getName() + hql + " excuteHQL()");
                throw re;
        }
    }
    
    
    public Set getAll(Class c)
    {		
        try {
                Transaction tx = this.session.beginTransaction();
                List results = this.session.createCriteria(c).addOrder(Order.asc("id")).list();               
                return new HashSet(results);
        } catch (Exception re) {
                System.out.println("Error in : " + this.getClass().getName() + c + " getAll()");
                return null;
        }
    }
    
    public Set excuteSQL(String sql, Class c) throws Exception
    {		
        try {
                Transaction tx = this.session.beginTransaction();
                SQLQuery query = this.session.createSQLQuery(sql);
                query.addEntity(c);
                List results = query.list();
                return new HashSet(results);
        } catch (Exception re) {
                System.out.println("Error in : " + this.getClass().getName() + c.getClass() + " excuteSQL()");
                throw re;
        }
    }
    
}
