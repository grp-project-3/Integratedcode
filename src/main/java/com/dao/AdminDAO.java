package com.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.flightPackage.*;

@Repository
public interface AdminDAO 
{
	public void addAdmin(Admin admin);
	public Admin findAdmin(int id);
	public List<Admin> findAllAdmin();
	public boolean updateAdmin(Admin admin);
	public boolean deleteAdmin(int id);
	public boolean checkAdmin(String userName,String password);
}
