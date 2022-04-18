package com.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.model.User;

@Service
public class UserService {
	@Autowired
	UserDAO UserDAOImpl;
	
	public void add(User user)
	{
		UserDAOImpl.addUser(user);
	}
	public boolean update(User user)
	{
		return UserDAOImpl.updateUser(user);
	}
	public boolean delete(int id)
	{
		return UserDAOImpl.deleteUser(id);
	}
	public User find(int id)
	{
		return UserDAOImpl.findUser(id);
	}
	public List<User> findAll()
	{
		return UserDAOImpl.findAllUser();
	}
}
