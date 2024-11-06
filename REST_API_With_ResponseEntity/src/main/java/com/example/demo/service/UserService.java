package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.User;


public interface UserService {
	
	
	public User saveUser(User user);
	public User updateUser(Integer id,User user);
	public User getUser(Integer id);
	public List<User> getUsers();
	public Integer deleteUser(Integer id);
	public List<User> findByName(String str);
	public List<User> findByNameandlastname(String name,String lastname);
	

}
