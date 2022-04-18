package com.dao;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.flightPackage.Admin;

@Component
public class AdminDAOImpl implements AdminDAO 
{
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public void addAdmin(Admin admin) 
	{
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.save(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
	}

	@Override
	public Admin findAdmin(int id) 
	{
		Session session = sessionFactory.openSession();
		Admin admin = session.get(Admin.class,id);
		return admin;
	}

	@Override
	public List<Admin> findAllAdmin() 
	{
		Session session = sessionFactory.openSession();
		List<Admin> adminlist = session.createQuery("select a from Admin a").list();
		return adminlist;
	}

	@Override
	public boolean updateAdmin(Admin admin) 
	{
		Session session = sessionFactory.openSession();
		session.getTransaction().begin();
		session.update(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return true;
	}

	@Override
	public boolean deleteAdmin(int id) 
	{
		Session session = sessionFactory.openSession();
		Admin admin=session.find(Admin.class,id);
		session.getTransaction().begin();
		session.delete(admin);
		session.flush();
		session.getTransaction().commit();
		session.close();
		return false;
	}

	@Override
	public boolean checkAdmin(String userName, String password) 
	{
		Session session = sessionFactory.openSession();
		Query query = session.createQuery("select a from Admin a where userName=:uname and password=:pass");
		query.setParameter("uname",userName);
		query.setParameter("pass",password);
		List list=query.list();
		if(list.size()>0)
		{
			return true;
		}
		return true;
	}
}
