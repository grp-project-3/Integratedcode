package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flightPackage.Admin;

@Service
public class AdminService 
{
	@Autowired
	AdminDAO adminDAOImpl;
	
	public void add(Admin admin)
	{
		adminDAOImpl.addAdmin(admin);
	}
	
	public Admin find(int id)
	{
		return adminDAOImpl.findAdmin(id);
	}
	
	public List<Admin> findAll()
	{
		return adminDAOImpl.findAllAdmin();
	}
	
	public boolean update(Admin admin)
	{
		return adminDAOImpl.updateAdmin(admin);
	}
	
	public boolean delete(int id)
	{
		return adminDAOImpl.deleteAdmin(id);
	}
	
	public boolean checkAdmin(String userName,String password)
	{
		return adminDAOImpl.checkAdmin(userName,password);
	}
}
